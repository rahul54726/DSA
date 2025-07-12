package com.LeetCode.Hard;

import java.util.*;

public class KMirror {
//    public static long kMirror(int k,int n){
//        long sum = 0;
//        int count = 0;
//
//        int length = 1;
//        while (count < n) {
//            List<Long> palindromes = generatePalindromes(length);
//            for (long num : palindromes) {
//                if (count >= n) break;
//                if (isPalindrome(toBaseK(num, k,""))) {
//                    sum += num;
//                    count++;
//                }
//            }
//            length++;
//        }
//        return sum;
//    }
    private static List<Long> generatePalindromes(int length) {
        List<Long> palindromes = new ArrayList<>();
        int halfLength = (length + 1) / 2;
        long start = (long) Math.pow(10, halfLength - 1);
        long end = (long) Math.pow(10, halfLength);
        for (long i = start; i < end; i++) {
            String half = String.valueOf(i);
            String palindrome = half + new StringBuilder(half.substring(0, length % 2 == 0 ? half.length() : half.length() - 1)).reverse();
            palindromes.add(Long.parseLong(palindrome));
        }
        return palindromes;
    }
    public static String toHex(int num){
        if (num == 0) return "0";

        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder hexString = new StringBuilder();

        // Use unsigned right shift (>>>), so we only care about the last 4 bits at a time.
        while (num != 0 && hexString.length() < 8) { // Max length is 8 for a 32-bit integer
            int lastFourBits = num & 15; // Get the last 4 bits
            hexString.append(hexChars[lastFourBits]);
            num >>>= 4; // Unsigned right shift by 4 bits
        }

        return hexString.reverse().toString();

    }
    private static String toBaseK(int n,int base,String str,Map<Integer,Character> map){
        if(n==0){
            return str;
        }
        int rem = n % base;
        str+=map.get(rem);
        return toBaseK(n/base,base,str,map);
    }
    private static  boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while (left<=right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    private static String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
//        System.out.println(isPallindrome("abca"));
//        System.out.println(kMirror(7,17));
//        System.out.println(toBaseK(1,3,""));
//        int a = 1;
//        char ch = (char)(2+'0');
//        System.out.println(ch);
        System.out.println(toHex(-1));
    }

}
