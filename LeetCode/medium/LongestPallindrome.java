package com.LeetCode.medium;

import java.util.ArrayList;

public class LongestPallindrome {
    public static void main(String[] args) {
        System.out.println(isPallindrome("rahul"));
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        ArrayList<String> list=new ArrayList<>();
        int i=0;

        while (i<=s.length()){
            for (int j=i+1;j<=s.length();j++){
                if (isPallindrome(s.substring(i,j))){
                    if(s.substring(i,j).length()==1) continue;
                    list.add(s.substring(i,j));
                }
            }
            i++;
        }
        System.out.println(list);
        int index=0;
        for (int j=1;j<=list.size()+1;j++){
            if(j==list.size()) break;
            if(list.get(j-1).length()>list.get(j).length()){
                index=j+1;
            }
        }
        return list.get(index);
    }

    private static boolean isPallindrome(String str){
        StringBuilder sb=new StringBuilder();
        for (int i=str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString().equals(str);

    }
}
