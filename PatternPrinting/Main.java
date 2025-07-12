package com.PatternPrinting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        System.out.println("Pattern 1 : ");
        pattern1(num);
        System.out.println("Pattern 2 : ");
        pattern2(num);
        System.out.println("Pattern 3 : ");
        pattern3(num);
        System.out.println("Pattern 4 : ");
        pattern4(num);
        System.out.println("Pattern 5 : ");
        pattern5(num);

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
        for(int row = 1; row <=n; row++){
            for (int col=1;col<=row;col++){
                System.out.print(col +" ");
            }
            System.out.println();
        }
    }
    public static void pattern4(int n){
        for(int row = 0; row <n; row++){
            for (int col=n;col>row;col--){
                System.out.print("* ");
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
