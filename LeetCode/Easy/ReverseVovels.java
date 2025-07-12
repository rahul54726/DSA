package com.LeetCode.Easy;

import java.util.Arrays;
import  java.util.*;
import java.util.Collections;

public class ReverseVovels {
    public static String reverseWords(String s) {
        s=s.trim();
        String[] words=s.split("\\s");
        StringBuilder reverse=new StringBuilder();
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
    }

    public static void main(String[] args) {
        int[] nums={-1,1,0,3,-3};
        int[] result = productExceptSelf(nums);
        for (int num:result){
            System.out.print(num+" ");
        }
    }
    public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
        int left=0,right=chars.length-1;
        String vowels="aeiouAEIOU";
        while (right>left){
            while (left<right && vowels.indexOf(chars[left])==-1){
                left++;
            }
            while (left<right && vowels.indexOf(chars[right])==-1){
                right--;
            }
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
        return new String(chars);
    }
    public static int[] productExceptSelf(int[] nums) {

        int zeroes=0;
        int[] result=new int[nums.length];
        for (int num:nums){
            if (num==0){
                zeroes++;
            }
        }
        if(zeroes>1){
            Arrays.fill(result,0);
            return result;
        }
       if (zeroes==1){
           int index=-1;
           int multiply=1;
           for (int i = 0; i < nums.length ; i++) {
               if (nums[i]==0){
                   index=i;
                   continue;
               }
               multiply*=nums[i];
           }
           Arrays.fill(result,0);
           result[index]=multiply;
           return result;
       }
       else {
           int multiply =1;
           for (int num:nums){
               multiply *=num;
           }
           for (int i=0;i<result.length;i++){
               result[i] = multiply / nums[i];
           }
           return result;
       }
    }

}
