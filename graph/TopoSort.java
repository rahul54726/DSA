package com.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopoSort {
    public static void topoSort(List<List<Integer>> adj){
        int V = adj.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i = 0;i < V ; i++){
            if (!vis[i]){
                dfs(i , stack ,vis , adj);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    private static void dfs(int u, Stack<Integer> stack,
                            boolean[] vis, List<List<Integer>> adj) {
        vis[u] = true;
        for (int v : adj.get(u)){
            if (!vis[v]){
                dfs(v , stack , vis , adj);
            }
        }
        stack.push(u);
    }

    public static void kahnsAlgo(List<List<Integer>> adj){
        int V = adj.size();
        int[] inDegree = new int[V];
        for (List<Integer> integers : adj) {
            for (int v : integers) {
                inDegree[v]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0;i <V;i++){
            if (inDegree[i] == 0) que.offer(i);
        }
        int count = 0;
        while (!que.isEmpty()){
            int curr = que.poll();
            count++;
            if (count > V) {
                System.out.println("cycle Exists");
                break;
            }
            System.out.print(curr + " ");

            for (int nei : adj.get(curr)){
                inDegree[nei]--;
                if (inDegree[nei] == 0) que.offer(nei);
            }
        }
    }
}
