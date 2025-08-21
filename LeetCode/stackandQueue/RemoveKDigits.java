package com.LeetCode.stackandQueue;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(k==num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<num.length() ;i++){
            while (!stack.isEmpty() && stack.peek() -'0' >= num.charAt(i)-'0' && k > 0){
                stack.pop();
                k-=1;
            }
            stack.push(num.charAt(i));
        }
        while (k>=0){
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) return "";
        else {
            String str = "";
            while (!stack.isEmpty()){
                str+=stack.pop();
            }
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            // Remove leading zeros
            int start = 0;
            while (start < sb.length() && sb.charAt(start) == '0') {
                start++;
            }
            String result = (start == sb.length()) ? "0" : sb.substring(start);

            return result;
        }
    }
}
