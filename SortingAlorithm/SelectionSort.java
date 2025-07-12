package com.SortingAlorithm;
import java.util.Arrays;
import java.util.Scanner;
public class SelectionSort {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the Size of Array -> ");
        int n=in.nextInt();
        int [] arr=new int[n];
        System.out.print("Input the Array -> ");
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        Display(arr);
        selctionsort(arr);
        Display(arr);
    }
    static void selctionsort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int last=arr.length-1-i;
            int maxIndex= getMaxvalIndex(arr,0,last);
            swap(arr,maxIndex,last);
        }
    }

    static int getMaxvalIndex(int[] arr, int start, int end) {
        int max=start;
        for(int i=start;i<end;i++){
            if (arr[max]<arr[i]){
                max=i;
            }
        }

        return max;

    }

    static void Display(int [] array){
        System.out.println("The Array is -> "+ Arrays.toString(array));
    }
    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
