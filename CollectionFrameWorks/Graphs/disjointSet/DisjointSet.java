package com.CollectionFrameWorks.Graphs.disjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n){
        for (int i = 0;i <= n;i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node){
        if (node == parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }
    public void unionByRank(int u , int v){
        int ulpU = findUPar(u);
        int ulpV = findUPar(v);
        if (ulpU == ulpV) return;
        if (rank.get(ulpU) < rank.get(ulpV)){
            parent.set(ulpU , ulpV);
        }
        else if (rank.get(ulpU) > rank.get(ulpV)){
            parent.set(ulpV , ulpU);
        }
        else {
            parent.set(ulpU , ulpV);
            int rankU = rank.get(ulpU);
            rank.set(ulpU , rankU + 1);
        }
    }
}
