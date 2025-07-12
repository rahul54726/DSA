package com.BitManuplation.DSAMaths;

import java.util.ArrayList;

public class isPrime {
    static boolean isprime(int n){

        if (n<=1) return false;
//        complexity is O(N)
//        for(int i=2;i<n;i++){
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        for complexity O(sqrt(N))
        int c=2;
        while (c*c<=n){
            if(n%c==0) return false;
            c++;
        }
        return true;
    }
    static void sieve(int n,boolean[] primes){
        for (int i=2;i*i<=n;i++){
            if (!primes[i]){
                for (int j=2*i;j<=n;j+=i){
                    primes[j]=true;
                }
            }
        }
        for (int i=2;i<=n;i++){
            if(!primes[i]){
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        int n=40;
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=0;i<=n;i++){
            if(isprime(i)){
                list.add(i);
            }
        }
        System.out.println(list);
        boolean[] primes= new boolean[n+1];
        sieve(n,primes);

    }
}
