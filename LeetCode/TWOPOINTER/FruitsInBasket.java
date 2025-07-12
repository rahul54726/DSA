package com.LeetCode.TWOPOINTER;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FruitsInBasket {
    public static void main(String[] args) {
        System.out.println(maxFruits(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
    public static int maxFruits(int[] trees){
        //bruteforce
//        int max = Integer.MIN_VALUE;
//        for(int i = 0;i<trees.length;i++){
//            HashSet<Integer> set = new HashSet<>();
//            for(int j = i;j<trees.length;j++){
//                set.add(trees[j]);
//                if(set.size() < 3){
//                    max = Math.max(max,j-i+1);
//                }
//                else {
//                    break;
//                }
//            }
//
//        }
//        return max;
        //optimised solution
        int left = 0;
        int right = 0;
        int maxLength = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while (right<trees.length){
            map.put(trees[right],map.getOrDefault(trees[right],0)+1);
                while (map.size() > 2){
                    map.put(trees[left],map.get(trees[left])-1);
                    if(map.get(trees[left]) == 0){
                        map.remove(trees[left]);
                    }
                    left++;
                }

                    maxLength = Math.max(maxLength,right - left +1);

            right++;
        }
        return maxLength;
    }
}
