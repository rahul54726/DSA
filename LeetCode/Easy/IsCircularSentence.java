package com.LeetCode.Easy;

public class IsCircularSentence {
    public static boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        if (words.length == 1) {
            if(sentence.charAt(0) == sentence.charAt(sentence.length()-1)) return true;
            else return false;
        }
        int size = words.length;
        for (int i = 0;i<size;i++){
            if (words[i].charAt(words[i].length()-1) != words[(i+1)%size].charAt(0)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isCircularSentence("Leetcode is cool"));
    }
}
