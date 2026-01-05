package com.Streams;

import java.util.*;

//class MyComparator implements  Comparator<Integer>{
//    @Override
//    public int compare(Integer o1,Integer o2){
//        return
//    }
//    is int ka matlb hai ye ek integer return karega jiska matlb agar bo -ve hai to o1 pahle ayega agar 0 ata a to samjho no need agar +ve ata a to o1 badme ayega
//}
public class Comparators {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,1,5,6,7);
        System.out.println(list);
        list.sort(null);
        System.out.println(list);
        List<String> words = Arrays.asList("banana","apple","orange","date");
        words.sort(null);
        words.sort((a,b) -> a.length() - b.length());
        words.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(words);

    }
}
