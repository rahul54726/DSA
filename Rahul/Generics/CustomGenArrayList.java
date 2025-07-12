package com.Rahul.Generics;
import java.util.Arrays;
//wild cards in java means generics with more restricted type providing like
// in generics we provide type but in wildcards we extend the given castings like
//public class CustomGenArrayList<T extends Number> here T will be number or its subtype
public class CustomGenArrayList<T extends Number>{
    private Object[] data;
    private int DEFAULT_SIZE=10;
    private int size=0;
    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
    public CustomGenArrayList() {
        this.data=new Object[DEFAULT_SIZE];
    }
    public void add(T val){
        if(isFull()){
            resize();
        }
        data[size++]=val;
    }

    private void resize() {
        Object[] temp=new Object[2*data.length];
//        copy the current items in new array
            for(int i=0;i<data.length;i++)     {
                temp[i]=data[i];
            }
            data=temp;
    }

    private boolean isFull() {
        return size==data.length;
    }
    public T remove(){
        return (T) data[--size];
    }
    public  T get(int index){
        return  (T) data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index, T value){
        data[index]= value;
    }

    public static void main(String[] args) {
        CustomGenArrayList<Integer> list=new CustomGenArrayList<>();
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(7);
        list.add(6);
        System.out.println(list);
        CustomGenArrayList<Integer> l=new CustomGenArrayList<>();
        l.add(5);
        System.out.println(l);

    }
}
