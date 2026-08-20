package com.CodeForces;
import java.util.*;
public class Snake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0){
            long n = sc.nextLong();
            while ((n&1) == 0){
                n>>=1;
            }
            if (n > 1) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
