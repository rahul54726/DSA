package com.LeetCode.stackandQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int currentAst : asteroids) {
            boolean currentAstDestroyed = false;
            while (!stack.isEmpty() && currentAst < 0 && stack.peek() > 0) {
                if (stack.peek() > Math.abs(currentAst)) {
                    currentAstDestroyed = true;
                    break;
                }
                else if (stack.peek() == Math.abs(currentAst)) {
                    stack.pop();
                    currentAstDestroyed = true;
                    break;
                }
                else {

                    stack.pop();
                }
            }
            if (!currentAstDestroyed) {
                stack.push(currentAst);
            }
        }

        // Convert the stack to an array for the final result.
        int[] result = new int[stack.size()];
        // The stack is LIFO, so we fill the array from the end to maintain the correct order.
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
    public static String largestGoodInteger(String num) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<num.length()-2;i++){
            if(num.charAt(i) == num.charAt(i+1) &&num.charAt(i) == num.charAt(i+2) ) {
                max = Math.max(max, Integer.parseInt(num.substring(i, i + 3)));
            }
        }
        if(max == 0) return String.valueOf(max) + "00";
        return max == Integer.MIN_VALUE ? "" : String.valueOf(max);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10,2,-5})));
        System.out.println(largestGoodInteger("2777019"));
    }
}
