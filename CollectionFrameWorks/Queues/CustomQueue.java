package com.CollectionFrameWorks.Queues;

public class CustomQueue<T> {
    protected Object[] data;
    private static final int DEFAULT_SIZE=10;
    int first=0;
    int end=0;
    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size){
        this.data=new Object[size];
    }
    public boolean insert(T item) {
        if(isfull()){
            return false;
        }
        data[end++]=item;
        return true;
    }
    public T remove() throws  Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        T removed= (T) data[0];
//      shift the items to left
        for(int i=1;i<end;i++){
            data[i-1]=data[i];
        }
        end--;
        return removed;
    }
    public T removeCircular() throws  Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        T removed= (T) data[first];
            first++;
        return removed;
    }
    public T front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return (T) data[0];
    }
    public void display(){
        for(int i=0;i<end;i++){
            System.out.print(data[i] +"<-");
        }
        System.out.print("END");
    }
    public boolean isfull(){
        return end==data.length-1;
    }
    public boolean isEmpty(){
        return end==0;
    }
}
