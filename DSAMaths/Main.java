package com.DSAMaths;

import com.Rahul.abstraction.Parent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
        printReverse(n);
        printEven(n);
        printOdd(n);
        printTable(4);
        System.out.println(sum(n));
        System.out.println(sumEven(n));
        System.out.println(sumOdd(n));
        System.out.println(solve("1 2 3 4 4 "));
    }
    private static void print(int n){
        for(int i = 0;i <= n;i++) System.out.println(i);
    }private static void printTable(int n){
        for(int i = 0;i <= 10;i++) System.out.println(i * n);
    }
    private static void printOdd(int n){
        for(int i = 0;i <= n;i++) {
            if((i&1)==1) System.out.println(i);
        }
    }
    private static int sumEven(int n){
        System.out.print("Sum of first " + n +" Even number is : ");
        int sum= 0;
        for(int i = 0;i <= n;i++) {
            if((i&1)==0) sum+=i;
        }
        return sum;
    }private static int sumOdd(int n){
        System.out.print("Sum of first " + n +" Odd number is : ");
        int sum= 0;
        for(int i = 0;i <= n;i++) {
            if((i&1)==1) sum+=i;
        }
        return sum;
    }
    private static void printReverse(int n){
        for(int i = n;i >= 0;i--) System.out.println(i);
    }private static void printEven(int n){
        for(int i = n;i >= 0;i--) {
            if((i&1)==0) System.out.println(i);
        }
    }
    private static int sum(int n){
        System.out.print("Sum of first " + n +" natural number is : ");
        return (n * (n + 1)) / 2;
    }
    public static int[] closestPair(int[] arr, int target) {
        int l = 0 , r = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int ans1 = 0 , ans2 = 0;


        while (l < r){
            int sum = arr[l] + arr[r];
            int diff = Math.abs(sum - target);
            if (diff < minDiff || (diff== minDiff &&
                    (arr[l] < ans1 || (arr[l] == ans1 && arr[r] < ans2)) )){
                minDiff = diff;
                ans1 = arr[l];
                ans2 = arr[2];

            }
            if (sum == target) r--;
            else if (sum < target) {
                l++;
            }
            else r--;
        }
        return new int[]{ans1 , ans2};
    }
    public static float solve(String s){
        String[] strs = s.split(" ");
        List<Float> numbers = new ArrayList<>();
        for (String str : strs) numbers.add(Float.parseFloat(str));
        HashMap<Float , Integer> fmap = new HashMap<>();
        for (float num : numbers) fmap.put(num , fmap.getOrDefault(num , 0) + 1);
        float sum = 0;
        for (float key : numbers) {
            if (fmap.get(key) == 2) sum += key;
        }
        return sum / 2;
    }
}
