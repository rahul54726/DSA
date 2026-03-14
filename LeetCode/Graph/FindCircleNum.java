package com.LeetCode.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FindCircleNum {
    int n ;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] visted = new boolean[n];
        HashMap<Integer,LinkedList<Integer>> adj = new HashMap<>();
        for (int i = 0;i<n;i++){
            adj.put(i,new LinkedList<>());
        }
        for (int i = 0 ;i<n;i++){
            for (int j = 0;j<n;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        for (int i = 1;i<=n;i++){
            if(!visted[i]){
                solve(i,visted,adj);
                count++;
            }
        }
        return count;
    }

    private void solve(int i, boolean[] visted, HashMap<Integer, LinkedList<Integer>> adj) {
        visted[i] = true;
        for (int v : adj.get(i)){
            if (!visted[v]) solve(v,visted,adj);
        }
    }

private void bfs(int i , boolean[] visted, HashMap<Integer,LinkedList<Integer>> adj){
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(i);
    visted[i] = true;
    while (!queue.isEmpty()){
        int v =  queue.poll();
        for (int neighbor : adj.get(i)){
            if (!visted[neighbor]){
                queue.offer(neighbor);
            }
        }
    }

}
}
