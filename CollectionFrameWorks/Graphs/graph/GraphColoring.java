package com.CollectionFrameWorks.Graphs.graph;

public class GraphColoring {
    private final  int V;
    private final  int[][] graph;
    private final  int[] colors;


    public GraphColoring(int V, int[][] graph, int[] colors) {
        this.V = V;
        this.graph = graph;
        this.colors = colors;
    }
    private boolean isSafe(int v,int c){
        for (int i = 0;i<this.V;i++){
            if (graph[v][i] == 1 && colors[i] == c) return false;
        }
        return true;
    }
    private boolean solve(int v,int maxColors){
        if(v == V) return true;
        for (int c = 1;c<=maxColors;c++){
            if(isSafe(v,c)){
                colors[v]=c;
                if (solve(v + 1, maxColors)) return true;
                colors[v] = 0;
            }
        }
        return false;
    }
    public boolean color(int maxColor){
        return solve(0,maxColor);
    }
    public int[] getColors(){
        return this.colors;
    }
}
