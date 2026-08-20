package com.graph;

import java.util.List;

public class UDGCycleUsingDFS {
    public static boolean isCyclic(List<List<Integer>> adj){
        int V = adj.size();
        boolean[] visited = new boolean[V];
        for (int i = 0;i < V ; i++){
            if (!visited[i] && dfs(adj , visited , i , -1 )){
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adj,
                               boolean[] visited, int u, int parent) {
        visited[u] = true;

        for (int node : adj.get(u)){
            if (node == parent) continue;;
            if (visited[node]) return true;
            if (dfs(adj , visited,node , u)) return true;
        }
        return false;
    }
    public static boolean isCyclicDirected(List<List<Integer>> adj){
        int V = adj.size();
        boolean[] vis = new boolean[V];
        boolean[] inStack = new boolean[V];

        for (int i = 0;i <V;i++){
            if(!vis[i] && Adfs(i , adj , vis , inStack)){
                return true;
            }
        }
        return false;
    }

    private static boolean Adfs(int u, List<List<Integer>> adj,
                                boolean[] vis, boolean[] inStack) {
        vis[u] = true;
        inStack[u] = true;
        for (int neighbor : adj.get(u)){
            if (!vis[neighbor] && Adfs(neighbor , adj , vis , inStack)) return true;
            else if (inStack[neighbor]) return true;
        }
        inStack[u] = false;
        return false;
    }
}
