package com.LeetCode.stackandQueue;


import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> que1;
    Queue<Integer> que2;
    public MyStack(){
        que1=new LinkedList<>();
        que2=new LinkedList<>();
    }
    public void push(int x) {
        que2.add(x);
        while (!que1.isEmpty()){
            que2.add(que1.remove());
        }
        Queue<Integer> temp=que1;
        que1=que2;
        que2=temp;
    }
    public int pop() {
        return que1.remove();
    }
    public int top() {
        return que1.peek();
    }
    public boolean empty() {
        return que1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack=new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
