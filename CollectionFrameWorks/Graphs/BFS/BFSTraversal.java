package com.CollectionFrameWorks.Graphs.BFS;

import java.util.*;

public class BFSTraversal {
    private Map<Integer,List<Integer>> adjList;
    public BFSTraversal(int vertices){
        adjList=new HashMap<>();
        for (int i=0;i<vertices;i++){
            adjList.put(i,new ArrayList<>());
        }
    }
    public void addEdge(int src,int des){
        adjList.get(src).add(des);
        adjList.get(des).add(src);
    }
    public ArrayList<Integer> bfs(int start){
        boolean[] visited=new boolean[adjList.size()];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(start);
        visited[start]=true;
        ArrayList<Integer> result=new ArrayList<>();

        while(!queue.isEmpty()){
            int node=queue.poll();
            result.add(node);
            for (int neb:adjList.get(node)){
                if (!visited[neb]){
                    visited[neb]=true;
                    queue.offer(neb);
                }
            }
        }
        return result;
    }
//iscyclic
    public boolean isCyclic(List<List<Integer>> graph){
        int n = graph.size();
        boolean[] visited = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!visited[i] && check(graph,visited,i)){
                return true;
            }
        }return false;
    }

    private boolean check(List<List<Integer>> graph, boolean[] visited, int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start,-1});
        visited[start] = true;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];
            for(int neighbor:graph.get(node)){
                if (!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor,node});
                }
                else if(neighbor != parent){
                    return true;
                }
            }
        }
        return false;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visted = new boolean[flights.length];
        queue.offer(flights[0]);
        visted[flights[0][0]] = true;
        while (!queue.isEmpty()){
            int [] start = queue.poll();
            int from = start[0];
            int to = start[1];
            int fair = start[2];

        }
        return 0;
    }
    public static void main(String[] args) {
        BFSTraversal graph=new BFSTraversal(8);
        graph.addEdge(2,1);

        graph.addEdge(0,1);
        graph.addEdge(0,3);

        graph.addEdge(3,4);
        graph.addEdge(3,7);

        graph.addEdge(4,5);
        graph.addEdge(4,6);

        graph.addEdge(5,6);

        graph.addEdge(6,7);
        System.out.println(graph.bfs(2));

    }
}
