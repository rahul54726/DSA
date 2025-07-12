package com.Recursion.strings;
import java.util.ArrayList;
public class Dice {
    public static void main(String[] args) {
        System.out.println(dice("",4));
        System.out.println(dice("",4,new ArrayList<>()));
    }
    static ArrayList<String> dice(String p, int target){
        if(target==0){
            ArrayList<String> list =new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        for (int i = 1; i <= 6 && i<=target; i++) {
            ans.addAll(dice(p+i,target-i));
        }
        return  ans;
    }
    static ArrayList<String> dice(String p, int target , ArrayList<String> list){
        if(target==0){

            list.add(p);
            return list;
        }

        for (int i = 1; i <= 6 && i<=target; i++) {
            dice(p+i,target-i,list);
        }
        return  list;
    }
}
