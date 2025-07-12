package com.CollectionFrameWorks.LinkedLists.Circular;

public class Main {
    public static void main(String[] args) {
        CLL list=new CLL();
        list.insert(8);
        list.insert(9);
        list.insert(2);
        list.insert(7);
        list.display();
        list.delete(2);
        list.display();
    }
}
