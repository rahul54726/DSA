package com.CollectionFrameWorks.Queues;

public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;
    int first=0;
    int end=0;
    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size){
        this.data=new int[size];
    }
    public boolean insert(int item) {
        if(isfull()){
            return false;
        }
        data[end++]=item;
        return true;
    }
    public int remove() throws  Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removed=data[0];
//      shift the items to left
        for(int i=1;i<end;i++){
            data[i-1]=data[i];
        }
        end--;
        return removed;
    }
    public int removeCircular() throws  Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removed=data[first];
            first++;
        return removed;
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return data[0];
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
