package com.Multithreading.DeadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLock {
    private final Lock lock = new ReentrantLock(true);
    public void accesResourse(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Acquired the Lock.");
            Thread.sleep(1000);
        }catch (Exception e){
            Thread.currentThread().isInterrupted();
        }
        finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the Lock");
        }
    }

    public static void main(String[] args) {
        FairLock example = new FairLock();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accesResourse();
            }
        };
        Thread t1 = new Thread(task,"Thread 1 ");
        Thread t2 = new Thread(task,"Thread 2 ");
        Thread t3 = new Thread(task,"Thread 3 ");
        t1.start();
        t2.start();
        t3.start();
    }
}
