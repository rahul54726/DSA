package com.LeetCode.priorityQueue;

import java.util.*;

public class FrequencySort {
    public static String frequencySort(String s ){
        Map<Character,Integer> fmap = new HashMap<>();
        for (char ch:s.toCharArray()){
            fmap.put(ch,fmap.getOrDefault(ch,0)+1);
        }
        List<Character> characters = new ArrayList<>(fmap.keySet());
        characters.sort((a,b)-> fmap.get(b) - fmap.get(a));
        StringBuilder result = new StringBuilder();
        for(char c:characters){
            int count = fmap.get(c);
            for(int i = 0;i<count;i++){
                result.append(c);
            }
        }
        return result.toString();

    }

    public static void main(String[] args) {

    }
}
