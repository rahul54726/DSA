package com.CollectionFrameWorks.SkipList;

public class Main {
    public static void main(String[] args) {
        SkipList sl = new SkipList();
        sl.insert(3);
        sl.insert(6);
        sl.insert(7);
        sl.insert(9);
        sl.insert(12);
        sl.insert(19);
        sl.insert(17);
        sl.insert(26);
        sl.insert(21);
        sl.insert(25);
        sl.display();
        System.out.println("Search 19 " + sl.search(19));
        sl.delete(19);
        sl.display();
    }
}
