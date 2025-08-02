package com.LeetCode.medium;

import java.util.Stack;

public class MaximumGain {
    public static int maximumGain(String s, int x, int y) {
        int gain = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if(x>y){
            for(char c : s.toCharArray()){
                int len = sb1.length();
                if(!sb1.isEmpty() && c == 'b' && sb1.charAt(len-1) == 'a'){
                    gain+=x;
                    sb1.deleteCharAt(len-1);
                }
                else sb1.append(c);
            }
            for(char ch : sb1.toString().toCharArray()){
                int len = sb2.length();
                if(!sb2.isEmpty() && ch =='a' && sb2.charAt(len-1) == 'b'){
                    gain += y;
                    sb2.deleteCharAt(len-1);
                }else sb2.append(ch);
            }
        }
        else {
            for(char c : s.toCharArray()){
                int len = sb1.length();
                if(!sb1.isEmpty() && c == 'a' && sb1.charAt(len-1) == 'b'){
                    gain+=y;
                    sb1.deleteCharAt(len-1);
                }
                else sb1.append(c);
            }
            for(char ch : sb1.toString().toCharArray()){
                int len = sb2.length();
                if(!sb2.isEmpty() && ch =='b' && sb2.charAt(len-1) == 'a'){
                    gain += x;
                    sb2.deleteCharAt(len-1);
                }else sb2.append(ch);
            }
        }
//            for(int i = 0;i < news.length()  ;i++){
//                if(news.startsWith("ba", i)){
//                    gain+=y;
//                    i+=2;
//                }
//            }
//        }
//        else {
//            for(int i = 0;i<s.length();i++){
//                if(s.startsWith("ba", i)){
//                    gain+=y;
//                    i++;
//                }else {
//                    news += s.charAt(i);
//                }
//            }
//            for(int i = 0;i<news.length();i++){
//                if(news.startsWith("ab", i)){
//                    gain+=x;
//                }
//            }
//        }
//        return gain ;
//        if(x>y){
//            return remove(s,"ab",x,y);
//        }
//        else {
//            return remove(s,"ba",y,x);
//        }
        return gain;
    }

    private static int solve(String s, String first, int firstVal, int secondVal) {
        Stack<Character> stack = new Stack<>();
        int score = 0;
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first.charAt(0) && ch == first.charAt(1)) {
                stack.pop();
                score += firstVal;
            } else {
                stack.push(ch);
            }
        }

        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.append(stack.pop());
        }
        s = remaining.reverse().toString();
        stack.clear();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first.charAt(1) && ch == first.charAt(0)) {
                stack.pop();
                score += secondVal;
            } else {
                stack.push(ch);
            }
        }

        return score;
    }
    private static int remove(String s,String firstpair,int first,int sec){
        int gain = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            int len = sb.length();
            if(len>0 && sb.charAt(len-1) == firstpair.charAt(0) && ch == firstpair.charAt(1)){
                sb.deleteCharAt(len-1);
                gain += first;
            }
            else {
                sb.append(ch);
            }
        }
        s = sb.toString();
        sb = new StringBuilder();
        String secondPair = ""+firstpair.substring(1)+firstpair.substring(0);
        for(char ch : s.toCharArray()){
            int len = sb.length();
            if(len>0 && sb.charAt(len-1) == secondPair.charAt(0) && ch == secondPair.charAt(1)){
                sb.deleteCharAt(len-1);
                gain += sec;
            }
            else {
                sb.append(ch);
            }
        }
        return gain;
    }

    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab",4,5));
        String s = "cdbcbbaaabab";
        System.out.println(s.substring(0,2));
    }
}
