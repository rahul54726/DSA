package com.CollectionFrameWorks.Graphs.DFS;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    static class Graph{
        int V;
        LinkedList<Integer>[] adj;
        Graph(int V ){
            this.V=V;
            adj=new LinkedList[V];
            for (int i = 0; i < V ; i++) {
                adj[i]=new LinkedList<>();
            }
        }
        void addEdge(int src , int des){
            adj[src].add(des);
        }
    void topologicalSort(){
        boolean[] visited=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < V ; i++) {
            if(!visited[i]){
                dfs(i,visited,stack);
            }

        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    private void dfs(int node,boolean[] visited,Stack<Integer> stack){
            visited[node]=true;
        for (int neighbor:adj[node]) {
            if (!visited[neighbor]){
                dfs(neighbor,visited,stack);
            }
        }
        stack.push(node);
    }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.print("Topological Sort: ");
        graph.topologicalSort();
    }
}
