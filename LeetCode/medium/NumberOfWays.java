package com.LeetCode.medium;

import com.CollectionFrameWorks.HashMaps.Map;

import java.util.HashMap;

public class NumberOfWays {
    static int mod = 1000000007;
    public static int numberOfWays(int n, int x) {
        HashMap<String,Integer> memo = new HashMap<>();
        return solve(n,1,x,memo)%mod;
    }
    private static int solve(int n,int num,int x,HashMap<String,Integer> memo){
        if (n == 0 ) return 1;
        if (n < 0 ) return 0;
        if((int)Math.pow(num,x) > n) return 0;
        String key = n + ","+num;
        if(memo.containsKey(key)) return memo.get(key);
        int take = solve(n-((int)Math.pow(num,x)),num+1,x,memo)%mod;
        int skip = solve(n,num + 1,x,memo)%mod;
        memo.put(key,(take+skip)%mod);
        return memo.get(key);
    }
    private static int limit(int n,int x) {
        int limit = 0;
        while (limit <= n){
            if((int)Math.pow(limit,x) < n){
                limit++;
            }
            else break;
        }
        return limit-1;
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(10,2));
    }
}
