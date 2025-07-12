package com.CollectionFrameWorks.Stack;

public class CustomStackImpl {
    protected int[] data;
    private static final int Default_size=10;
    int ptr =-1;
    public CustomStackImpl(){
        this(Default_size);
    }
    public CustomStackImpl(int size) {
        this.data=new int[size];
    }
     public int getval(int index){
        return data[index];
     }
    public boolean push(int item) {
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }

        data[++ptr]=item;
        return true;
    }
    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("can't pop from an empty Stack");
        }
//        int  removed = data[ptr];
//        ptr--;
        return data[ptr--];
    }
    public int peek () throws  Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }
        return data[ptr];

    }
    public boolean isFull(){
        return ptr == data.length-1; //ptr is at last index
    }
    private  boolean isEmpty(){
        return ptr ==-1;
    }
}
