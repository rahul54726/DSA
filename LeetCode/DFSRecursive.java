package com.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class DFSRecursive {
    public List<Integer> dfs(int start , List<List<Integer>> graph,boolean[] visited,List<Integer> result){
        visited[start] = true;
        result.add(start);
        for(int neoghbors : graph.get(start)){
            if(!visited[neoghbors]){
                dfs(neoghbors,graph,visited,result);
            }
        }
        return result;
    }
    public List<Integer> topologicalSort(int n ,List<List<Integer>> graph){
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs1(i,graph,visited,stack);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
    private void dfs1(int node,List<List<Integer>> graph ,boolean[] visted,Stack<Integer> stack){
        visted[node] = true;
        for(int neighbors:graph.get(node)){
            if(!visted[neighbors]){
                dfs1(neighbors,graph,visted,stack);
            }
        }
        stack.push(node);
    }
    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Define edges
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        DFSRecursive ts = new DFSRecursive();
        List<Integer> result = ts.topologicalSort(n, graph);
        System.out.println("Topological Order: " + result);
    }

}
