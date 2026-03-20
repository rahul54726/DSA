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
        stack.pop();
        System.out.println(stack.toString());
        CustomStackImpl<Integer> s = new CustomStackImpl<>(10);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.toString());
        s.pop();
        System.out.println(s.toString());


    }
}
