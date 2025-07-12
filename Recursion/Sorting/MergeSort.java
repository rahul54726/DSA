package com.Recursion.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length=in.nextInt();
        int[] arr= new int[length];
        for(int i=0;i<length;i++){
            arr[i]=in.nextInt();
        }
//        arr=mergesort(arr);
//        System.out.print(Arrays.toString(arr));
        InplacemergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static int[] mergesort(int[] arr){
        if(arr.length==1) return arr;
        int mid=arr.length/2;
        int[] right=mergesort(Arrays.copyOfRange(arr,mid,arr.length));
        int[] left=mergesort(Arrays.copyOfRange(arr,0,mid));
        return merge(left,right);
    }

    private static int[] merge(int[] first, int[] second) {
            int [] mixarr = new int[first.length + second.length];
            int i=0;
            int j=0;
            int k=0;
            while (i<first.length && j<second.length){
                if(first[i]<second[j]){
                    mixarr[k]=first[i];
                    i++;
                }
                else {
                    mixarr[k]=second[j];
                    j++;
                }
                k++;

            }
//            it may be possible that one the array is not complete then we copy the remaining elements
        while (i<first.length){
            mixarr[k]=first[i];
            i++;
            k++;
        }while (j<second.length){
            mixarr[k]=second[j];
            j++;
            k++;
        }
            return mixarr;
    }
    static void InplacemergeSort(int[] arr,int start ,int end){
        int mid=start+(end-start)/2;
        if(end-start==1){
            return ;
        }
        InplacemergeSort(arr,start,mid);
        InplacemergeSort(arr,mid,end);
         mergeInplace(arr,start,mid,end);
    }

    private static void mergeInplace(int[] arr, int start, int mid, int end) {
        int[] mixArr=new int[end-start];
        int i=start;
        int j=mid;
        int k=0;
        while (i<mid && j<end){
            if(arr[i]<arr[j]){
                mixArr[k]=arr[i];
                i++;
            }
            else {
                mixArr[k]=arr[j];
                j++;
            }
            k++;
        }
        while (i<mid){
            mixArr[k]=arr[i];
            i++;
            k++;
        }
        while (j<end){
            mixArr[k]=arr[j];
            j++;
            k++;
        }
        for (int l=0;l<mixArr.length;l++){
            arr[start+l]=mixArr[l];
        }
    }
}
