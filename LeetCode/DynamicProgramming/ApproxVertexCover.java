package com.LeetCode.DynamicProgramming;

import java.util.LinkedList;

public class ApproxVertexCover {
    private final int V;   // No. of vertices
    private final LinkedList<Integer>[] adj; // Adjacency List

    // Constructor
    ApproxVertexCover(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Undirected Graph
    }

    // The Approximation Algorithm
    void printVertexCover() {
        // visited[] keeps track of which vertices are already covered/removed
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        System.out.println("The Approximate Vertex Cover is:");

        // Iterate over all edges
        for (int u = 0; u < V; u++) {
            // Check all adjacent vertices of u
            for (int v : adj[u]) {
                // If neither u nor v is visited, it means this edge (u,v)
                // is not yet covered. So, we pick this edge.
                if (!visited[u] && !visited[v]) {

                    // Add both u and v to the result set
                    visited[u] = true;
                    visited[v] = true;

                    System.out.print(u + " " + v + " ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // Create a graph (Example: Triangle + extra edges)
        ApproxVertexCover g = new ApproxVertexCover(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2); // 0-1-2 Triangle
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);

        g.printVertexCover();
    }
}
