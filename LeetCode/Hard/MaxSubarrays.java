package com.LeetCode.Hard;

import java.util.ArrayList;
import java.util.List;

public class MaxSubarrays {
    public  static  long maxSubarrays(int n , int[][] conflictingPairs){
//        List<Integer> nums = Stream.iterate(1, num -> num + 1).limit(n).toList();
//        List<List<Integer>> outer = new ArrayList<>();
//        outer.add(new ArrayList<>());
//        for(int num:nums){
//            int end = outer.size();
//            for(int i = 0;i<end;i++){
//                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
//                inner.add(num);
//                outer.add(inner);
//            }
//        }
//        outer.removeFirst();
//        System.out.print(outer);
//        return 0l;
        List<Integer>[] right = new ArrayList[n + 1];
        for(int i = 0;i<=n;i++){
            right[i] = new ArrayList<>();
        }
        for(int [] pair: conflictingPairs){
            right[Math.max(pair[0],pair[1])].add(Math.min(pair[0],pair[1]));
        }
            long ans = 0;
            long[] left = {0,0};
            long[] bonus = new long[n+1];

            for(int r = 1;r <= n;r++){
                for(int leftVal :right[r]){
                    if(leftVal > left[0]){
                        left[1] = left[0];
                        left[0] = leftVal;
                    }
                    else if (leftVal > left[1]){
                        left[1] = leftVal;
                    }
                }
                ans += r - left[0];
                if(left[0]>0){
                    bonus[(int) left[0]] += left[0] - left[1];
                }
            }
            long maxBonus = 0;
            for(long b : bonus){
                maxBonus = Math.max(maxBonus,b);
            }

        return ans+maxBonus;

    }

    public static void main(String[] args) {
        maxSubarrays(10,new int[][]{});
    }
}
