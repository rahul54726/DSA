package com.Recursion.ArrayProblems;

import java.util.Arrays;
import java.util.Scanner;

public class IsSorted {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter the Size of array : " );
        int n=in.nextInt();
        int[] arr=new int[n];
        System.out.print("Input Array : ");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.print("The Array is : ");
        Display(arr);
        System.out.println(sorted(arr,0));
        System.out.print("enter target : ");
        int target=in.nextInt();
        System.out.println(Ispersent(arr,0,target));
    }
    static boolean sorted(int[] arr,int index){
//       base condition
        if(index == arr.length-1){
            return true;
        }
        return ((arr[index]<arr[index +1]) && (sorted(arr, index +1)));
    }
    static  boolean Ispersent(int[] arr, int index, int target){
        if(index ==arr.length){
            return false;
        }
        return (arr[index]==target) || Ispersent(arr, index +1,target);
    }
    static void Display(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
