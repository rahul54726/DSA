package com.LeetCode.Backtracking;

import java.util.*;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        solve(nums,result,inner,used);
        return  result;

    }

    private void solve(int[] nums, List<List<Integer>> result, List<Integer> inner,boolean[] used) {
        if(inner.size() == nums.length){
            result.add(new ArrayList<>(inner));
            return;
        }
        for (int i = 0;i<nums.length;i++){
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            inner.add(nums[i]);
            solve(nums,result,inner,used);
            inner.remove(inner.size()-1);
            used[i] = false;
        }
    }
}
