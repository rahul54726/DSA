package com.LeetCode.stackandQueue.Conversions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostFix {
    public static String inToPostFix(String expression){
        int i = 0;
        Stack<Character> stack = new Stack<>();
        String ans = "";
        while (i < expression.length()){
            char ch = expression.charAt(i);
            if((ch >= 'A' && ch <='Z')||
                    (ch >= 'a' && ch <='z') || (ch >= '0' && ch <='9')){
                ans+=expression.charAt(i);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '('){
                    ans += stack.pop();
                }
            }else {
                while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())){
                    ans += stack.pop();
                }
                stack.push(ch);
            }
            i++;
        }
        while (!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }
    private static int priority(char ch){
        if(ch == '^') return 3;
        else if (ch == '*' || ch=='/') return 2;
        else if (ch =='+' || ch == '-') return -1;
        else return -1;



    }
    public static void main(String[] args) {
        System.out.println(inToPostFix("a+b*(c^d-e)"));
    }
}
