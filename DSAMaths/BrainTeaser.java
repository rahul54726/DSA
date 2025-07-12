package com.DSAMaths;

import java.util.Arrays;
import java.util.HashMap;

public class BrainTeaser {
    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
    public static int addDigits(int num) {
        if(num/10==0) return num;
        while (num >= 10){
            num=helper(num);
        }
        return num;
    }
    private static int helper(int num){
        int ans=0;
        while (num!=0){
            ans+=num%10;
            num/=10;
        }
        return ans;
    }
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    public static int[] numMovesStones(int a, int b, int c) {
        int[] positions={a,b,c};
        Arrays.sort(positions);
       int x=positions[0];
        int y=positions[1];
        int z=positions[2];
        int gap1=y-x-1;
        int gap2=z-y-1;
        int minMoves;
        if(gap1 == 0 && gap2 == 0) minMoves=0;
        else if(gap1<=1 || gap2<=1) minMoves=1;
        else minMoves=2;
        int maxMoves=gap1+gap2;
        return new int[]{minMoves,maxMoves};
    }
    private static int mod(int num){
        if(num<0) return -1*num;
        return num;
    }
    public static int maximumGap(int[] nums) {
        int length=nums.length;
        if(length<2) return 0;
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for(int i=1;i<length;i++){
            gap = Math.max(gap,nums[i]-nums[i-1]);
        }
        return gap;
    }
    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return candidate;

    }
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;
        for(int i=0;i<n;i++){
            int h=n-i;
            if(citations[i] >= h) return h;
        }
        return 0;
    }
    public static double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1.0 : 0.5;
    }
    public static void main(String[] args) {
//        int num=0;
//        System.out.println(canWinNim(43));
//        System.out.println(Arrays.toString(numMovesStones(1,2,5)));
//        System.out.println(maximumGap(new int[]{1,2,8,9,4}));
        System.out.println(nthPersonGetsNthSeat(5));
    }

}
