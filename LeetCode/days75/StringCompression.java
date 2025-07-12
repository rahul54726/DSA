package com.LeetCode.days75;

import java.util.HashMap;

public class StringCompression {
    public static int compress(char[] chars) {
        HashMap<Character,Integer> map=new HashMap<>();
        for (char ch:chars){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        String str="";
        for (char ch:map.keySet()){
            str+=ch;
            if(map.get(ch)==1) continue;
            str+=map.get(ch);
        }
        System.out.println(str);
        return str.toCharArray().length;
    }

    public static void main(String[] args) {
        char[] chars={'a','a','b','b','c','c','c','d'};
        System.out.println(compress(chars));
    }
}
