package com.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalMST {
    static int kruskalMST(int V, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int mstCost = 0, count = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            int pu = find(u, parent);
            int pv = find(v, parent);

            if (pu != pv) {
                mstCost += w;
                union(pu, pv, parent, rank);
                if (++count == V - 1) break;
            }
        }
        return mstCost;
    }

    static int find(int x, int[] parent) {
        if (parent[x] != x)
            parent[x] = find(parent[x], parent);
        return parent[x];
    }

    static void union(int a, int b, int[] parent, int[] rank) {
        if (rank[a] < rank[b]) parent[a] = b;
        else if (rank[a] > rank[b]) parent[b] = a;
        else {
            parent[b] = a;
            rank[a]++;
        }
    }

}
