package com.LeetCode.Graph;

import java.util.*;

public class FindCheapestPrice {
    class Pair{
        int first;
        int second;
        public Pair(int f , int s){
            this.first = f;
            this.second = s;
        }
    }
    public  int findCheapestPrice(int n,
                                        int[][] flights,
                                        int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0;i < n;i++) adj.add(new ArrayList<>());
        int m = flights.length;
        for (int i = 0; i < m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<int[]> que = new LinkedList<>();
        int[] dist = new int[n];
        que.offer(new int[]{0,src ,0});
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        while (!que.isEmpty()){
            int[] curr = que.poll();
            int stops = curr[0];
            int node = curr[1];
            int cost = curr[2];
            if (stops > k) continue;
            for (Pair pair : adj.get(node)){
                int adjNode = pair.first;
                int wt = pair.second;
                if (cost+wt < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost+wt;
                    que.offer(new int[]{stops + 1 , adjNode , cost + wt});
                }
            }
        }
            return dist[dst] == (int) 1e9 ? -1 : dist[dst];

    }
    public static void main(String[] args) {

    }
}
