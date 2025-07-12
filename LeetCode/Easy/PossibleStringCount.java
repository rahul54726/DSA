package com.LeetCode.Easy;

import com.Array.Array;

import java.util.*;

public class PossibleStringCount {
    public static int possibleStringCount(String word) {
//        HashMap<Character,Integer> fmap = new HashMap<>();
//        for(char ch :word.toCharArray()){
//            fmap.put(ch,fmap.getOrDefault(ch,0)+1);
//        }
//        int count = 1;
//        for(char ch : fmap.keySet()){
//            if(fmap.get(ch) > 1) {
//                count += (fmap.get(ch) - 1);
//            }
//        }
//        return count;
        int count = 1;
        for(int i = 0;i<word.length();i++){
            if(i>0 && i<word.length()  && word.charAt(i) == word.charAt(i - 1)){
                count++;
            }
        }
        return count;
    }
//    public int MOD = 1_000_000_007;
//   public static List<Integer> groups;
//    public Integer[][] memo;
//    public  int possibleStringCount(String word, int k) {
//        groups = new ArrayList<>();
//        int i = 0;
//        while (i<word.length()){
//            int j = i;
//            while (j<word.length() && word.charAt(j) == word.charAt(i)) {
//                j++;
//            }
//            groups.add(j-i);
//            i = j;
//        }
//        long total = 1;
//        for(int g:groups){
//            total = (total*g)%MOD;
//        }
//        int n = groups.size();
//        memo = new Integer[n+1][k];
//        int invalid = solve(0,0,k);
//        return (int)((total-invalid+MOD) %MOD );
//    }
//
//    private  int solve(int index, int len, int k) {
//        if(len>=k) return 0;
//        if(index == groups.size()){
//            return len < k ? 1 : 0;
//        }
//        if(memo[index][len] != null) return memo[index][len];
//        int ways = 0;
//        int maxRepeat = groups.get(index);
//        for(int take = 1;take<=maxRepeat;take++){
//            ways=(ways+solve(index+1,len+take,k)) %MOD;
//        }
//        return memo[index][len] = ways;
//    }

    public static void main(String[] args) {
        System.out.println(possibleStringCount("aabbcc"));
    }
}
