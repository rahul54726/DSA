package com.CollectionFrameWorks.Graphs.BFS.Problems;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1]==1) return -1;
        int[][] directions = {
                {1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}
        };
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0],c = current[1],dist = current[2];
            if(r == n-1 && c == n - 1) return dist;
            for (int[] d : directions){
                int nr = r + d[0];
                int nc = r + d[1];
                if (nr>=0 && nr<n && nc>=0 && nc<n &&
                        !visited[nr][nc] && grid[nr][nr] == 0){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc,dist+1});
                }
            }
        }
        return -1;
    }
}
