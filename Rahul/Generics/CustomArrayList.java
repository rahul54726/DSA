package com.Rahul.Generics;

import java.util.Arrays;

public class CustomArrayList {
    private int[] data;
    private static int DEFAULT_SIZE=10;
    private int size=0;

    @Override
    public String toString() {
        return "CustomArrayList = {" +
                "data = " + Arrays.toString(data) + " size = "+data.length+'}';
    }

    public CustomArrayList() {
        this.data=new int[DEFAULT_SIZE];
    }
    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++]=num;
    }

    private void resize() {
        int[] temp=new int[(int)(data.length * 1.5)];
//        copy the current items in new array
            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
    }
    public  int get(int index){
        return data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index,int value){
        data[index]=value;
    }
    private boolean isFull() {
        return size==data.length;
    }
    public int remove(){
        return data[--size];
    }
    public static void main(String[] args) {
        CustomArrayList list=new CustomArrayList();
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(7);
        list.add(6);
        System.out.println(list);
    }
}
