package com.Multithreading.DeadLock;

import javax.xml.transform.Source;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment(){
        writeLock.lock();
        try {
            this.count++;
        }finally {
            writeLock.unlock();
        }
    }
    public int getCount(){
        readLock.lock();
        try {
            return this.count;
        }
        finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteCounter counter = new ReadWriteCounter();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<10;i++){
                    System.out.println(Thread.currentThread().getName() + " Read " + counter.getCount());
                }
            }
        };
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;i<10;i++){
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " Incremented ");
                }
            }
        };
        Thread writeThread = new Thread(writeTask,"writeThread");
        Thread readThread1 = new Thread(readTask,"readThread1");
        Thread readThread2 = new Thread(readTask,"readThread2");
        writeThread.start();
        readThread1.start();
        readThread2.start();
    }
}
