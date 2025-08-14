package com.LeetCode.Hard;
import java.util.Stack;
public class Histogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        stack.push(0);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                max = getMax(heights,stack,max,i);
            }
            stack.push(i);
        }
        int i=heights.length;
        while (!stack.isEmpty()){
            max = getMax(heights,stack,max,i);
        }
        return max;
    }

    private int getMax(int[] heights, Stack<Integer> stack, int max, int i) {
        int area;
        int popped=stack.pop();
        if(stack.isEmpty()){
            area= heights[popped] * i;
        }
        else {
            area=heights[popped] * (i - 1 - stack.peek());
        }
        return Math.max(max,area);
    }
    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int NSE ;
        int PSE ;
        int element ;
        for(int i = 0;i<heights.length;i++){
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                 element = stack.pop();
                 NSE = i;
                 PSE = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max , heights[element]*(NSE - PSE -1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            NSE = heights.length;
            element = stack.pop();
            PSE = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max,(NSE - PSE -1) * heights[element]);
        }
        return max;
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
    public static int[] prevSmallerElement(int[] nums){
        int[] PSE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < nums.length;i++){
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] >= num){
                stack.pop();
            }
            if(stack.isEmpty()){
                PSE[i] = -1;
            }
            else {
                PSE[i] = stack.peek();
            }
            stack.push(i);
        }
        return PSE;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea2(new int[]{2,1,5,6,2,3}));
    }
}
