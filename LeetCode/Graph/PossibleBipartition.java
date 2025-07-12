package com.LeetCode.Graph;

import java.util.*;

public class PossibleBipartition {
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(int[] nodes : dislikes){
            adj.putIfAbsent(nodes[0],new ArrayList<>());
            adj.get(nodes[0]).add(nodes[1]);
            adj.putIfAbsent(nodes[1],new ArrayList<>());
            adj.get(nodes[1]).add(nodes[0]);

        }
//        System.out.println(adj);
        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        for(int i = 1;i<=n;i++){
            if(color[i] == -1){
                if(!bfs(adj,i,color)) return false;
            }
        }
        return true;
    }

    private static boolean bfs(Map<Integer, ArrayList<Integer>> adj, int i, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        color[i] = 1;
        while (!queue.isEmpty()){
            int u = queue.poll();
            ArrayList<Integer> hates = adj.getOrDefault(u,new ArrayList<>());
            for(int hate: hates){
                if(color[hate] == color[u]){
                    return false;
                }if(color[hate] == -1){
                    queue.add(hate);
                    color[hate] = 1-color[u];
                }

            }
        }
        return true;

    }

    public static void main(String[] args) {
        possibleBipartition(4,new int[][]{{1,2},{1,3},{2,4}});
    }
}
