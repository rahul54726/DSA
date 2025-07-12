package com.LeetCode.StockQuestions;
import  java.util.*;
public class Stock {
//    public static int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        PriorityQueue<Integer> queue =new PriorityQueue<>((a,b) ->b-a);
//        queue.add(0);
//        for(int i = 0;i<prices.length;i++){
//            for (int j = i+1;j<prices.length;j++){
//                int diff = prices[j] - prices[i];
//                queue.add(diff);
//            }
//        }
//        System.out.println(queue);
//        return queue.poll();
//    }
    //optimized
    public static int maxProfit(int[] prices) {
        int minPrize = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            if(price < minPrize) {
                minPrize = price;
            }
            else {
//                list.add(price-minPrize);
                maxProfit=Math.max(maxProfit,price-minPrize);
            }
        }
        return maxProfit;

//
    }
    public static int numTrees(int n) {
        int[] G = new int[n+1];
        G[0]=1;
        G[1]=1;
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                G[i] += G[j-1] * G[n-j];
            }
        }
        return G[n];
    }
    public static void main(String[] args) {
        System.out.println(minimizeMax(new int[]{4,2,1,2},1));
//        System.out.println(maxAdjacentDistance(new int[]{-5,-10,-5}));
    }
    public static int maxAdjacentDistance(int[] nums) {
        if (nums.length == 0) return 0;
        int max = Math.abs(nums[nums.length-1] - nums[0]);
//        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            int diff = nums[(i+1)%nums.length] - nums[i];
            max = Math.max(max,Math.abs(diff));

        }
        return max;
    }
    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1] - nums[0];
        int result = right;
        while (left <= right){
            int mid = left+ (right-left)/2;
            if (canFormPairs(nums,p,mid)){
                result = mid;
                right = mid -1;
            }
            else {
                left = mid+1;
            }
        }
        return result;

    }
    private  static boolean canFormPairs(int[] nums,int p,int maxDiff){
        int count = 0;
        for (int i = 0 ;i<nums.length - 1 ;i++){
            if(nums[i+1] - nums[i] <= maxDiff){
                count++;
                i++;
            }
        }
        return count >= p;
    }
}
