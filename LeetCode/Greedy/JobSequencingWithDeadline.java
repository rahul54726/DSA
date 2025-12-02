package com.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingWithDeadline {
    public  static int maxProfit(int[][] jobs){
        int profit = 0;
        int max = Integer.MIN_VALUE;
        for (int[] job:jobs){
            max = Math.max(max,job[1]);
        }
        Arrays.sort(jobs,  (a, b) -> Integer.compare(b[0], a[0]));
        boolean[] occupied = new boolean[max];
        for (int[] job : jobs) {
            int deadLine = job[1];
            for (int j = deadLine-1; j >= 0; j--) {
                if (!occupied[j]) {
                    occupied[j] = true;
                    profit += job[0];
                    break;
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[][]{
                {35,3},
                {30,4},
                {25,4},
                {20,2},
                {15,3},
                {12,1},
                {5,2}
        }));
    }
}
