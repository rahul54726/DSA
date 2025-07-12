package com.Recursion.strings;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
        subseq("","abc");
        System.out.println();
        subseqAscii("","ab");
        System.out.println();
        System.out.println(  subseqret("","abcd",new ArrayList<>()));
        System.out.println(  subseqret("","abcd"));
    }
    static void subseq(String p,String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch=up.charAt(0);
        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }
    static ArrayList<String> subseqret(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> left=subseqret(p+ch,up.substring(1));
        ArrayList<String> right= subseqret(p,up.substring(1));
        left.addAll(right);
        return left;
    }
    static ArrayList<String> subseqret(String p, String up,ArrayList<String> list){
        if(up.isEmpty()){

            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        subseqret(p+ch,up.substring(1),list);
         subseqret(p,up.substring(1),list);
         return list;

    }
    static void subseqAscii(String p,String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch=up.charAt(0);
        subseqAscii(p+ch,up.substring(1));
        subseqAscii(p,up.substring(1));
        subseqAscii(p+(ch+0),up.substring(1));
    }

}
