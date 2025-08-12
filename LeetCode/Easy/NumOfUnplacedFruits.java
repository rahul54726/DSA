package com.LeetCode.Easy;

import java.util.Arrays;

public class NumOfUnplacedFruits {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
       boolean[] used = new boolean[baskets.length];
       int unplacedCount = 0;
       for(int fruit:fruits){
           boolean placed = false;
           for (int i = 0;i<baskets.length;i++){
               if(!used[i] && baskets[i] >= fruit){
                   used[i] = true;
                   placed = true;
                   break;
               }
           }
           if (!placed) {
               unplacedCount++;
           }
       }
       return unplacedCount;
    }

}
