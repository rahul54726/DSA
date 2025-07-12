package com.DSAMaths;
import java.util.*;
public class ColoredCells {
    public static long coloredCells(int n) {
        return (long) (Math.pow(n,2)+Math.pow((n-1),2));
    }
    public static void main(String[] args){
        System.out.println(coloredCells(4));
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    private  static List<Integer> findMaxConsecutiveOnes(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int count = 0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;

            }
            else{
                count=0;
            }
            max=Math.max(count,max);
            list.add(count);
        }
        return list;
    }
}
