package com.LeetCode.Backtracking;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumRequests {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        Map<int[],Integer> map= new HashMap<>();
        for (int i = 0;i<dimensions.length;i++){
            map.put(dimensions[i],dimensions[i][0]*dimensions[i][0]+dimensions[i][1]*dimensions[i][1]);
        }
        PriorityQueue<Map.Entry<int[],Integer>> priorityQueue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        priorityQueue.addAll(map.entrySet());
        int[] result = priorityQueue.poll().getKey();
        return result[0]*result[1];
    }
}
