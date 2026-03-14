package com.CollectionFrameWorks.Graphs.BFS.Problems;

import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {

    }
    public static boolean isBipartite(ArrayList<Integer>[] adj){
        int[] vis = new int[adj.length];
        Arrays.fill(vis , -1);
        for (int i = 0;i<adj.length;i++){
            if (vis[i] == -1 && !check(i , adj , vis)){
                return false;
            }
        }
        return true;
    }
    private static boolean check(int start , ArrayList<Integer>[] adj , int[]vis){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        vis[start] = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int ne : adj[start]){
                if (vis[ne] == -1){
                    vis[ne] = 1 - vis[node];
                    queue.offer(ne);
                }
                else if (vis[ne] == vis[node]) return false;
            }
        }
        return true;
    }
}
