package com.DSAMaths;
import  java.util.*;

import java.util.ArrayList;
import java.util.Arrays;

public class isPrime {
    static boolean isprime(int n){
        //  for complexity O(N)
        if (n<=1) return false;
//        complexity is O(N)
//        for(int i=2;i<n;i++){
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        for complexity O(sqrt(N))
        int c=2;
        while (c * c <= n){
            if(n % c==0) return false;
            c++;
        }
        return true;
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
//        System.out.println(sieve(10,19,primes));
//        System.out.println(countPrimes(500000));
        System.out.println(closestPrimes(10,19)[0] + " hell" +
                +closestPrimes(10,19)[1]);

    }
    public static int countPrimes(int n){
        if(n<=2) return 0;
        boolean[] primes = new boolean[n];
        for (int i=2;i<n;i++){
            primes[i]=true;
        }
        for (int i=2;i*i<=n;i++){
            if (primes[i]){
                for (int j=2*i;j<n;j+=i){
                    primes[j]=false;
                }
            }
        }
        int count=0;
        for (int i= 2;i < n;i++){
            if(primes[i]){
                count++;
            }
        }
        return count;
    }
    public static int[] closestPrimes(int left, int right) {
//        int lmt=right-left;
        boolean[] isprime=sieve(right);

        List<Integer> primes = new ArrayList<>();
        for(int i= Math.max(2,left);i<=right;i++){
            if(isprime[i]) primes.add(i);
        }
        int[] result={-1,-1};
        int minDiff=Integer.MAX_VALUE;

        for(int i=1;i<primes.size();i++){
            int dif=primes.get(i)-primes.get(i-1);
            if(dif<minDiff){
                dif=minDiff;
                result[0]=primes.get(i-1);
                result[1]=primes.get(i);
            }
            }


        return result;
    }
    static boolean[] sieve(int n){
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        for (int i=2;i*i<=n;i++){
            if (primes[i]){
                for (int j=i*i;j<=n;j+=i){
                    primes[j]=false;
                }
            }
        }
        ArrayList list=new ArrayList<>();
        for (int i=2;i<=n;i++){
            if(!primes[i]){
                list.add(i);
            }
        }
        return primes;
    }

}
