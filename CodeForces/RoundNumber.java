package com.CodeForces;

import java.util.Scanner;

public class RoundNumber {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int count=0;
        while (t-->0){
            int number = in.nextInt();

            int temp=number;
            while(temp!=0){
                if(temp%10!=0){
                    count++;
                }
                temp/=10;

            }
            System.out.println(count);

        }

    }

}
