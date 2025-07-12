package com.Recursion.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
      int[] arr={4,3,2,1};
        bubblesort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }
    static void bubblesort(int[] arr,int end,int start){
        if(end==0){
            return;
        }
        if(end<start){
            if (arr[start]>arr[start+1]){
//                swap
               int temp=arr[start];
               arr[start]=arr[start+1];
               arr[start+1]=temp;
            }
            bubblesort(arr,end,start+1);
        }
        else {
            bubblesort(arr,end-1,0);
        }
    }
}
