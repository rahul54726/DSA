package com.Rahul.Singleton;

//it's just class of which you can create only one object
public class Singleton {
    private Singleton(){

    }
    private static Singleton instance;
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
