package com.LeetCode.stackandQueue;

import java.util.PriorityQueue;

public class MinStack {
    PriorityQueue<Integer> queue1;
    PriorityQueue<Integer> queue2;

    public MinStack() {
        queue1=new PriorityQueue<>();
    }
    public void push(int val) {
        queue2.add(val);
        while (!queue1.isEmpty()){
            queue2.add(queue1.remove());
        }
        PriorityQueue<Integer> temp=queue1;
        queue1=queue2;
        queue2=temp;
    }
    public void pop() {
        queue1.remove();
    }
    public int top() {
        return queue1.peek();
    }
    public int getMin() {
        return queue2.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> que=new PriorityQueue<>();

        que.add(100);
        que.add(90);
        System.out.println(que);
    }
}
