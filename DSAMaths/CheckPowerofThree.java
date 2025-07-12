package com.DSAMaths;
import java.util.*;
public class CheckPowerofThree {
    public static boolean checkPowersOfThree(int n) {
        if(n==0 || n==2) return false;
        if(n==1) return true;
        while (n>0){
            int rem = n % 3;
            if(rem == 2) return false;
            n/=3;
        }
        return true;
    }
    private static int maxpower(int n){
        int maxthreepower = 0;
        int power=0;
        while (maxthreepower<=n){
            maxthreepower = (int) Math.pow(3,power++);

        }
        return power-2;
    }
    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12));
    }
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> outer=new ArrayList<>();
//        List<Integer> initial=new ArrayList<>();
//        initial.add(1);
//        outer.add(initial);
//
//        int ptr=0;
//
//        while (ptr<=numRows){
//            int n=outer.size();
//            for(int i=0;i<n;i++){
//                List<Integer> inner =new ArrayList<>(outer.get(i));
//
//            }
//        }
//    }
}
