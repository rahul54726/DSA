package com.CollectionFrameWorks.Graphs.disjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetBySize {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSetBySize(int n){
        for (int i = 0;i <= n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if (node == parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }
    public void unionBySize(int u , int v){
        int ulpU = findUPar(u);
        int ulpV = findUPar(v);

        if (ulpU == ulpV) return;

        if (size.get(ulpU) < size.get(ulpV)){
            parent.set(ulpU , ulpV);
            size.set(ulpV , size.get(ulpU) + size.get(ulpV));
        }
        else {
            parent.set(ulpV , ulpU);
            size.set(ulpU , size.get(ulpU) + size.get(ulpV));
        }
    }
}
