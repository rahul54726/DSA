package com.RangeQuery;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] arr={1,3,5,2,7,6,3,1,4,8};
        int n=arr.length;
        //build a blocks  array
        int sqrt= (int) Math.sqrt(n);
        int[] blocks=new int[sqrt+1];
        int blocks_id=-1;

        for (int i=0;i<n;i++){
            // new block
            if(i%sqrt == 0){
                blocks_id++;
            }
            blocks[blocks_id] += arr[i];
        }
//        System.out.println(Arrays.toString(blocks));
//        System.out.println(query(blocks,arr,2,7,3));
        System.out.println(reverse(-1230));
    }
    public static int query(int[] blocks, int[] arr , int left, int right, int sqrt){
        int ans=0;
        //left
        while (left%sqrt != 0 && left<right && left!=0){
            ans+=arr[left];
            left++;
        }
        //middle part
        while (left+sqrt<=right){
            ans+= blocks[left/sqrt];
            left+=sqrt;
        }
        //right part
        while (left<=right){
            ans+=arr[left];
            left++;
        }
        return ans;
    }
    public static void update(int[] blocks,int[] arr,int index,int val,int sqrt ){
        int blocks_id=index/sqrt;
        blocks[blocks_id]+=(val-arr[index]);
        arr[index]=val;
    }
    public static int reverse(int x) {
        int rev=0;
        while (x!=0){
            int rem=x%10;
            if(rev>Integer.MAX_VALUE/10 || rev==Integer.MAX_VALUE/10 && rem>7){
                return 0;
            }
            if(rev<Integer.MIN_VALUE/10 || rev==Integer.MIN_VALUE/10 && rem<-8){
                return 0;
            }
            rev=rem+rev*10;
            x/=10;
        }

        return rev;
    }
}
