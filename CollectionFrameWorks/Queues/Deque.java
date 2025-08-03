package com.CollectionFrameWorks.Queues;

public class Deque<T>  {
    protected Object[] que;
    private static final int DefaultSize=10;
    private int front=0;
    private int end=0;
    private int size=0;
    public Deque(){
        this(DefaultSize);
    }
    public Deque(int size) {
        this.que = new Object[size];
    }
    private boolean isFull(){
        return size==que.length-1;
    }
    private boolean isEmpty(){
        return size==0;
    }
    public boolean addLast(T item){
        if(isFull()){
            System.out.println("Deque is Full");
            return false;
        }
        que[end++]=item;
        size++;
        return true;
    }
    public boolean addFirst(T item){
        if(isFull()){
            System.out.println("Deque is Full");
            return false;
        }
        for(int i=que.length-1;i>0;i--){
            que[i-1]=que[i];
        }
        que[front]=item;

        end++;

        return true;
    }
    public void display() throws Exception{
        if(isEmpty()){
            throw new Exception("is Empty");
        }
        for(int i=0;i<size;i++){
            System.out.print(que[i]+"<->");
        }
        System.out.println("End");
    }

    public static void main(String[] args) throws Exception {
        Deque q=new Deque(5);
        q.addLast(10);
        q.addLast(20);
        q.addLast(30);
        q.addLast(40);
        q.addFirst(100);
        q.display();
    }
}
