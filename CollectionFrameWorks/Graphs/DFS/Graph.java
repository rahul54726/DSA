package com.CollectionFrameWorks.Graphs.DFS;

import java.util.ArrayList;
import java.util.*;
import java.util.LinkedList;

public class Graph {
    private int vertices;
    private LinkedList<Integer> [] adj;
    public Graph(int size){
        this.vertices=size;
        adj=new LinkedList[size];
        for (int i=0;i<size;i++){
            adj[i]=new LinkedList<>();
        }
    }
    void addEdge(int src,int des){
        adj[src].add(des);
        adj[des].add(src);
    }
    void DFS(int v){
        boolean[] visited=new boolean[vertices];
        helper(v,visited);
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adjM) {
        // Code here
        boolean[] visited = new boolean[adjM.size()];
        ArrayList<Integer> path = new ArrayList<>();
        help(adjM,visited,path,0);
        return path;
    }

    private void help(ArrayList<ArrayList<Integer>> adjM, boolean[] visited, ArrayList<Integer> path, int i) {
        if(visited[i]) return;
        visited[i]=true;
        path.add(i);
        for(int neighbor: adjM.get(i)){
            if(!visited[neighbor]){
                help(adjM,visited,path,neighbor);
            }
        }
    }

    private void helper(int v, boolean[] visited){
        if(visited[v]) return;
        visited[v]=true;
        System.out.print(v +" ");

        for (int n: adj[v]){
            if (!visited[n]){
                helper(n,visited);
            }
        }
    }

    List<List<Integer>> printAllPath(int src,int des){
        boolean[] visited=new boolean[vertices];
        List<Integer> path=new LinkedList<>();
        List<List<Integer>> allPath=new ArrayList<>();
        System.out.println("Here is all paths to reach from source : " + src+" to destination : "+des);
        helpfun(src,des,visited,path,allPath);
        return allPath;
    }
   private void helpfun(int src, int des, boolean[] visited, List<Integer> path, List<List<Integer>> allPaths){
        visited[src] = true;
        path.add(src);
        if(src == des){
        allPaths.add(new ArrayList<>(path));
        }
        for(int neighbor:adj[src]){
            if(!visited[neighbor]){
                helpfun(neighbor,des,visited,path,allPaths);
            }
        }
        path.removeLast();
        visited[src] = false;

   }
        //for directed graph
   boolean isCyclic(Graph graph){
        boolean[] visited = new boolean[graph.vertices];
        boolean[] recStack = new boolean[graph.vertices];
        for (int i=0;i< graph.vertices;i++){
            if(!visited[i] && dfs(i,graph.adj,visited,recStack)){
                return true;
            }
        }
        return false;
   }
    private  boolean dfs(int node,LinkedList<Integer>[] adj,boolean[] visited,boolean[] recStack){
        visited[node]=true;
        recStack[node]=true;
        for (int neighbor:adj[node]){
            if (!visited[neighbor] && dfs(neighbor,adj,visited,recStack)){
                return true;
            }
            else if ((recStack[neighbor])){
                return true;
            }
        }
        recStack[node]=false;
        return false;
    }

//for bidirected graph//

    public  boolean isCyclicbidirec(Graph graph){
        boolean[] visited=new boolean[vertices];
        for (int i=0;i<vertices;i++){
            if (!visited[i] && bdfs(i,-1,graph.adj,visited)){
                return true;
            }
        }
        return false;
    }
    private boolean bdfs(int node,int parent,LinkedList<Integer>[] adj,boolean[] visited){
        visited[node]=true;
        for (int neighbor : adj[node]){
            if (!visited[neighbor]){
                if (bdfs(neighbor,node,adj,visited)){
                    return true;
                }
            }
            else if (neighbor != parent){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Graph graph=new Graph(5);
        graph.addEdge(0,1);

        graph.addEdge(1,2);
        graph.addEdge(2,3);

        graph.addEdge(3,4);
        graph.addEdge(4,0);


//        graph.DFS(0);
//        System.out.println();
//        graph.printAllPath(0,1);
        System.out.println(graph.isCyclicbidirec(graph));
    }
}
