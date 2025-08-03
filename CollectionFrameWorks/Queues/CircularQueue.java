package com.CollectionFrameWorks.Queues;

public class CircularQueue<T> {
    protected Object[] data;
    private static final int DEFAULT_SIZE=10;
    protected int front =0;
    protected int end=0;
    private int size=0;
    public CircularQueue(){
        this(DEFAULT_SIZE);
    }
    public CircularQueue(int size){
        this.data=new Object[size];
    }
    private boolean isfull(){
        return size==data.length-1;
    }
    private boolean isEmpty(){
        return size==0;
    }
    public boolean insert(T item){
        if(isfull()){
            return false;
        }
        data[end++]=item;
        end=end%data.length;
        size++;
        return true;
    }
    public T remove() throws  Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        T removed= (T) data[front++];
        front=front%data.length;
        size--;
        return removed;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Empty");
        }
        int i=front;
        do {
            System.out.print(data[i++]+"<-");
            i%=data.length;
        }while (i!=end);
        System.out.print("end");
    }

    public static void main(String[] args) throws  Exception{
        CircularQueue cqueue=new CircularQueue();
        cqueue.insert(10);
        cqueue.insert(20);
        cqueue.insert(30);
        cqueue.insert(40);
        cqueue.insert(50);
        cqueue.display();
        System.out.println(cqueue.remove());
        System.out.println();
        cqueue.display();
        System.out.println();
        cqueue.insert(1000);
        cqueue.remove();
        System.out.println();
        cqueue.display();





    }
}
