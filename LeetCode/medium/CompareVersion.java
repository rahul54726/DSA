package com.LeetCode.medium;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length = Math.max(v2.length, v1.length);
        for (int i = 0;i<length;i++){
            int num1 = (i<v1.length) ? Integer.parseInt(v1[i]) : 0;
            int num2 = (i<v2.length) ? Integer.parseInt(v2[i]) : 0;
            if (num2 > num1) return -1;
            if (num2 < num1) return 1;
        }
        return 0;
    }
}
