package com.LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class KthChar {
    public static char kthCharacter(int k) {
        String word = "a";
        while (word.length()<=k){
            String funS= operation1(word);
            word+=funS;
        }
        System.out.println(word);
        return word.charAt(k-1);
    }


    public static char kthCharacter(long k, int[] operations) {
        if (k == 1) return 'a';  // Assuming base character is 'a'

        long len = 1;
        int operationType = 0;
        long newK = -1;

        for (int i = 0; i < operations.length; i++) {
            len *= 2;
            if (len >= k) {
                operationType = operations[i];
                newK = k - len / 2;
                return transform(kthCharacter(newK, operations), operationType);
            }
        }

        // If we reach here, k was out of range
        throw new IllegalArgumentException("Invalid k value: " + k);
    }

    private static char transform(char ch, int operationType) {
        if (operationType == 0) {
            return ch;
        } else {
            return (ch == 'z') ? 'a' : (char) (ch + 1);
        }
    }

    private static String operation1(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == 'z'){
                ch = 'a';
                sb.append(ch);
            }
            else sb.append((char)(ch+1));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
//        System.out.println(fun("za"));
        System.out.println(kthCharacter(10,new int[]{0,1,0,1}));
//        System.out.println((char) ('a'+1));
    }
}
