package com.CollectionFrameWorks.Stack;

public class DynamicStack<T> extends CustomStackImpl<T>{
    public DynamicStack() {
        super(); //it will call CustomStack
    }


    public boolean push(T item) {
//        this takes care of it being full
        if(this.isFull()){
//            double the array size
            Object[] temp= new Object[2*data.length];
//            copy all elements in temp
            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
        }
//        insert item;
//        at this time we know that array is not full
        return super.push(item);
    }

    public DynamicStack(int size) {
        super(size); //it will call CustomStack(int size)
    }
}
