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
            throw new java.util.EmptyStackException();
        }
        T  removed = (T)data[ptr];
        data[ptr] = null;
        ptr--;
        return removed;
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
        return "Stack " + Arrays.toString(Arrays.copyOfRange(data, 0, ptr + 1));
    }
}
