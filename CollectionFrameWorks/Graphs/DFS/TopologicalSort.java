package com.CollectionFrameWorks.Graphs.DFS;
import com.Pair;

import java.util.*;

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
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
    private void dfs(int node,boolean[] visited,Stack<Integer> stack){
            visited[node] = true;
            for (int neighbor : adj[node]){
                if (!visited[neighbor]){
                    dfs(neighbor,visited,stack);
                }
            }
            stack.push(node);

    }
    // kahn's algorithm
    private List<Integer> topologicalSortUsingBFS(){
        List<Integer> result = new ArrayList<>();
        int[] inDegree = new int[this.V];
        for (int u = 0;u<this.V;u++){
            for (int v : adj[u]){
                inDegree[v]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0;i<this.V;i++) {
            if(inDegree[i] == 0) que.offer(i);
        }
        while (!que.isEmpty()){
            int node = que.poll();
            result.add(node);
            for (int neighbor : adj[node]){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) que.offer(neighbor);
            }
        }
        return result;
    }
    public boolean isCyclicUsingBFS(){
            int[] inDeg = new int[this.V];
            for (int u = 0;u<this.V;u++){
                for (int v : this.adj[u]){
                    inDeg[v]++;
                }
            }
            Queue<Integer> que = new LinkedList<>();
            for (int i = 0;i<this.V;i++){
                if (inDeg[i] == 0) que.offer(i);
            }
            int count = 0;
            while (!que.isEmpty()){
                int node = que.poll();
                count++;
                for (int neighbor:this.adj[node]){
                    inDeg[neighbor]--;
                    if(inDeg[neighbor] == 0) que.offer(neighbor);
                }
            }
            return count != this.V;
    }
    public int[] shortestPath(int M , int N , int[][] edges){
            ArrayList<ArrayList<Pair<Integer>>> adj = new ArrayList<>();
            for (int i = 0 ;i < N ; i++){
                adj.add(new ArrayList<>());
            }
            for (int i = 0;i < M ; i++){
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];
                Pair<Integer> edge = new Pair<>(v , wt);
                adj.get(u).add(edge);
            }
            boolean[] vis = new boolean[N];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0;i<N;i++){
                if(!vis[i]){
                    callDFS(i , stack,adj,vis);
                }
            }
            int[] dist = new int[N];
            Arrays.fill(dist , (int) 1e9);
            dist[0] = 0;
            while (!stack.isEmpty()){
                int node = stack.pop();
                for (Pair<Integer> neighbor : adj.get(node)){
                    int v = neighbor.getFirst();
                    int wt = neighbor.getSecond();
                    if(dist[node] + wt < dist[v]){
                        dist[v] = dist[node] + wt;
                    }
                }
            }
            for (int i = 0;i<N;i++){
                if (dist[i] == (int) 1e9 ) dist[i] = -1;
            }
            return dist;
    }

        private void callDFS(int start, Stack<Integer> stack, ArrayList<ArrayList<Pair<Integer>>> adj, boolean[] vis) {
            vis[start] = true;
            for (Pair<Integer> edge : adj.get(start)){
                if (!vis[edge.getFirst()]){
                    callDFS(edge.getFirst(), stack , adj , vis);
                }
            }
            stack.push(start);
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 1);
        graph.addEdge(5, 4);
        Graph graph1 = new Graph(6);
        graph1.addEdge(0,1);
        graph1.addEdge(0,4);
        graph1.addEdge(1,2);
        graph1.addEdge(2,3);
        graph1.addEdge(4,2);
        graph1.addEdge(4,5);
        graph1.addEdge(5,3);


        System.out.print("Topological Sort: ");
        graph1.topologicalSort();
        System.out.println();
        System.out.print("Topological Sort using BFS: ");
        System.out.println(graph1.topologicalSortUsingBFS());
        System.out.println(graph1.isCyclicUsingBFS());
    }
}
