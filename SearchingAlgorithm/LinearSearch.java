package com.SearchingAlgorithm;

import java.util.Date;
import java.util.Scanner;

public class LinearSearch {
    static void Display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
     static int search(int[] arr,int val){
        int count=0;
        System.out.print("Item found at index ");
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n=in.nextInt();
        int[] arr=new int[n];
        System.out.println("Input Array");
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        System.out.println("The Array is ");
        Display(arr);
        System.out.println();
        System.out.println("Enter the number you want to search in Array ");
        int value=in.nextInt();
        System.out.println(search(arr,value));
    }
}
