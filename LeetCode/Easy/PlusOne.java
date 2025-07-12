package com.LeetCode.Easy;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] arr=new int[digits.length];
        for(int i=0;i<digits.length-1;i++){
            arr[i]=digits[i];
        }
        arr[digits.length-1]=digits[digits.length-1]+1;
        if(arr[arr.length-1]%10==0){
            arr[arr.length-2]=(digits[arr.length-1]+1)/10;
            arr[arr.length-1]=0;
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] digits={9};
        for(int i=0;i<digits.length;i++){
            System.out.println(digits[i]);
        }
    }
}
