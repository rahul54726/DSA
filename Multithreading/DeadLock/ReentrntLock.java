package com.Multithreading.DeadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrntLock {
    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try {
            System.out.println(("Outer Method"));
            innerMethod();
        }finally {
            lock.unlock();
        }
    }
    public void innerMethod(){
        lock.lock();
        try {
            System.out.println("Inner Method");
            outerMethod();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrntLock example = new ReentrntLock();
        example.outerMethod();
    }
}
