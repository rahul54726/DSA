package com;

public class Pair<T> {
    private T first;
    private T second;
    public Pair(T f , T s){
        this.first = f;
        this.second = s;
    }
    public T getFirst(){
        return first;
    }
    public void setFirst(T f){
        this.first = f;
    }
    public T getSecond(){
        return this.second;
    }
    public void setSecond(T s){
        this.second = s;
    }
}
