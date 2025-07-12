package com.CollectionFrameWorks.LinkedList.Doubly;

public class Main {
    public static void main(String[] args) throws Exception {
        DLL list =new DLL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.display();
//        list.insertalast(45);
        list.display();
        list.insert(5,0);
        list.display();
    }
}
