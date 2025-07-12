package com.Recursion.strings;
public class basic {
    static String withouta(int a,String str,String ans){
        if(a==str.length()){
            return ans;
        }
        while (a<str.length()){
            if(str.charAt(a)!='a')  return withouta(a+1,str,ans+str.charAt(a));
            else if(str.charAt(a)=='a') return withouta(a+1,str,ans);
        }
        return ans;
    }
    static void skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if(ch == 'a'){
            skip(p,up.substring(1));
        }
        else {
            skip(p+ch,up.substring(1));
        }
    }
    static String skip(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch=up.charAt(0);
        if(ch=='a'){
            return skip(up.substring(1));
        }
        else {
            return ch+skip(up.substring(1));
        }
    }
    static String skipapple(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("apple")){
            return skipapple(up.substring(5));
        }
        else {
            return  up.charAt(0)+skipapple(up.substring(1));
        }
    }
    public static void main(String[] args) {
        String str="bacdapplec";
//        String ans="";
//        System.out.println(withouta(0,str,ans));
//        skip(ans,str);
        System.out.println(skip(str));
        System.out.println(skipapple(str));

    }
}
