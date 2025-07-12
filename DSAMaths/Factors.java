package com.DSAMaths;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Factors {
    static ArrayList factorsof(int n){
       int s=1;
       ArrayList list=new ArrayList<>();
        while(s*s<=n){

            if (n%s==0){
                if(n/s==s){
                list.add(s);
            }

             else {
                    list.add(s);
                    list.add(n/s);
                }

            }
            s++;
        }

        return list;
    }
    public static void main(String[] args) {
        int n=36;
        Collections.sort(factorsof(n),Comparator.reverseOrder());
        System.out.println(factorsof(n));

    }
}
