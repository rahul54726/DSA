package com.LeetCode.TWOPOINTER;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left <= right){
            swap(s,left,right);
            left++;
            right++;
        }
    }
    static void swap(char[] s,int first,int second){
        char temp = s[first];
        s[first] = s[second];
        s[second]=temp;
    }
    public  static boolean isPalindrome(String s) {
        HashSet<Character> characters = new HashSet<>();
        for(int i = 0;i<26;i++){
            characters.add((char)(i+'a'));
        }
        s = s.toLowerCase();
        for(int i = 0;i<s.length();i++){
            if(!characters.contains(s.charAt(i))){
                s =s.replaceAll(s.substring(i,i+1),"");
            }
        }
        System.out.println(s);
        return help(s);
    }
    private static boolean help(String str){
        if(str.length() == 1){
            return false;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left <= right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,3,4},6)));
        System.out.println(isPalindrome("0P"));

    }
}
