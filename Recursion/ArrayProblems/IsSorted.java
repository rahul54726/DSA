package com.Recursion.ArrayProblems;
import java.util.ArrayList;
import java.util.Arrays;

public class IsSorted {
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
//        System.out.println(sorted(arr,0));
//        System.out.print("enter target : ");
//        int target=in.nextInt();
//        System.out.println(Ispersent(arr,0,target));
//        System.out.println(findIndex(arr,target,0));
        int[] arr={1,2,3,4,5};
        System.out.println(findIndex(arr,4,0));
    }
    static boolean isSorted(int[] arr, int index){
//       base condition
        if(index == arr.length-1){
            return true;
        }
        return ((arr[index]<arr[index +1]) && (isSorted(arr, index +1)));
    }
    static  boolean isPresent(int[] arr, int index, int target){
        if(index ==arr.length){
            return false;
        }
        return (arr[index]==target) || isPresent(arr, index +1,target);
    }
    static int findIndex(int[] arr,int target,int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return findIndex(arr,target,index+1);
    }
    static ArrayList<Integer> list =new ArrayList<>();
    static void findAllIndex(int[] arr,int target,int index){
        if (index==arr.length) return;
        if(arr[index]==target) list.add(index);
        else findAllIndex(arr,target,index+1);
    }
    static void Display(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
