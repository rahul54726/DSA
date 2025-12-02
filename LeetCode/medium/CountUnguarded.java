package com.LeetCode.medium;

import java.util.Arrays;
import java.util.HashSet;

public class CountUnguarded {
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] maze = new int[m][n];
        for (int[] wall: walls){
            int row = wall[0];
            int col = wall[1];
            maze[row][col] = 1;
        }
        for (int[] guard: guards){
            int row = guard[0];
            int col = guard[1];
            maze[row][col] = 2;
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] guard:guards){
            int row = guard[0];
            int col = guard[1];
            for (int[] d : dirs){
                int nrow = row + d[0] , ncol = col + d[1];
                while (nrow >=0 && nrow < m && ncol >= 0 && ncol < n
                        && maze[nrow][ncol] != 1 && maze[nrow][ncol] != 2 ){
                    if (maze[nrow][ncol] == 0){
                        maze[nrow][ncol] = 3;
                    }
                    nrow += d[0];
                    ncol += d[1];
                }
            }
        }
        int count = 0;
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if (maze[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countUnguarded(3,3,new int[][]{
                {1,1}
        },new int[][]{
                {0,1},
                {1,0},
                {2,1},
                {1,2},
        }));
    }
}
