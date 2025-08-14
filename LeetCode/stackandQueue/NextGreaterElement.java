package com.LeetCode.stackandQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums){
        int[] NGE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            NGE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return NGE;
    }
    public static int[] prevSmallerElement(int[] nums){
        int[] PSE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < nums.length;i++){
            int num = nums[i];
            while (!stack.isEmpty() && stack.peek() >= num){
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
    public static int[] nextGreaterElementCircular(int[] nums){
        int[] NGE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*nums.length-1;i>=0;i--){
            int currentIndex = i%nums.length ;
            while (!stack.isEmpty() && stack.peek() <= nums[currentIndex]){
                stack.pop();
            }
            if(i<nums.length){
                if(stack.isEmpty()) {
                    NGE[currentIndex] = -1;
                }
                else {
                    NGE[currentIndex] = stack.peek();
                }
            }
            stack.push(nums[currentIndex]);
        }
        return NGE;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(nextGreaterElementCircular(new int[]{6,0,8,1,3})));
        System.out.println(Arrays.toString(prevSmallerElement(new int[]{5,7,9,6,7,4,5,1,3,7})));
    }
}
