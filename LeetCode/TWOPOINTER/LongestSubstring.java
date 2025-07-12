package com.LeetCode.TWOPOINTER;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int[] hash = new int[256];
        Arrays.fill(hash,-1);

        while (right < s.length()){
            int index = s.charAt(right);
            if(hash[index] != -1){
                if(hash[index] >=left){
                    left=hash[index] + 1 ;
                }
            }
            maxLength = Math.max(maxLength,right - left + 1);
            hash[index] = right++;
        }
        return maxLength;
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    private static boolean check(int[] nums,int target){
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        return sum > target;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        int window = s1.length();
        for (int i = 0; i < window; i++) {
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        if (map1.equals(map2)) return true;
        for(int i = window ; i<s2.length();i++){
            char inChar = s2.charAt(i);
            char outChar = s2.charAt(i-window);
            map2.put(inChar,map2.getOrDefault(inChar,0)+1);
            if(map2.get(outChar) == 1) {
                map2.remove(outChar);
            }else map2.put(outChar,map2.get(outChar)-1);
            if (map2.equals(map1)) return true;
        }
        return false;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null  || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i<nums.length;i++){
            if(!deque.isEmpty() && deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i>=k-1){
                result[i-k+1]=nums[deque.peekFirst()];
            }
        }
        return result;
    }
    static int maxLength(String str,int k){
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while (right<str.length()){
            map.put(str.charAt(right),map.getOrDefault(str.charAt(right),0)+1);
            while (map.size() > k){
                map.put(str.charAt(left),map.get(str.charAt(left))-1);
                if(map.get(str.charAt(left) ) == 0){
                    map.remove(str.charAt(left));
                }
                left++;
            }
            maxLen = Math.max(maxLen,right- left +1);
            right++;
        }
        return maxLen;
    }
    public static int numberOfSubstrings(String s) {
        //bruetForce
//        int count = 0 ;
//
//        for(int i = 0;i<s.length();i++){
//            int[] hash= new int[3];
//            Arrays.fill(hash,0);
//            for (int j = i; j < s.length(); j++) {
//                hash[s.charAt(j) -'a'] = 1;
//                if (hash[0]+hash[1]+hash[2] == 3) {
//                    count+=1;
//
//                }
//            }
//        }return count;
        //optimized solution
        int count = 0;
        int left = 0;
        int right = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right<s.length()){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while (map.size() == 3){
                count = count + s.length() - right;
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            right++;
        }
        return count;
    }
    public static void main(String[] args) {
//        System.out.println(minSubArrayLen(11,new int[]{1,2,3,4,5}));
//        System.out.println(maxLength("aaabbccd",2));
        System.out.println(numberOfSubstrings("aaacb"));
    }
}
