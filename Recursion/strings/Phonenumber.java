package com.Recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class Phonenumber {
//    static List<String> letterCombination(String digits){
//        if (digits.isEmpty()){
//            ArrayList<String> list=new ArrayList<>();
//            list.add()
//        }
//    }
    static ArrayList<String> lettercombination(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        int digit= up.charAt(0)-'0'; //this will convert '2' into 2
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch=(char) ('a'+i);
           ans.addAll( lettercombination(p+ch,up.substring(1)));
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(lettercombination("","7"));
        System.out.println(lettercombination("","9"));

    }
}
