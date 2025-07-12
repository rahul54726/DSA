package com.BitManuplation.DSAMaths;

public class Factors {
    static void factorsof(int n){
       int s=1;
        while(s*s<=n){

            if (n%s==0){
                if(n/s==s){
                System.out.print(s+" ");
            }

             else    System.out.print(s+" "+n/s+" ");
            }
            s++;
        }
    }
    public static void main(String[] args) {
        int n=36;
        factorsof(n);

    }
}
