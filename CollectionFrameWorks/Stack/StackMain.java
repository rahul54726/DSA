package com.CollectionFrameWorks.Stack;

public class StackMain  {
    public static void main(String[] args) throws Exception {
        CustomStackImpl<String> stack=new CustomStackImpl<>();
        stack.push("Rahul");
        stack.push("Raj");
        stack.push("Kunal");
        stack.push("Priyanshu");
        stack.push("Vipul");
        stack.push("Atul");
        System.out.println(stack.toString());
        System.out.println(stack.getval(2));
        System.out.println(stack.peek());


    }
}
