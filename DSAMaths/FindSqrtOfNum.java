package com.DSAMaths;

public class FindSqrtOfNum {

    private static double sqrt(int n, int presision) {
        int s=0;
        int e=n;
        double root=0.0;

        while (s<=e){
            int m=s+(e-s)/2;
            if(m*m==n){
                return m;
            }
            if(m*m>n){
                e=m-1;
            }
             else {
                s=m+1;
                root=m;
            }
        }
        double increment=0.1;
        for (int i = 0; i < presision; i++) {
            while (root*root<=n){
                root+=increment;
            }
            root-=increment;
            increment/=10;
        }

        return root;
    }
    public static double cuberoot(int n) {
        int s = 0;
        int e = n;
        double root = 0.0;

        // Binary search to find the integer part of the cube root
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (m * m * m == n) {
                return m;
            }
            if (m * m * m > n) {
                e = m - 1;
            } else {
                s = m + 1;
                root = m; // Initialize root here
            }
        }

        // Refining the result to get a more precise floating-point answer
        double increment = 0.1;
        for (int i = 0; i < 5; i++) { // Let's assume we need up to 5 decimal places
            while (root * root * root <= n) {
                root += increment;
            }
            root -= increment;
            increment /= 10;
        }

        return root;
    }
    static double newtonraphsonsqrt(double n){
        double x=n;
        double root;
        while (true){
            root=0.5*(x+(n/x));
            if(Math.abs(root-x)<0.5){
                break;
            }
            x=root;
        }
        return root;
    }


    public static void main(String[] args) {
        int n=40;
        int p=3;
        System.out.printf("%.3f" ,sqrt(n,p));
        System.out.println();
        System.out.printf("%.3f",cuberoot(n));
        System.out.println();
        System.out.printf("%.3f",newtonraphsonsqrt(n));
       
    }

}
