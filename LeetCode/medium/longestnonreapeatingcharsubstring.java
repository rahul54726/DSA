package com.LeetCode.medium;

public class longestnonreapeatingcharsubstring {
     static int lengthOfLongestSubstring(String s) {
        String p="";
        if(s.isEmpty()){
            System.out.println(p);
            return 1;
        }
        int count=0;
        char ch=s.charAt(0);
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)!=s.charAt(0)){
                p+=ch;
                count+=lengthOfLongestSubstring(s.substring(1));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s="abcaabn";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
