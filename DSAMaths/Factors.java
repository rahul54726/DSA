package com.DSAMaths;

import java.util.*;

public class Factors {
    static ArrayList factorsof(int n){
       int s=1;
       ArrayList list=new ArrayList<>();
        while(s*s<=n){

            if (n%s==0){
                if(n/s==s){
                list.add(s);
            }

             else {
                    list.add(s);
                    list.add(n/s);
                }

            }
            s++;
        }

        return list;
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        if(nums.length == 1) return List.of(nums[0]);
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for(int i = 1;i<nums.length;i++){
            int a = stack.pop();
            int b = nums[i];
            if (gcd(a,b)>1) {
                stack.push(lcm(a,b));
            }
        }
        return new ArrayList<>(new HashSet<>(stack));
//        Stack<Integer> stack = new Stack<>();
//        for (int num : nums) {
//            int curr = num;
//            // keep merging while gcd > 1 with stack top
//            while (!stack.isEmpty() && gcd(stack.peek(), curr) > 1) {
//                curr = lcm(stack.pop(), curr);
//            }
//            stack.push(curr);
//        }
//        return new ArrayList<>(stack);
    }
    public int gcd(int a, int b) {
        // Euclidean Algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public  int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    public static void main(String[] args) {
        int n=36;
        Collections.sort(factorsof(n),Comparator.reverseOrder());
        System.out.println(factorsof(n));

    }
}
