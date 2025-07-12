package com.LeetCode.Hard;

import java.util.ArrayList;
import java.util.List;

public class EarliestAndLatest {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int left = Math.min(firstPlayer,secondPlayer);
        int right = Math.max(firstPlayer,secondPlayer);
        if(left + right == n + 1) return new int[]{1,1};
        if(n <= 4) return new int[]{2,2};
        if(left - 1 > n - right){
            int temp = n + 1  - left;
            left = n + 1 - right;
            right = temp;
        }
        int min = n,max = 1;
        int next = (n + 1) / 2;
        if(right * 2 <= n + 1){
            int pre = left - 1,mid = right - left -1;
            for(int i = 0 ;i<= pre ;i++){
                for (int j = 0; j <= mid; j++) {
                    int[] res = earliestAndLatest(next,i+1,i + j+2);
                    min = Math.min(min,1 +res[0]);
                    max = Math.max(max,1 + res[1]);
                }
            }
        }
        else {
            int mirror  = n + 1 -right;
            int pre = left - 1;
            int mid = mirror - left - 1;
            int inBetween = right - mirror - 1;
            for(int i = 0 ;i<= pre ;i++){
                for (int j = 0; j <= mid; j++) {
                    int pos1 = i + 1;
                    int pos2 = i + j + 1 + (inBetween + 1)/2 + 1;
                    int[] res = earliestAndLatest(next,pos1,pos2);
                    min = Math.min(min,1 +res[0]);
                    max = Math.max(max,1 + res[1]);
                }
            }
        }
        return new int[]{min,max};
    }



}
