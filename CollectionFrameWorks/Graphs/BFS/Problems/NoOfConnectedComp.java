package com.CollectionFrameWorks.Graphs.BFS.Problems;
import java.util.*;


public class NoOfConnectedComp {
    private Map<Integer,List<Integer>> adj;
    public NoOfConnectedComp(){
        adj=new HashMap<>();
    }
    // add edge to graph
    public void addEdge(int src,int des){
        adj.computeIfAbsent(src,k->new ArrayList<>()).add(des);
        adj.computeIfAbsent(des,k->new ArrayList<>()).add(src);
    }
    //BFS to explore a connected component
    private void bfs(int start,Set<Integer> visited){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()){
            int node=queue.poll();
            for(int neighbors:adj.getOrDefault(node,new ArrayList<>())){
                if (!visited.contains(neighbors)){
                    queue.add(neighbors);
                    visited.add(neighbors);
                }
            }
        }
    }
    public int countConnectedComponents(){
        Set<Integer> visited=new HashSet<>();
        int components=0;
        for (int node:adj.keySet()){
            if (!visited.contains(node)){
                bfs(node,visited);
                components++;
            }
        }
        return components;
    }

    public static void main(String[] args) {
        NoOfConnectedComp graph=new NoOfConnectedComp();
        graph.addEdge(1,2);
        graph.addEdge(1,4);

        graph.addEdge(2,3);
        graph.addEdge(2,4);

        graph.addEdge(3,5);

        graph.addEdge(4,5);

        System.out.println(graph.countConnectedComponents());

    }
}
