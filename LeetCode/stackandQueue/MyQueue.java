package com.LeetCode.stackandQueue;
import java.util.Stack;

public class MyQueue {
   private   Stack<Integer> first;
   private   Stack<Integer> second;
    public MyQueue() {
    first=new Stack<>();
    second=new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
    while (!first.isEmpty()){
        second.push(first.pop());
    }
    int removed = second.pop();
    while (!second.isEmpty()){
        first.push(second.pop());
    }
    return removed;
    }

    public int peek() {
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        int peeked = second.peek();
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return peeked;
    }

    public boolean empty() {
    return first.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj=new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
    }
}
