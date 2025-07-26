package com.LeetCode.Hard;

import java.util.ArrayList;
import java.util.List;

public class MinimumScore {
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] xorVal = new int[n];
        int[] inTime = new int[n];
        int[] outTime = new int[n];
        int[] count = {0};
        dfsUtil(0,-1,nums,adj,xorVal,inTime,outTime,count);
        int res = Integer.MAX_VALUE;
        for (int u = 1;u<n;u++){
            for(int v = u + 1 ;v < n;v++){
                if(inTime[v]>inTime[u] && inTime[v] < outTime[u]){
                    res = Math.min(
                            res,
                            getDiff(xorVal[0]^ xorVal[u],xorVal[u] ^ xorVal[v],xorVal[v])
                    );
                }
                else if(inTime[u]>inTime[v] && inTime[u] < outTime[v]){
                    res = Math.min(
                            res,
                            getDiff(xorVal[0]^ xorVal[v],xorVal[v] ^ xorVal[u],xorVal[u])
                    );
                }
                else {
                    res = Math.min(
                            res,
                            getDiff(xorVal[0]^ xorVal[u] ^ xorVal[v],xorVal[u],xorVal[v]));

                }
            }
        }
        return res;
    }

    private int getDiff(int part1, int part2, int part3) {
        return  Math.max(part1,Math.max(part2,part3)) -
                Math.min(part1,Math.min(part2,part3));
    }

    private void dfsUtil(
            int node,
            int parent,
            int[] nums,
            List<List<Integer>> adj,
            int[] xorVal,
            int[] inTime,
            int[] outTime,
            int[] count) {
        inTime[node] = count[0]++;
        xorVal[node] = nums[node];
        for(int child:adj.get(node)){
            if(child == parent){
                continue;
            }
            dfsUtil(child,node,nums,adj,xorVal,inTime,outTime,count);
            xorVal[node] ^= xorVal[child];
        }
        outTime[node] = count[0];
    }
}
