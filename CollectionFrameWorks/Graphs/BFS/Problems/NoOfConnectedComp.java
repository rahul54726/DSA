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
    public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        HashSet<Integer> horDiff = new HashSet<>();
        HashSet<Integer> verDiff = new HashSet<>();
        for(int i = 0;i<hFences.length;i++){
            if(!horDiff.contains(hFences[i] - 1)) horDiff.add(hFences[i]);
            if(!horDiff.contains(m - hFences[i] + 1)) horDiff.add(m - hFences[i] + 1);
            for (int j = i;j<hFences.length;j++){
                if(!horDiff.contains(Math.abs(hFences[j] - hFences[i] + 1))) horDiff.add(Math.abs(hFences[j] - hFences[i] + 1));
            }
        }
        for(int i = 0;i<vFences.length;i++){
            if(!verDiff.contains(vFences[i])) verDiff.add(vFences[i]);
            if(!verDiff.contains(n - vFences[i] + 1)) verDiff.add(n - vFences[i] + 1);
            for (int j = i;j<vFences.length;j++){
                if(!verDiff.contains(Math.abs(vFences[j] - vFences[i] + 1))) verDiff.add(Math.abs(vFences[j] - vFences[i] + 1));
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num : horDiff){
            if(verDiff.contains(num)) max = Math.max(max, num);
        }
        return (max * max) % 1000000007;
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
        System.out.println(maximizeSquareArea(4 , 3 , new int[]{2,3},new int[]{2}));

    }
}
