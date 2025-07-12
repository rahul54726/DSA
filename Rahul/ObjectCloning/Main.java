package com.Rahul.ObjectCloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human rahul=new Human(22,"Rahul");
//        Human twin=new Human(rahul);
//        System.out.println(twin.name);
        Human twin=(Human) rahul.clone();
        System.out.println(twin.age + " "+ twin.name);
        System.out.println(rahul.name);
        System.out.println(Arrays.toString(twin.arr));

    }
}
