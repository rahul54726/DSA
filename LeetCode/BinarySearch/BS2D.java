package com.LeetCode.BinarySearch;

import java.util.Arrays;
public class BS2D {
    static int[] linearSearchIn2D(int[][] arr, int target){
        for(int row = 0;row<arr.length;row++){
            for(int col = 0 ;col < arr[0].length;col++){
                if(arr[row][col]==target) {
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{-1,-1};
    }
    static int[] BSIn2D(int[][] arr,int target){
        int row = 0;
        int col = arr[0].length - 1;
        while (row < arr.length && col >= 0){
            if (arr[row][col]==target) {
                return new int[]{row, col};
            }
            else if (arr[row][col] > target){
                col--;
            }
            else {
                row++;
            }
        }
        return new int[]{-1,-1};
    }
    static  int[] search(int[][] matrix,int target){
        int rows = matrix.length;
        int cols= matrix[0].length;
        if(rows == 1){
            return BS(matrix,0,0,cols-1,target);
        }
        int rStart = 0;
        int rEnd =rows - 1;
        int cMid = cols/2;
        while (rStart<(rEnd-1)){
            //more than two rows
            int mid = rStart + (rEnd - rStart) / 2;
            if(matrix[mid][cMid] == target ){
                return new int[]{mid,cMid};
            }
            else if(matrix[mid][cMid] < target){
                rStart = mid ;
            }
            else {
                rEnd = mid;
            }

        }
            //now we have two rows
            // check target is in col of 2 rows
        if(matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }
        if(matrix[rEnd+1][cMid] == target) {
            return new int[]{rEnd +1, cMid};
        }
        // search in 1st half
        if(target <= matrix[rStart][cMid-1]){
            return BS(matrix,rStart,0,cMid-1,target);
        }
        // search in 2nd half
        if(target <= matrix[rStart][cMid+1] && target <= matrix[rStart][cols-1] ){
            return BS(matrix,rStart,cMid+1,cols-1,target);
        }
        // search in 3rd half
        if(target >= matrix[rStart+1][cMid-1] ){
            return BS(matrix,rStart +1,0,cMid-1,target);
        }
        // search in 4th half
        else {
            BS(matrix,rStart+1,cMid+1,cols-1,target);
        }
        return new int[]{-1,-1};
    }
    private static int[] BS(int[][] matrix,int row,int cStart,int cEnd,int target){
        if(cStart>cEnd) return new int[]{-1,-1};
        int mid = cStart + (cEnd - cStart) / 2;
        if(matrix[row][mid] == target) return new int[]{row,mid};
        if(target>matrix[row][mid]) return BS(matrix,row,mid+1,cEnd,target);
        else return BS(matrix,row,cStart,mid-1,target);
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60},
//                {33,34,38,50},
        };
        System.out.println(Arrays.toString(linearSearchIn2D(arr,37)));
        System.out.println(Arrays.toString(BSIn2D(arr,37)));
    }
}
