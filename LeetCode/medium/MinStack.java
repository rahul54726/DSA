package com.LeetCode.medium;

import com.CollectionFrameWorks.Heap.PriorityQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class MinStack {
    Deque<Integer> queue;
    public MinStack() {
        queue=new ArrayDeque();
    }

    public void push(int val) {
        queue.addLast(val);
    }

    public void pop() {
        queue.removeLast();
    }

    public int top() {
        return queue.getLast();
    }

    public int getMin() {
        PriorityQueue<Integer> pq=new PriorityQueue<>(queue);
        return pq.remove();
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
