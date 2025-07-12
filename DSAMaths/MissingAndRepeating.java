package com.DSAMaths;

import java.util.*;
import java.util.HashMap;

public class MissingAndRepeating {
    public static void main(String[] args) {
        int [][] grid={{1,3},{2,2}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
    }
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int l=grid.length;
        int repeating=-1;
        int missing=-1;
        int[] count=new int[l*l+1];
        for(int[] row:grid){
            for(int num:row){
                count[num]++;
            }
        }
        for(int i = 1;i<=l*l;i++){
            if(count[i]==2){
                repeating=i;
            } else if (count[i]==0) {
                missing=i;
            }
        }
        return new int[]{repeating,missing};
    }
//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//    }
}
