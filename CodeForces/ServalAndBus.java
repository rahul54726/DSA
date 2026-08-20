package com.CodeForces;

import java.util.Scanner;

public class ServalAndBus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int ans = 1;
        int minTime = (int) 1e8;
        for (int i = 1; i < n; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            int nextArrival;
            if (s >= t) nextArrival = s;
            else {
                int passed = (t - s + d - 1) / d;
                nextArrival = s + passed * d;
            }
            if (nextArrival < minTime){
                minTime = nextArrival;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
