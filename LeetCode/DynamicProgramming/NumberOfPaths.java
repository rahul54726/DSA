package com.LeetCode.DynamicProgramming;

public class NumberOfPaths {
    public int numberOfPaths(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
         solve(0,0,grid,k,count,0);
         return count;

    }

    private void solve(int row, int col, int[][] grid, int k, int count,int sum) {
          if (row == grid.length-1 && col == grid[0].length-1 ){
              if (sum % k == 0){
                  count++;
              }
              return;
          }
          if(row< grid.length - 1) solve(row+1,col,grid,k,count,sum+grid[row][col]);
          if(col <  grid[0].length - 1) solve(row,col+1,grid,k,count,sum+grid[row][col]);
    }
}
