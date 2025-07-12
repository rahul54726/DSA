package com.LeetCode.BinarySearch;

public class BS {
    public static int ceiling(int[] nums,int target){
        int start = 0;
        int end = nums.length - 1;
        if(target > nums[end]) return -1;
        while(start <= end){
            int mid = start + (end - start) / 2 ;
            if(target == nums[mid]) return nums[mid];
            if(target > nums[mid]) start = mid + 1 ;
            else end = mid -1;
        }
        return nums[start];
    }
    public static int floor(int[] nums,int target){
        int start = 0;
        int end = nums.length - 1;
        if(target < nums[start]) return -1;
        while(start <= end){
            int mid = start + (end - start) / 2 ;
            if(target == nums[mid]) return nums[mid];
            if(target > nums[mid]) start = mid + 1 ;
            else end = mid -1;
        }
        return nums[end];
    }
    // Birnary Searsch for Infinite Array
    static  int ans(int[] arr,int target){
        int start = 0 ;
        int end = 1;
        // condition for Scope finding
        while (target > arr[end]){
            int newStart = end +1;
            end = end + (end-start+1)*2;
            start = newStart;
        }
        return BSInfinite(arr,target,start,end);
    }
    private   static int BSInfinite(int[] nums,int target,int start ,int end){
        if(start > end) return -1;
        int mid = start +(end-start)/2;
        if(nums[mid] == target) return mid;
        else if (target > nums[mid]) {
            return BSInfinite(nums,target,mid+1,end);
        }
        else {
            return BSInfinite(nums,target,start,mid-1);
        }

    }
    public  static  int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2 ;
            if(arr[mid]>arr[mid+1] ){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length()-1;

        while(start <= end){
            int mid = start + (end - start) / 2 ;
            if(mountainArr.get(mid)> mountainArr.get(mid+1) ){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        int peak = start;
        int index = find(target,mountainArr,0,peak,true);
        if (index != -1) return index;
        return find(target,mountainArr,peak+1,mountainArr.length()-1,false);
    }

    private int find(int target, MountainArray mountainArr, int start, int end,boolean flag) {
        if(start > end ) return -1;
        int mid = start +(end-start)/2;
        int midValue = mountainArr.get(mid);
        if(midValue == target) {
            return mid;
        }
        if(flag){
            if(target < midValue) return find(target,mountainArr,start,mid - 1,true);
            else return find(target,mountainArr,mid+1,end,true);
        }
        else {
            if(target < midValue) return find(target,mountainArr,mid+1,end,false);
            else return find(target,mountainArr,start,mid-1,false);
        }
    }
    public int search(int[] nums, int target) {
        int pivot = pivot(nums);
        if(pivot == -1){
            // normal binary Search
           return binarysearch(nums,target,0,nums.length - 1);
        }
        // pivot exist
        if(nums[pivot] == target) return pivot;
        if(target > nums[0]){
            return binarysearch(nums,target,0,pivot);
        }
        return binarysearch(nums,target,pivot,nums.length - 1);
    }
    static int pivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end- start) / 2;
            if( mid < end && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if(mid > start && nums[mid] < nums[mid-1]) {
                return mid - 1;
            }
           else if(nums[mid] <= nums[start]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }static int pivotForDuplicates(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end- start) / 2;
            if( mid < end && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if(mid > start && nums[mid] < nums[mid-1]) {
                return mid - 1;
            }
           // if elements at start end and mid are same then skipp the duplicates
            if(nums[start] == nums[mid] && nums[start] == nums[end]){
                // skip duplicates
                // NOTE : what if one of these are pivot so
                // first make sure any one of them is not pivot
                if (nums[start] > nums[start+1]){
                    return start;
                }
                start++;
                if(nums[end] < nums[end-1]){
                    return end-1;
                }
                end--;

            }
            else if(nums[mid] > nums[start] || (nums[start] == nums[mid]) && nums[mid]>nums[end]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
    static int binarysearch(int[] arr,int target,int s,int e){
        if(s>e){
            return -1;
        }
        int mid=s+(e-s)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>target){
            return   binarysearch(arr,target,s,mid-1);
        }

        return binarysearch(arr,target,mid+1,e);

    }
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for(int num : nums){
            start = Math.max(start,num);
            end += num;
        }
        // binary search
        while (start < end){
            // try for potential answer
            int mid = start + (end - start) / 2;

            // calculate how many times we can devide this with maxSum
            int sum = 0;
            int pieces = 1;
            for(int num : nums){
                if(sum + num > mid){
                    // cant ad this in this subarray make new subarray
                    sum = num;
                    pieces++;
                }
                else {
                    sum += num;
                }
            }
            if(pieces > k){
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
        return end;

    }
    public static void main(String[] args) {
        System.out.println(ceiling(new int[]{2,3,5,9,14,16,18},19));
        System.out.println(ans(new int[]{2,3,5,9,14,16,18},14));
        System.out.println(floor(new int[]{2,3,5,9,14,16,18},1));
    }
}
