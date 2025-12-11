package com.LeetCode.medium;

import java.util.HashMap;
import java.util.Stack;

public class CountCollisions {
    public int countCollisions(String directions) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        stack.push(directions.charAt(0));
        for (int i = 1;i<directions.length();i++){
            char ch = directions.charAt(i);
            if (stack.peek() == 'L' && ch == 'R'
                    || stack.peek() == 'L' && ch =='L'
                    || stack.peek() == 'R'&&  ch == 'R') {
                stack.pop();
                stack.push(ch);
            } else if (stack.peek() == 'R' && ch == 'L') {
                stack.pop();
                res += 2;
                stack.push('S');
            } else if (stack.peek() == 'S' && ch == 'L' || ch == 'R') {
                stack.pop();
                stack.push('S');
                res+=1;
            }

        }
        return res;
    }
    int M = 1000000007;
    public int specialTriplets(int[] nums) {
        long count = 0;
        HashMap<Integer,Integer> rightFreq = new HashMap<>();
        for(int num : nums) rightFreq.put(num, rightFreq.getOrDefault(num,0)+1);
        HashMap<Integer,Integer> leftFreq = new HashMap<>();
        for (int num : nums){
            leftFreq.put(num, rightFreq.get(num)-1);
            int left = rightFreq.getOrDefault(num * 2,0);
            int right = leftFreq.getOrDefault(num*2,0);
            count = (count + ((long) left * right)) % M;
            leftFreq.put(num, leftFreq.getOrDefault(num,0)+1);
        }
        return (int) count;
    }
}
