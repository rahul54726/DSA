package com.LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxDistance {
    public static int maxDistance(String s,int k){
        int MD = 0;
        int stepsTillNow = 0;
        int E = 0;
        int W = 0;
        int N = 0;
        int S = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'E') E++;
            else if (ch=='W') {
                W++;
            } else if (ch=='N') {
                N++;
            }
            else {
                S++;
            }
            int CMD = Math.abs(E-W)+Math.abs(N-S);
            stepsTillNow=i+1;
            int wastedSteps = stepsTillNow- CMD;
            int extra = 0;
            if(wastedSteps != 0){
                extra = Math.min(2*k,wastedSteps);
            }
            int finalCMD = CMD + extra;
            MD = Math.max(MD,finalCMD);
        }
        return MD;
    }
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i= 1;i<=9;i++){
            helper(i,n,list);
        }
        return list;
    }
    private static void helper(int start,int n,List<Integer> list){
        if (start>n){
            return ;
        }
        list.add(start);
        for (int i = 0;i<=9;i++){
            int newNum = start*10+i;
            if(newNum>n){
                return;
            }
            helper(newNum,n,list);
        }
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(14));
    }
}
