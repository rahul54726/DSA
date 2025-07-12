package com.Multithreading.Demo;

public class Test {
    public static void main(String[] args) {
//        Process process = new Process();
//
//        Thread t1= new Thread(process);//New State
//
//        t1.start();// now it is in runnable state
//        //running
//        for (;;){
//        System.out.println("Testing");
//        }
//        System.out.println(Thread.currentThread().getName());
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());
    }
}
