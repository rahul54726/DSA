package com.Rahul.Generics.Lamda;

public class Main {
    public static void main(String[] args) {
        Student eng = new Student() {
            @Override
            public void getBio(String name) {
                System.out.println(name + " is Engg Student");
            }
        };
        eng.getBio("Rahul");
        Student law =  name  -> System.out.println(name +" is law Student ");
        law.getBio("Rahul");
    }
}
