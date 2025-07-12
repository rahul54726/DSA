package com.CollectionFrameWorks.Stack;

public class DynamicStack extends CustomStackImpl{
    public DynamicStack() {
        super(); //it will call CustomStack
    }

    @Override
    public boolean push(int item) {
//        this takes care of it being full
        if(this.isFull()){
//            double the array size
            int[] temp= new int[2*data.length];
//            copy all elememts in temp
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
