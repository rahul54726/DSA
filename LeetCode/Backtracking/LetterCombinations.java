package com.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();

        map.put('1',".");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(0,digits,sb,map,result);
        if (result.contains("kiran")) System.out.println("yes" + result.indexOf("kiran"));
        return result;
    }

    private  static void backtrack(int idx, String digits, StringBuilder temp, Map<Character,String> map,List<String> result) {
        if (idx >= digits.length()){
            result.add(temp.toString());
            return;
        }
        char ch = digits.charAt(idx);
        String str = map.get(ch);
        for (int i = 0;i<str.length();i++){
            temp.append(str.charAt(i));
            backtrack(idx+1,digits,temp,map,result);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("123456789"));
    }
}
