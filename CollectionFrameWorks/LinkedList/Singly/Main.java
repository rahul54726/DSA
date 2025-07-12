package com.CollectionFrameWorks.LinkedList.Singly;

public class Main {
    public static void main(String[] args) {
        LL list=new LL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(5);
        list.insertFirst(5);
        list.insertFirst(5);
        list.insertFirst(5);

//        list.insertLast(45);
//        list.display();
//        list.insert(100,3);
//        list.display();
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        list.delete(2);
//        list.display();
//        System.out.println(list.find(2));
        list.insertRec(99,2);
        list.display();
        list.duplicate();
        list.display();
        LL first=new LL();
        LL second=new LL();

        first.insertLast(1);
        first.insertLast(1);
        first.insertLast(2);
        first.insertLast(3);
        first.insertLast(8);
        second.insertLast(4);
        second.insertLast(5);
        second.insertLast(6);
        second.insertLast(9);
        first.display();
        second.display();







    }
}
