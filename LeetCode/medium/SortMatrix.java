package com.LeetCode.medium;

import java.util.*;

public class SortMatrix {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int row = 0;row < n;row++){
            sortDiag(row,0,grid , false);
        }
        for (int col = 1; col < n; col++){
            sortDiag(0,col,grid,true);
        }
        return grid;
    }

    private void sortDiag(int row, int col, int[][] grid,boolean ascending) {
        int i = row;
        int j = col;
        List<Integer> diagonal = new ArrayList<>();
        while (i<grid.length && j < grid.length){
            diagonal.add(grid[i++][j++]);
        }
        if (ascending){
            Collections.sort(diagonal);
        }
        else {
            diagonal.sort(Collections.reverseOrder());
        }
        i = row;
        j = col;
        for (int num:diagonal){
            grid[i++][j++] = num;
        }
    }

    private static List<List<Integer>> getDiagonal(int[][] matrix) {
        int n = matrix.length;
        List<List<Integer>> res = new ArrayList<>();

        // d = i - j (constant along a ↘ diagonal)
        for (int d = -(n - 1); d <= (n - 1); d++) {
            List<Integer> diag = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int j = i - d;              // j = i - d
                if (j >= 0 && j < n) {
                    diag.add(matrix[i][j]); // visit from top to bottom
                }
            }
            res.add(diag);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(getDiagonal(new int[][]{
                {1, 7, 3},
                {9, 8, 2},
                {4, 5, 6}}));
    }
}
