package com.LeetCode.Easy;

import java.util.*;

public class MaxSubsequence {
    public static   int[] maxSubsequence(int[] nums,int k ){
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
//        for(int i = 0;i< nums.length;i++){
//            minHeap.offer(new int[]{nums[i],i});
//            if(minHeap.size()>k){
//                minHeap.poll();
//            }
//        }
//        List<int[]> list = new ArrayList<>(minHeap);
//        list.sort(Comparator.comparingInt(a -> a[1]));
//
//        int [] result = new int[k];
//        for(int i = 0;i<k;i++){
//            result[i]= list.get(i)[0];
//        }
//        return result;
        int[][] indexNums = new int[nums.length][2];
        for(int i = 0 ;i<nums.length;i++){
            indexNums[i][0]=nums[i];
            indexNums[i][1]=1;
        }
        Arrays.sort(indexNums,(a,b) -> b[0] - a[0]);
        int[][] topK = Arrays.copyOfRange(indexNums,0,k);
        Arrays.sort(topK,Comparator.comparingInt(a ->a[1]));
        int[] result = new int[k];
        for(int i = 0 ;i<k;i++){
            result[i] = topK[i][0];
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        maxSubsequence(new int[]{1,-2,3,4},1);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(1);
        list.add(3);
        list.sort(Comparator.comparingInt(a -> a));
        System.out.println(list);
    }
}
