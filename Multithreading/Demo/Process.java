package com.Multithreading.Demo;

public class Process implements Runnable{
    @Override
    public void run() {
        for (; ;){
            System.out.println("process");
        }
    }
}
