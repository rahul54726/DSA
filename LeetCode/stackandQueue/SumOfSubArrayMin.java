package com.LeetCode.stackandQueue;

import java.util.*;

public class SumOfSubArrayMin {
    public static int sumOfSubArrayMin(int[] nums){
        int [] NSE  = nextSE(nums);
        int[] PSE = prevSmallerEqualElement(nums);
        long total = 0;
        int mod = (int) (1e9+7);
        for(int i = 0;i<nums.length;i++){
            long left = i - PSE[i];
            long right = NSE[i] - i;
            long numSubarrays = left * right;
            long contribution =numSubarrays * nums[i];
            total = (total + contribution) % mod;
        }
        return (int) total;
    }

    private static int[] nextSE(int[] nums){
        int[] NSE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            NSE[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(i);
        }
        return NSE;
    }
    public static int[] prevSmallerEqualElement(int[] nums){
        int[] PSEE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < nums.length;i++){
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] > num){
                stack.pop();
            }
            PSEE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return PSEE;
    }
    private static int[] nextGE(int[] nums){
        int[] NGE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()) {
                NGE[i] = -1;
            }
            else {
                NGE[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return NGE;
    }
    public static int[] prevGreaterElement(int[] nums){
        int[] PSE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < nums.length;i++){
            int num = nums[i];
            while (!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }
            if(stack.isEmpty()){
                PSE[i] = -1;
            }
            else {
                PSE[i] = stack.peek();
            }
            stack.push(num);
        }
        return PSE;
    }
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
        System.out.println(Arrays.toString(prevSmallerEqualElement(new int[]{1,4,6,7,3,7,8,1})));
        System.out.println(sumOfSubArrayMin(new int[]{1,4,6,7,3,7,8,1}));
    }
}
