package com.Recursion.strings;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
//     permu("","abcd");
     String str="abcd";
//        System.out.println(str.substring(1,4));
        System.out.println(permuArrylist("",str));
        System.out.println(permunum("",str));
    }
    static void permu(String p,String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            permu(first+ch+second,up.substring(1));
        }
    }
    static int permunum(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int count=0;
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            count=count + permunum(first+ch+second,up.substring(1));
        }
        return count;
    }
    static ArrayList<String> permuArrylist(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            ArrayList<String> strfrombelowcall=permuArrylist(first+ch+second,up.substring(1));
            ans.addAll(strfrombelowcall);
        }
        return ans;
    }
}
