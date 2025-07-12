package com.LeetCode.Hard;

public class KthSmallestProduct {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long result = 0;
        long l = (long) -1e10;
        long r = (long) 1e10;
        while (l<=r){
            long midProduct = l + (r-l)/2;
            long countSmallest = find(nums1,nums2,midProduct);
            if(countSmallest >= k){
                result = midProduct;
                r = midProduct -1;
            }
            else{
                l = midProduct+1;
            }
        }
        return result;
    }

    private long find(int[] nums1, int[] nums2, long midProduct) {
        long productCount = 0;
        int n = nums2.length ;
        for(int i = 0;i<nums1.length ; i++){
            if(nums1[i]>=0){
                int l = 0;
                int r = n -1;
                int m = -1;
                while (l<=r){
                    int mid  = l + (r - l) /2;
                    long product = (long) nums1[i] * nums2[mid];
                    if(product <= midProduct){
                        m = mid;
                        l = mid + 1;
                    }
                    else {
                        r = mid - 1;
                    }
                }
                productCount += (m+1);
            }
            else {
                int l = 0;
                int r = n -1;
                int m = n;
                while (l<=r){
                    int mid  = l + (r - l) /2;
                    long product = (long) nums1[i] * nums2[mid];
                    if(product <= midProduct){
                        m = mid;
                        r = mid - 1;
                    }
                    else {
                        l = mid + 1;
                    }
                }
                productCount += (n - m);
            }
        }
        return productCount;
    }
}
