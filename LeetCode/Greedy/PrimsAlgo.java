package com.LeetCode.Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class  Pair{
        int node ,weight;
        Pair(int n , int w){
            node = n;
            weight = n;
        }
    }
    public static int prims(int V, List<List<Pair>> adj){
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));

        // Start from node 0 with weight 0
        pq.offer(new Pair(0, 0));
        int mstCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int weight = curr.weight;

            if (visited[node]) continue;

            mstCost += weight;
            visited[node] = true;

            for (Pair neigh : adj.get(node)) {
                if (!visited[neigh.node]) {
                    pq.offer(new Pair(neigh.node, neigh.weight));
                }
            }
        }

        return mstCost;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // example edges (u, v, w)
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 3, 6);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 8);
        addEdge(adj, 1, 4, 5);
        addEdge(adj, 2, 4, 7);

        System.out.println("MST Cost: " + prims(V, adj));
    }
    static void addEdge(List<List<Pair>> adj, int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
    }
}
