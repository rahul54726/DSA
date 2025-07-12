package com.LeetCode.stackandQueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class GameOfTwoStack {
        static int number(int x,int[] a,int[] b){
            return number(x, a, b,0,0)-1;
        }
   private static int number(int x,int[] a,int[] b,int sum,int count){
            if(sum>x) {
                return count;
            }
            if(a.length==0 || b.length==0) {
                return count;
            }
            int ans1=number(x, Arrays.copyOfRange(a,1,a.length),b,sum+a[0],count+1);
            int ans2=number(x, a,Arrays.copyOfRange(b,1,b.length),sum+b[0],count+1);
            return Math.max(ans1,ans2);
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int m=sc.nextInt();
            int n=sc.nextInt();
            int[] a = new int[m];
            int[] b = new int[n];
            int maxSum=sc.nextInt();
            for (int i=0;i<m;i++){
                a[i]=sc.nextInt();
            }
            for (int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }
            System.out.println(number(maxSum,a,b));
        }
    }
}
