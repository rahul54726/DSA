package com.CodeForces;


import java.util.Scanner;

public class SumOfRoundNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();;
        while (t -- > 0){
            int n = sc.nextInt();
            int i = 0;
            System.out.println(dig(n));
            while (n > 0){
                int rem = n %10;
                if(rem != 0){
                    int ans = rem * (int)Math.pow(10 , i);
                    System.out.print(ans + " ");
                }
                n/=10;
                i++;
            }

            System.out.println();
        }
    }
    private static int dig(int n){
        int count = 0;
        while (n > 0){
            if(n%10 != 0) count++;
            n/=10;
        }
        return count;
    }
}
