package com.LeetCode.days75;

import java.util.Arrays;

public class MaxDiff {
    public static void main(String[] args) {
//        System.out.println(maxDiff(555));
        System.out.println( maximumDifference(new int[]{1,5,2,10}));
    }
    public static int maxDiff(int num) {
        int a = 0, b = 0;

        // Convert the number to a string
        String str1 = String.valueOf(num);

        // --- Calculate maximum value ---
        char toReplace = ' ';
        for (char c : str1.toCharArray()) {
            if (c != '9') {
                toReplace = c;
                break;
            }
        }

        String maxStr = str1;
        if (toReplace != ' ') {
            maxStr = str1.replace(toReplace, '9');
        }
        a = Integer.parseInt(maxStr);

        // --- Calculate minimum value ---
        String str2 = String.valueOf(num);
        toReplace = ' ';
        char replacement = ' ';

        if (str2.charAt(0) != '1') {
            // Replace the first character with '1' if it's not '1'
            toReplace = str2.charAt(0);
            replacement = '1';
        } else {
            // Otherwise, find the first non-'0' digit to replace with '0'
            for (char c : str2.toCharArray()) {
                if (c != '0' && c != '1') {
                    toReplace = c;
                    replacement = '0';
                    break;
                }
            }
        }

        String minStr = str2;
        if (toReplace != ' ') {
            minStr = str2.replace(toReplace, replacement);
        }
        b = Integer.parseInt(minStr);

        // Return the absolute difference
        return Math.abs(a - b);
    }
    public static int maximumDifference(int[] nums) {
        int minElement = nums[0];
        int maxDifference = -1; // Return -1 if no valid difference is found.

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minElement) {
                maxDifference = Math.max(maxDifference, nums[i] - minElement);
            } else {
                minElement = nums[i];
            }
        }

        return maxDifference;
    }
}
