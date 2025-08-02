package com.LeetCode.Hard;

import java.util.*;

public class MinCost {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> fmap = new HashMap<>();
        for(int fruit:basket1){
            fmap.put(fruit, fmap.getOrDefault(fruit,0)+1);
        }
        for(int fruit:basket2){
            fmap.put(fruit, fmap.getOrDefault(fruit,0)-1);
        }
        List<Integer> swap = new ArrayList<>();
        int minFruit = Integer.MAX_VALUE;

        for(Map.Entry<Integer,Integer> entry : fmap.entrySet()){
            int count = Math.abs(entry.getValue());
            if(count%2 != 0 ) return -1;
            for(int i = 0;i<count/2;i++){
                swap.add(entry.getKey());
            }
                minFruit = Math.min(minFruit,entry.getKey());
        }
        Collections.sort(swap);
        long cost = 0;
        for(int i = 0;i<swap.size()/2;i++){
            cost += Math.min(swap.get(i),2*minFruit);
        }
        return cost;
    }

}
