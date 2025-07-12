package com.Array;

import java.util.*;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        LinkedList<int[]> merged= new LinkedList<>();
        for(int[] interval:intervals){
            if(merged.isEmpty() || merged.getLast()[1]<interval[0]){
                merged.add(interval);
            }
            else {
                merged.getLast()[1]=Math.max(merged.getLast()[1],interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
    public static int countNumbersWithUniqueDigits(int n) {
//        int count=0;
//        int range= (int) Math.pow(10,n);
//        for(int i=0;i<range;i++){
//            if (allUnique(i)) count++;
//        }
//        return count;
        if(n==0) return 1;
        int count = 10;
        int uniqueDigits=9,availableNumber=9;
        for(int i=2;i<=n;i++){
            uniqueDigits *= availableNumber;
            count+=uniqueDigits;
            availableNumber--;
        }
        return count;
    }
    private static boolean allUnique(int num){
        Set<Integer> set=new HashSet<>();
        int digits=0;
        while (num!=0){
            set.add(num%10);
            digits++;
            num/=10;
        }
        return set.size()==digits;
    }
    public static void main(String[] args) {
        int num=8;
        System.out.println(countNumbersWithUniqueDigits(num));
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j = 0;j<n/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        rotate(mat);
        if(mat==target) return true;
        rotate(mat);
         if(mat==target) return true;
         rotate(mat);
         if (mat==target) return true;
         rotate(mat);
         if (mat==target) return true;
         else return false;
    }
}
