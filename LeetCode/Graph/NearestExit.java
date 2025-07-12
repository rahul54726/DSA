package com.LeetCode.Graph;

import java.util.*;

public class NearestExit {
//    public int nearestExit(char[][] maze, int[] entrance) {
//     if (maze == null) return -1;

//        int m = maze.length;
//        int n = maze[0].length;
//        int steps = 0;
//
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{entrance[0], entrance[1]});
//        maze[entrance[0]][entrance[1]] = '+';
//
//        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int s = 0; s < size; s++) {
//                int[] cell = queue.poll();
//                int i = cell[0];
//                int j = cell[1];
//
//                for (int[] dir : directions) {
//                    int newI = i + dir[0];
//                    int newJ = j + dir[1];
//
//                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && maze[newI][newJ] == '.') {
//                        if (newI == 0 || newI == m - 1 || newJ == 0 || newJ == n - 1) {
//                            return steps + 1;
//                        }
//                        queue.offer(new int[]{newI, newJ});
//                        maze[newI][newJ] = '+';
//                    }
//                }
//            }
//            steps++;
//        }
//        return -1;
//        return helper(maze,entrance,0);
//    }
    int minSteps = Integer.MAX_VALUE;
    int m ,n;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int nearestExit(char[][] maze, int[] entrance) {
       m = maze.length;
       n = maze[0].length;
       dfs(maze,entrance[0],entrance[1],0);
       return minSteps == Integer.MAX_VALUE ? -1:minSteps;
    }
    private void dfs(char[][] maze,int i ,int j,int steps){
        if(i<0 || i>=m || j<0 || j>=n || maze[i][j] != '.') {
            return;
        }
        maze[i][j] = '+';
        if((i == 0 || i == m - 1 || j == 0 || j == n-1) && steps != 0){
            minSteps = Math.min(minSteps,steps);
            maze[i][j] = '.';
            return;
        }
        for(int[] dir:directions){
            dfs(maze,i+dir[0],j+dir[1],steps+1);
        }
        maze[i][j] = '.';
    }
}
