package com.Recursion.strings;

import java.util.ArrayList;
import java.util.List;
public class Permutations {
    public static void main(String[] args) {
//     permu("","abcd");
     String str="abc";
//        System.out.println(str.substring(1,4));
//        System.out.println(permuArrylist("",str));
//        System.out.println(permunum("","abc"));
//        System.out.println(permuArrylistret("","abc",new ArrayList<>()));
//        System.out.println(permuArrylistret("","abc",new ArrayList<>()).size());
        int[] arr={1,2,3};
        System.out.println(permute(arr));
    }
    static void permu(String p,String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String second=p.substring(i);
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
            count += permunum(first+ch+second,up.substring(1));
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
            String second=p.substring(i);
            ArrayList<String> strfrombelowcall=permuArrylist(first+ch+second,up.substring(1));
            ans.addAll(strfrombelowcall);
        }
        return ans;
    }
    static ArrayList<String> permuArrylistret(String p, String up,ArrayList<String> list){
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String second=p.substring(i);
            permuArrylistret(first+ch+second,up.substring(1),list);
        }
        return list;
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result , new ArrayList<>(),nums);
        return result;
    }
    private static void backtrack(List<List<Integer>> result,List<Integer> tempList,int[] nums){
        if(tempList.size()==nums.length){
            result.add(new ArrayList<>(tempList));
        }
        else{
            for(int num:nums){
                if(tempList.contains(num)){
                    continue;
                }
                tempList.add(num);
                backtrack(result,tempList,nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
