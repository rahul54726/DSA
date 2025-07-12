package com.Recursion.ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        Scanner in =new Scanner(System.in);
//        System.out.print("Enter the Size of array : " );
//        int n=in.nextInt();
//        int[] arr=new int[n];
//        System.out.print("Input Array : ");
//        for(int i=0;i<n;i++){
//            arr[i]=in.nextInt();
//        }
//        System.out.print("The Array is : ");
//        Display(arr);
//        System.out.print("enter target : ");
//        int target=in.nextInt();
////        ArrayList<Integer> list=new ArrayList<>();
//        System.out.println(IndexFound(arr,target,0,new ArrayList<>()));
////        System.out.println(IndexFind(arr,target,0));
        int[] arr= {1,2,3,4,4,5};
        System.out.println(IndexFind(arr,4,0));
    }
    static ArrayList<Integer> IndexFound(int[] arr,int target,int index,ArrayList<Integer> list){
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return IndexFound(arr,target,index+1,list);

    }
    static ArrayList<Integer> IndexFind(int[] arr,int target,int index){
        ArrayList<Integer> list =new ArrayList<>();
        if(index==arr.length-1){
            return list;
        }
//        this will contain answer for this function call only
        if(arr[index]==target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls =  IndexFind(arr,target,index+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
    static void Display(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
