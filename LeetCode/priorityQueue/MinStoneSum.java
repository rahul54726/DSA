package com.LeetCode.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinStoneSum {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int num:piles) {
            sum += num;
            queue.offer(num);
        }
        while (k>0){
            int top = queue.poll();
            int reduced = top - top / 2;
            sum -= top/2;
            queue.offer(reduced);
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minStoneSum(new int[]{5,4,9},2));
    }
}
