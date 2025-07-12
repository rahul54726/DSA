package com.SortingAlorithm;
import java.util.Arrays;
import java.util.Scanner;
//Also knowns as sinkking sort,Exchange sort
public class BubbleSort {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the Size of Array -> ");
        int n=in.nextInt();
        int [] arr=new int[n];
        System.out.print("Input the Array -> ");
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        Display(arr);
        Bubblesort(arr);
//        After sorting the array
        System.out.println("Sorted array is ");
        Display(arr);
    }
    static void Bubblesort(int[] arr){
        boolean swapped;
        //run the steps n-1 time
        for(int i=0;i<arr.length;i++){
            swapped=false;
            //for each step , max item will come at last respective index
            for (int j=1;j<arr.length-i;j++){
                //compare and swap
                if(arr[j-1]>arr[j]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                    swapped=true;
                }
            }
//            if you not swap for a particular  value of i it means array is sorted
            if(!swapped) break;
        }
    }
    static void Display(int [] array){
        System.out.println("The Array is -> "+Arrays.toString(array));
    }

}
