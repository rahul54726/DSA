package com.LeetCode.Hard;

public class FindInMountainArray {
     public interface MountainArray {
      public int get(int index);
      public int length();
  }
   static int search(int[] arr,int target){
      if(arr.length==0) return -1;
      int start=0;
      int end=peakIndexInMountainArray(arr);
      while (start<=end){
//            find mid element
          int mid=start+(end-start)/2;
          if(arr[mid]>target){
              end=mid-1;
          }
          else if(arr[mid]<target){
              start=mid+1;
          }
          else return mid;

      }
      return -1;
  }
    static int peakIndexInMountainArray(int[] arr) {
        int s=0;
        int e=arr.length-1;
        while(s<e){
            int m=s+(e-s)/2;
            if(arr[m]>arr[m+1]) e=m;
            else s=m+1;
        }
        return s;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,3,1};
        System.out.println(search(arr,3));
    }
}
