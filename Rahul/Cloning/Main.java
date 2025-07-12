package com.Rahul.Cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        Human rahul=new Human("Rahul",22);
//        Human twin=new Human(rahul);
        System.out.println(Arrays.toString(rahul.arr));
        Human twin=(Human) rahul.clone();
        System.out.println(twin.age +"  "+ twin.name);
        System.out.println(Arrays.toString(twin.arr));
        twin.arr[0]=100;
        System.out.println(Arrays.toString(twin.arr));
    }
}
