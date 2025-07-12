package com.LeetCode.medium;

public class LongestSubsequence {
    public static   int longestSubsequence(String s,int k){
        int length = 0;
        int n = s.length() ;
        int powerVal = 1;
        for(int i = n-1;i>=0;i--){
            if(s.charAt(i) == '0'){
                length++;
            }
            else if (powerVal <= k){
                k -= (powerVal);
                length++;
            }
            if(powerVal <= k){
                powerVal *= 2;
            }
        }
        return length;
    }

    private static int solve(String s, int k, int i,int cuurentVal,int count) {
        if(i<0){
            return count;
        }
        int bit = s.charAt(i) - '0';
        int power = 1 << (s.length() - 1 - i);
        int include = 0;
        int val = bit * (1 << s.length() - 1 - i);
        if(bit == 0 || cuurentVal + power * bit <= k){
            include = solve(s,k,i-1,cuurentVal+power*bit,count+1);
        }

        int exclude = solve(s,k , i -1,cuurentVal,count);
        return Math.max(include,exclude);
    }

    private static String toBinary(int num ,StringBuilder p){
        if(num == 0){
            return p.reverse().toString();
        }
        p.append(num%2);
        return toBinary(num/2,p);
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence("1001010",5));
    }
}
