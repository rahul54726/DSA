package com.DSAMaths;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public static int countPrimeSetBits(int left, int right) {
        

        int count = 0;
        while(left <= right){
            int sBits =setBits(left);
            if(isPrime(sBits)) count++;
            left++;
        }
        return count;
    }
    private static int setBits(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) == 1) count++;
            n >>= 1;
        }
        return count;
    }
    private static boolean isPrime(int n) {
        if(n <=1) return false;
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) return false;
            c++;
        }
        return true;
    }
    public int binaryGap(int n) {
        while((n & 1) == 0) n>>=1;
        if( n == 1) return 0;
        int max = 0;
        while(n != 0){
            int count = 0;
            int lsb = n & 1;
            do{
                count++;
                n >>= 1;
                lsb = n & 1;
            }while(lsb == 0);
            max = Math.max(max , count);
            n>>=1;
        }
        return max;
    }
    public static boolean hasAllCodes(String s, int k) {
        Set<String> codes = new HashSet<>();
        for(int i = 0;i < s.length() - k;i++){
            codes.add(s.substring(i , i + k));
        }
        System.out.println(codes);
        List<String> allCodes = contains(k);
        for(String code : allCodes){
            if(!codes.contains(code)) return false;
        }
        return true;
    }
    private static List<String> contains(int k){
        List<String> strs = new ArrayList<>();
        for(int i = 0;i<=k;i++){
            String s = "";
            if(i < 2){
                s+=0;
            }
            strs.add(s + Integer.toBinaryString(i));
        }
        System.out.println(strs);
        return strs;
    }
    public static int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a , b) ->{
            if(a[1] == b[1]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for(int num : arr){
            que.offer(new int[]{num , setBits1(num)});
        }
        int idx = 0;
        while(!que.isEmpty()){
            int[] curr = que.poll();
            arr[idx++] = curr[0];
        }
        return arr;
    }
    private static int setBits1(int n){
        int count = 0;
        while(n > 0){
            if((n & 1 ) == 1) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
    }
}