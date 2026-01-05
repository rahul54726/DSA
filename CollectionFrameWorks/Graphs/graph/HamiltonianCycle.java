package com.CollectionFrameWorks.Graphs.graph;

public class HamiltonianCycle {
    private  int V;
    private int[][] graph;
    private int[] path;

    public HamiltonianCycle(int[][] graph) {
        this.V = graph.length;
        this.graph = graph;
        this.path = new int[this.V];
        path[0] = 0;
        for (int i = 1;i<this.V;i++) path[i] = -1;
    }
    private boolean isSafe(int v , int pos){
        if(graph[path[pos-1]][v] == 0) return false;
        for (int i = 0;i < pos;i++){
            if (path[i] == v) return false;
        }
        return true;
    }
    private  boolean solve(int pos){
        if (pos == V) {
            return graph[path[pos - 1]][path[0]] == 1;
        }
        for (int v = 1;v < V;v++){
            if (isSafe(v,pos)){
                path[pos] = v;
                if (solve(pos+1)) return true;
                path[pos] = -1;
            }
        }
        return false;
    }
    private boolean hasHamiltonianCycle(){
        return solve(1);
    }
    public static void main(String[] args) {

        // ✅ Hamiltonian graph (cycle exists)
        int[][] graph1 = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };

        HamiltonianCycle hc1 = new HamiltonianCycle(graph1);
        System.out.println(
                hc1.hasHamiltonianCycle()
                        ? "Graph1 has a Hamiltonian Cycle"
                        : "Graph1 does NOT have a Hamiltonian Cycle"
        );

        // ❌ Non-Hamiltonian graph (tree)
        int[][] graph2 = {
                {0, 1, 0, 0},
                {1, 0, 1, 1},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        };

        HamiltonianCycle hc2 = new HamiltonianCycle(graph2);
        System.out.println(
                hc2.hasHamiltonianCycle()
                        ? "Graph2 has a Hamiltonian Cycle"
                        : "Graph2 does NOT have a Hamiltonian Cycle"
        );
    }
}
