package com.LeetCode.days75;

import java.util.HashSet;

public class mergedString {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int i=0,j=0;
        while (i<word1.length() && j<word2.length()){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;

        }
        //if anyworld remainig
        while (i<word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }while (j<word1.length()){
            sb.append(word2.charAt(j));
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String word1="abc";
//        String word2="pqr";
//        System.out.println(mergeAlternately(word1,word2));
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        int a=50;
        int b=25;
        System.out.println(divide(1,1));

    }
    public static int removeDuplicatesI(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int uniqueIndex=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[uniqueIndex]){
                nums[uniqueIndex++]=nums[i];
            }

        }
        return uniqueIndex+1;
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length==2){
            return nums.length;
        }
        int uniqueIndex2=2;
        for (int i=2;i<nums.length;i++){
            if (nums[i]!=nums[uniqueIndex2-2]){
                nums[uniqueIndex2]=nums[i];
                uniqueIndex2++;

            }
        }
        return uniqueIndex2;
    }
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && dividend == -1){
            return Integer.MIN_VALUE;
        }
        boolean isNegative=(dividend<0) ^ ( divisor<0);
        long absDividend=Math.abs((long) dividend);
        long absDivisor=Math.abs((long) divisor);
        int result=0;
        while (absDividend>absDivisor){
            long tempDivisor=absDivisor;
            int multiple=1;
            while (absDividend>=(tempDivisor<<1)){
                tempDivisor<<=1;
                multiple<<=1;
            }
            absDividend-=tempDivisor;
            result+=multiple;
        }
        return isNegative ? -result : result;
    }
}
