package com.LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinner {
    public int findTheWinner(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1;i<=n;i++){
            nums.add(i);
        }
        while (nums.size() !=1){
            nums.remove(0);
        }
        return 0;
    }
}
