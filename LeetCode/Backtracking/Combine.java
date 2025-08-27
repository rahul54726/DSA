package com.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        solve(n,k,1,result,new ArrayList<>());
        return result;
    }
    private static void solve(int n,int k,int i,List<List<Integer>> result,List<Integer> temp){
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (i > n) return;
        temp.add(i);
        solve(n,k-1,i+1,result,temp);
        temp.remove(temp.size() - 1);
        solve(n,k,i+1,result,temp);
    }
}
