package com.LeetCode.Easy;

import java.util.Scanner;

public class strStr {
    public static int str(String haystack,String needle){

        if(haystack.length()>=needle.length()){
            for(int i=0;i<haystack.length();i++){
                String s=haystack.substring(i,needle.length()+i);
                if(s.equals(needle)){
                    return 0;
                }
                else {
                    return -1;
                }
            }

        }
        else {
            for (int i=0;i<needle.length();i++){
                String s=needle.substring(i,haystack.length()+i);
                if(s.equals(haystack)){
                    return 0;
                }
                else return -1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String haystack=in.next();
        String needle=in.next();
        System.out.println(str(haystack,needle));
    }
}
