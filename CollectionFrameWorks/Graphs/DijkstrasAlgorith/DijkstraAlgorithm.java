package com.CollectionFrameWorks.Graphs.DijkstrasAlgorith;
import  java.util.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;



public class DijkstraAlgorithm {
    int V;
    LinkedList<Edge>[] adj;

    public DijkstraAlgorithm(int size) {
        this.V = size;
        adj=new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adj[i]=new LinkedList<>();
        }
    }
    public void addEdge(int src,int des,int weight){
        adj[src].add( new Edge(des,weight));
        adj[des].add( new Edge(src,weight)); //for undirected graph
    }
    public void dijkstra(int src){
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        int[] dis=new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        queue.offer(new int[]{src,0});
        while (!queue.isEmpty()){
            int[] current=queue.poll();
            int node=current[0];
            int currdis=current[1];
            if (currdis>dis[node]) {
                continue;
            }
            for (Edge edge:adj[node]){
                int newDis=dis[node]+edge.weight;
                if(newDis<dis[edge.des]){
                    dis[edge.des]=newDis;
                    queue.offer(new int[]{edge.des,newDis});
                }
            }
        }
        System.out.println("Shortest Distance from source " + src+":");
        for (int i=0;i<V;i++){
            System.out.println("Node " + i+"->"+dis[i]);
        }
    }
    private class Edge{
        int src;
        int des;
        int weight;

        public Edge(int des, int weight) {
            this.des = des;
            this.weight = weight;
        }
    }
}
