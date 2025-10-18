package com.LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LcEasy {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prev =  "";
        for(String word : words){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if(!sorted.equals(prev)){
                result.add(word);
                prev = sorted;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println();
    }
}
