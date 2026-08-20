package com.PatternPrinting;

import java.util.ArrayList;
import java.util.List;

public class BrainStorming {
    public static void main(String[] args) {
        leftTriangle(4);
        rightTriangle(5);
        hollowSquare(5);
        fullPyramid(5);
        fullHollowPyramid(5);
        diamond(5);
//        invertedPyramid(5);
        butterfly(5);
        int[][] mat = {
                {1},{2},{3}

        };
        System.out.println(spiral(mat));
    }
    public static void leftTriangle(int row){

        for(int i = 0;i <row;i++){
            for(int j = 0; j < row;j++){
                if(j <= i) System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void rightTriangle(int row){

        for(int i = 0;i <row;i++){
            for(int j = 0; j < row;j++){
                if (j >= row - i - 1) System.out.print("*");
                else System.out.print("_");
            }
            System.out.println();
        }
    }

    public static void hollowSquare(int row){
        for(int i = 0; i < row;i++){
            for (int j = 0;j < row;j++){
                if (i == 0 || i == row - 1) System.out.print("*");
                else if (j == 0 || j == row - 1) System.out.print("*");
                else System.out.print("_");
            }
            System.out.println();
        }
    }
    public static void fullPyramid(int rows){

        for(int i = 1;i <=rows;i++){
            for (int j = 1;j <= rows - i;j++){
                System.out.print("_");
            }
            for (int j = 1 ; j<=2 * i - 1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }public static void invertedPyramid(int rows){

        for(int i = rows;i >= 1;i--){
            for (int j = 1;j <= rows - i;j++){
                System.out.print("_");
            }
            for (int j = 1 ; j<=2 * i - 1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void fullHollowPyramid(int rows){

        for(int i = 1;i <=rows;i++){
            for (int j = 1;j <= rows + i - 1 ; j++){
                if (j == rows - i + 1 || j == rows + i - 1) System.out.print("*");
                else if (i == rows) System.out.print("*");
                else System.out.print("_");
            }
            System.out.println();

        }
    }
    public static void diamond(int rows){

        for(int i = 1;i <=rows;i++){
            for (int j = 1;j <= rows - i;j++){
                System.out.print(" ");
            }
            for (int j = 1 ; j<=2 * i - 1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = rows - 1;i >= 1;i--){
            for (int j = 1;j <= rows - i;j++){
                System.out.print("_");
            }
            for (int j = 1 ; j<=2 * i - 1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void butterfly(int row){

        for (int i = 1;i <=row;i++){
            for (int j = 1; j <= i;j++) System.out.print("*");
            for (int j = 1;j <= 2 * (row - i) ; j++) System.out.print("_");
            for (int j = 1; j <= i;j++) System.out.print("*");
            System.out.println();
        }
        for (int i = row-1;i >= 1;i--){
            for (int j = 1; j <= i;j++) System.out.print("*");
            for (int j = 1;j <= 2 * (row - i) ; j++) System.out.print("_");
            for (int j = 1; j <= i;j++) System.out.print("*");
            System.out.println();
        }
    }
    public static List<Integer> spiral(int[][]mat){
        List<Integer> res = new ArrayList<>();
        int row = mat.length;
        int col = mat[0].length;
        int top = 0 , bottom = row - 1, left = 0,  right = col - 1;

        while (top <= bottom && left <= right){
            for (int i = left ; i <= right;i++){
                res.add(mat[top][i]);
            }
            top++;

            for (int i = top ; i <= bottom;i++){
                res.add(mat[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(mat[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(mat[i][left]);
                }
                left++;
            }
            }

        return res;
    }
}
