package com.LeetCode.stackandQueue;

import java.util.*;
import java.util.stream.Collectors;

public class SumOfSubArrayMin {
//    public static int sumOfSubArrayMin(int[] nums){
//        int [] NSE  = nextGE(nums);
//        int[] PSE = nextSmallerElement(nums);
//    }
//    private static int[] nextGE(int[] nums){
//        Stack<Integer> stack = new Stack<>();
//        int[] NGE = new int[nums.length];
//        for (int i = 0;i<nums.length;i++){
//            if(!stack.isEmpty() && stack.peek()<=nums[i]){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                NGE[i] = -1;
//            }
//            else{
//                nums[i]=stack.peek();
//            }
//            stack.push(nums[i]);
//        }
//        return NGE;
//    }
//    public static int[] nextSmallerElement(int[] nums){
//        int[] NSE = new int[nums.length];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0;i < nums.length;i++){
//            int num = nums[i];
//            while (!stack.isEmpty() && stack.peek() >= num){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                NSE[i] = -1;
//            }
//            else {
//                NSE[i] = stack.peek();
//            }
//            stack.push(num);
//        }
//        return NSE;
//
//    }
    public static int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = powers(n);
        int mod = 1000000007;
        int[] result = new int[queries.length];
        for(int i = 0; i< result.length;i++){
            int start = queries[i][0];
            long item = 1;
            for (int end = start;end<=queries[i][1];end++){
               item = (item * powers.get(end) % mod )  % mod;
            }
            result[i] = (int)item;
        }
        return result;
    }
    private static List<Integer> powers(int num){
        int item = num & 1;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while (num!=0){
            int result = item* (1 << count);
            if(result != 0) list.add(result);
            count++;
            num >>=1;
            item = num & 1;
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(powers(15));
    }
}
