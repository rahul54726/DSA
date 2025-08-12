package com.LeetCode.medium;

import com.CollectionFrameWorks.Heap.PriorityQueues;

import java.util.*;

public class MinStack {
    Stack<int[]> stack = new Stack<>();
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) stack.push(new int[]{val,val});
        else {
            stack.push(new int[]{val,Math.min(val,stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
