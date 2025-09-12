package com.LeetCode.priorityQueue;

import java.util.PriorityQueue;
import java.util.Stack;

public class ClearStars {
    public String clearStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if(c == '*'){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c :stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
