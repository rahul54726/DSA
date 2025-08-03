package com.CollectionFrameWorks.Stack;

import java.util.Arrays;

public class CustomStackImpl<T> {
    protected Object[] data;
    private static final int Default_size=10;
    int ptr =-1;
    public CustomStackImpl(){
        this(Default_size);
    }
    public CustomStackImpl(int size) {
        this.data=new Object[size];
    }
     public T getval(int index){
        return (T) data[index];
     }
    public boolean push(T item) {
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }

        data[++ptr]=item;
        return true;
    }
    public T pop() throws Exception{
        if(isEmpty()){
            throw new Exception("can't pop from an empty Stack");
        }
//        int  removed = data[ptr];
//        ptr--;
        return (T) data[ptr--];
    }
    public T peek () throws  Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }
        return (T) data[ptr];

    }
    public boolean isFull(){
        return ptr == data.length-1; //ptr is at last index
    }
    private  boolean isEmpty(){
        return ptr ==-1;
    }
@Override
    public String toString() {
        return "Stack " + Arrays.toString(data) ;
    }
}
