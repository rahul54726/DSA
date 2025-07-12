package com.LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class KSpecialString {
    public static int minimumDeletions(String word, int k) {
        if(word == null && word.isEmpty()){
            return 0;
        }
        HashMap<Character,Integer> fmap = new HashMap<>();
        for(char ch:word.toCharArray()){
            fmap.put(ch,fmap.getOrDefault(ch,0)+1);
        }
        ArrayList<Integer> freq = new ArrayList<>(fmap.values());
        System.out.println(freq);


        int[] arr = new int[26];
        for(int i = 0;i<freq.size();i++){
            arr[i]=freq.get(i);
        }
        Arrays.sort(arr);
        int result = Integer.MAX_VALUE;
        int cDeletion = 0;
        for(int i = 0;i<26;i++){
            int deletion = cDeletion;
            int freqi= arr[i];
            for(int j = 25; j>i;j--){
                if(arr[j] - arr[i] <=k){
                    continue;
                }
                int diff = Math.abs(arr[i] - arr[j]);
                deletion +=diff-k;
            }
            result = Math.min(result,deletion);
            cDeletion  += freqi;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minimumDeletions("aabcaba",0));
    }
}
