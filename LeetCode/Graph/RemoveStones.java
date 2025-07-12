package com.LeetCode.Graph;

import java.util.Stack;

public class RemoveStones {
    public static int removeStones(int[][] stones) {
        int groups = 0;
        Stack<int[]> stack = new Stack<>();
        boolean[] visited = new boolean[stones.length];
        for(int i = 0;i<stones.length;i++){
            if(visited[i] )continue;
            dfs(stones,i,visited);
            groups++;
        }
        return stones.length - groups;
    }
    private static void dfs(int[][] stones,int index,boolean[] visited){
        visited[index] = true;
        for(int i = 0;i<stones.length;i++){
            int r = stones[index][0];
            int c = stones[index][1];
            if(!visited[i] &&( stones[i][0] == r || stones[i][1]==c)){
                dfs(stones,i,visited);
            }
        }

    }
}
