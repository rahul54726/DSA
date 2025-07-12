package com.CollectionFrameWorks.Stack;

public class StackMain  {
    public static void main(String[] args) throws Exception {
        CustomStackImpl stack=new DynamicStack(5);
        stack.push(25);
        stack.push(35);
        stack.push(45);
        stack.push(55);
        stack.push(65);
        stack.push(75);
        System.out.println(stack.getval(2));
        System.out.println(stack.peek());


    }
}
