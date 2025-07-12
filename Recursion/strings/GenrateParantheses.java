package com.Recursion.strings;
import java.util.*;
public class GenrateParantheses {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        generate(n,"",0,0,result);
        return result;
    }

    private void generate(int n,String current,int open,int close, List<String> result) {
        if(current.length()==n*2){
            result.add(current);
            return;
        }
        if(open<n){
            generate(n,current+"(",open+1,close,result);
        }
        if(close<n){
            generate(n,current+"(",open,close+1,result);
        }

    }
    public void rotate(int[] nums, int k) {
        if(k==0) return;
        if(k>nums.length){
            k=k%nums.length;
        }
        int[] copy=new int[nums.length];
        int start=nums.length-k;
        int i=0;
        while (i<nums.length){
            copy[i]=nums[start%nums.length];
            i++;
            start++;
        }
        for (int j=0;j<nums.length;i++){
            nums[j]=copy[j];
        }

    }
}
