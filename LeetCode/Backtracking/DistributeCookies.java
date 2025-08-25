package com.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DistributeCookies {
    private int result ;
    public int distributeCookies(int[] cookies, int k) {
        result = Integer.MAX_VALUE;
        int[] children = new int[k];
         solve(cookies,k,0,children);
         return result;
    }

    private void solve(int[] cookies, int k, int i,int[] children) {
        if (i >= cookies.length){
            int unfairness = Integer.MIN_VALUE;
            for(int num :children) {
                unfairness = Math.max(num, unfairness);
            }
            result = Math.min(unfairness,result);
            return;
        }
        int cookie = cookies[i];
        for (int j = 0; j < k ; j++) {
            children[j] += cookie;
            solve(cookies,k,i+1,children);
            children[j] -= cookie;
            if(children[j] == 0) break;
        }
    }

}
