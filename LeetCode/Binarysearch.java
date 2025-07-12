package com.LeetCode;

public class Binarysearch {
    public static int minEatingSpeed(int[] piles, int h) {
        int start=0;
        int end= maxValue(piles);
        int hours = Integer.MAX_VALUE;
        while (start<=end){
            int mid=start + (end-start)/2;
            int totalhrs=findHours(piles,mid);
            if(totalhrs<=h){
                hours=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return hours;
    }
    private static int maxValue(int[] nums){
        int max=Integer.MIN_VALUE;
        for (int num:nums){
            max=Math.max(num,max);
        }
        return max;
    }
    private static int findHours(int[] arr,int k){
        int hour=0;
        for (int num:arr){
            if( num>=k && num%k==0){
                hour+=num/k;
            }
            else {
                hour+=(num/k)+1;
            }
        }
        return hour;
    }

    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        System.out.println(minEatingSpeed(piles,7));
    }

}
