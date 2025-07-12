package com.Multithreading.DeadLock;
class SharedResourse{
    private int data;
    private boolean hasData;

    public synchronized void produce(int val){
        while (hasData){
            try{
                wait();
            }catch (InterruptedException e ){
                Thread.currentThread().interrupt();
            }
        }
        data = val;
        hasData = true;
        System.out.println("Produces : " + val);
        notify();
    }
    public synchronized int consume(){
        while (!hasData){
            try {
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed : " + data);
        notify();
        return data;
    }
}
class Producer implements Runnable{
    private SharedResourse resourse;
    public Producer(SharedResourse resourse){
        this.resourse =  resourse;
    }
    @Override
    public void run(){
        for(int i = 0 ;i < 10; i++){
            resourse.produce(i);

        }
    }
}
class Consumer implements Runnable{
    private SharedResourse resourse;
    public Consumer(SharedResourse resourse){
        this.resourse = resourse;
    }
    @Override
    public void run(){
        for(int i = 0;i<10;i++){
           int val = resourse.consume();
        }
    }
}
public class ThreadComm {
    public static void main(String[] args) {
        SharedResourse resourse = new SharedResourse();
        Thread producerThread = new Thread(new Producer(resourse));
        Thread consumerThread = new Thread(new Consumer(resourse));

        producerThread.start();
        consumerThread.start();
    }
}