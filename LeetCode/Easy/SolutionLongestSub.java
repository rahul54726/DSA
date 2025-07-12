package com.LeetCode.Easy;

public class SolutionLongestSub {
    public static int lengthOfLongestSubstring(String s) {
        int count=0;
        String Sub="";
        String str="";
        for(int i=0;i<s.length();i++){
            for(int j=1;j<s.length();j++){
                if(s.charAt(i)!=s.charAt(j)) {
                    Sub += s.charAt(i);

                }
            }
        }for(int i=0;i<s.length();i++){
            for(int j=1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)) {
                    str += s.charAt(i);

                }
            }
        }
        return str.length()-Sub.length();
    }

    public static void main(String[] args) {
        String s="abcab";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
