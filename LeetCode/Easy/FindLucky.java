package com.LeetCode.Easy;

import java.util.HashMap;

public class FindLucky {
   public static int findLucky(int[] arr){
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int num: arr){
           map.put(num,map.getOrDefault(num,0)+1);
       }
       int max = Integer.MIN_VALUE;
       for(int key:map.keySet()){
           if(key == map.get(key)){
               max = key;
           }
       }

       return max == Integer.MIN_VALUE ? -1 : max;
   }

    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2,2,2,3,3}));
    }
}
