package com.LeetCode.Easy;

import com.Array.Array;

import java.util.Arrays;

public class DivideString {
    public static String[] divideString(String s, int k, char fill) {
        if(s.length() == 0){
            return new String[]{null};
        }
        int rem = s.length() % k;
//        if(rem == 0){
//            String[] ans = new String[s.length()/k];
//            for(int i = 0;i<ans.length;i++){
//                ans[i] = s.substring(i*k,(i+1)*k);
//            }
//            return ans;
//        }
            int lenght = s.length() + (k-rem);
            for(int i = s.length();i<lenght;i++){
                s = s + fill;
            }
            String[] ans = new String[s.length()/k];
            for(int i = 0;i<ans.length;i++){
                ans[i] = s.substring(i*k,(i+1)*k);
            }
            return ans;


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghi",3,'x')));
    }
}
