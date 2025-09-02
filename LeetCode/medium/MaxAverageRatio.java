package com.LeetCode.medium;

import java.util.Arrays;

public class MaxAverageRatio {
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        double[] currPR = new double[classes.length];
        for (int i = 0;i<classes.length;i++){
            currPR[i] = (double) classes[i][0] / classes[i][1];
        }
        System.out.println( Arrays.toString(currPR));
        while (extraStudents  > 0){
            double[] updatedPR = new double[classes.length];
            for (int i = 0; i < classes.length; i++) {
                updatedPR[i] = (double)(classes[i][0] + 1)/(classes[i][1] + 1);
            }
            int bestClassIdx = 0;
            double bestDelta = 0;
            for (int i = 0;i<currPR.length;i++){
                double delta = updatedPR[i] - currPR[i];
                if (delta > bestDelta){
                    bestDelta = delta;
                    bestClassIdx = i;
                }
            }
            classes[bestClassIdx][0]++;
            classes[bestClassIdx][1]++;
            currPR[bestClassIdx] = (double)classes[bestClassIdx][0]/classes[bestClassIdx][1];
            extraStudents--;
        }
        double result = 0;
        for (double pr:currPR){
            result += pr;
        }
        return Math.round((result / classes.length) * 100000.0) / 100000.0;
    }

    public static void main(String[] args) {
        System.out.println(maxAverageRatio(new int[][]{
                {2,4},
                {3,9},
                {4,5},
                {2,10}
        },4));
    }
}
