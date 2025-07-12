package com.LeetCode.TWOPOINTER;
import java.util.*;
//import com.Arrays.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
    int[] nums={0,1,0,3,12};
    moveZeroes(nums);

    }
    public static void moveZeroes(int[] nums) {
        int[] arr=new int[nums.length];
        for (int i=0;i<arr.length;i++){
            arr[i]=0;
        }
        //copy all non zero elements
        int start=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                arr[start++]=nums[i];
            }
        }

        nums=arr;
        for (int num : nums){
            System.out.println(num +" ");
        }
    }
}
