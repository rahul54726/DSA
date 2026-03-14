package com.PatternPrinting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int num=sc.nextInt();
        System.out.println("Pattern 1 : ");
//        pattern1(num);
//        pattern3(5);
//        pattern4(5);
        pattern8(5);


    }
    public static void pattern1(int n){
        for(int row = 0; row <n; row++){
            for (int col=0;col<=n;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n){
        for(int row = 0; row <n; row++){
            for (int col=0;col<=row;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }public static void pattern3(int n){
        for (int i = 0;i < n;i++){
            for(int j = n;j>i;j--){
                System.out.print("@ ");
            }
            System.out.println();
        }
    }
    public static void pattern4(int n){
        for(int r = 1;r <=n;r++){
            for (int c = 1; c <= r ; c++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }public static void pattern7(int n){
        for(int r = 1;r <=n;r++){
            for (int c = 1; c <= r ; c++) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
    public static void pattern8(int n){
        int count = 0;
        for(int r = 0;r <n;r++){
            for (int c = 0; c < r ; c++) {
                count++;
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }public static void pattern9(int n){
        int count = 0;
        for(int r = 0;r <n;r++){
            for (int c = 0; c < r ; c++) {
                count++;
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }
    public static void pattern5(int n){
        for(int row = 1; row <2*n; row++){
            int colForRow=row>n ? 2*n -row-1 :row;
            for (int col=1;col<colForRow;col++){
                System.out.print(col +" ");
            }
            System.out.println();
        }
    }
    
}
