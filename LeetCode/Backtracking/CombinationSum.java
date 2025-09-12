package com.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        backtrack(candidates,target,inner,result,0);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<Integer> inner, List<List<Integer>> result, int start) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(inner));
            return;
        }
        for (int i = start ;i<candidates.length;i++){
            inner.add(candidates[i]);
            backtrack(candidates,target - candidates[i],inner,result,i);
            inner.remove(inner.size() - 1);
        }
    }
}
