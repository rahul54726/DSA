package com.LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfKpairs {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println(maxSum(arr,3));
        System.out.println(smallestSubarray(arr,5));
        System.out.println(minimumRecolors("WBBWWBBWBW",7));
        System.out.println(longestSubArray(arr,8));
    }
    //For Static window
    public static int maxSum(int[] nums,int k){
        int windowSum=0,maxSum=0;
        for(int i=0;i<k;i++){
            windowSum+=nums[i];
        }
        int n = nums.length;
        for(int i = k;i<n;i++){
            windowSum+=nums[i]-nums[i-k];
            maxSum = Math.max(maxSum,windowSum);
        }
        return maxSum;
    }
    //For dyanamic Window
    public static int smallestSubarray(int[] nums,int sum){
        int windowSum=0, minLength =Integer.MAX_VALUE;
        int windowStart=0;
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            windowSum+=nums[windowEnd];
            while (windowSum >= sum){
                minLength=Math.min(minLength,windowEnd-windowStart+1);
                windowSum -= nums[windowStart++];
//                windowStart++;
            }
        }
        return minLength==Integer.MAX_VALUE ? 0 : minLength;
    }
    public static int longestSubArray(int[] nums,int target){
        int windowSum=0;
        int left=0;
        int right=0;
        int largestLength=Integer.MIN_VALUE;
        while (right<nums.length){
            windowSum+=nums[right];
            if(windowSum>target){
                windowSum-=nums[left++];

            }
            if(windowSum<=target){
                largestLength=Math.max(largestLength,right-left+1);
            }
            right++;
        }
        return largestLength;
    }
    public String minWindow(String s, String t) {
        if(s==null || s.isEmpty() || t==null || t.isEmpty()) return "";
        HashMap<Character,Integer> charCount =new HashMap<>();
        for(char ch:t.toCharArray()){
            charCount.put(ch, charCount.getOrDefault(ch,0)+1);
        }
        int required= charCount.size();
        int left=0,right=0;
        int formed=0;
        HashMap<Character,Integer> windowCounts=new HashMap<>();
        int[] result={-1,0,0};
        while (right<s.length()){
            char ch=s.charAt(right);
            windowCounts.put(ch,windowCounts.getOrDefault(ch,0)+1);
            if(charCount.containsKey(ch) && windowCounts.get(ch).intValue() == charCount.get(ch).intValue()){
                formed++;
            }
            while (left <= right && formed == required){
                ch=s.charAt(left);
                if(result[0] ==-1 || right-left+1<result[0]){
                    result[0] = right-left+1;
                    result[1] = left;
                    result[2] = right;
                }
                windowCounts.put(ch,windowCounts.get(ch)-1);
                if (charCount.containsKey(ch) && windowCounts.get(ch).intValue() < charCount.get(ch).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return result[0] == -1 ? "" : s.substring(result[1],result[2]+1);
    }
    public static int minimumRecolors(String blocks, int k) {
        int min=0;
        int count=0;
        int n=blocks.length();
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W') count++;
        }
        min=count;
        for (int i=k;i<n;i++){
            if(blocks.charAt(i) == 'W'){
                count++;
            }
            if(blocks.charAt(i-k) == 'W') count--;
            min=Math.min(count,min);
        }
        return min;
    }
//    private int longestSubarr(int[] nums,int k){
//
//    }
}
