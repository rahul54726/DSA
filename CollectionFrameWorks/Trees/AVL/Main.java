package com.CollectionFrameWorks.Trees.AVL;

public class Main {
    public static void main(String[] args) {
        AVL tree=new AVL();
        tree.insert(15);
        tree.insert(8);
        tree.insert(1);
        tree.insert(16);
        tree.insert(4);
//        tree.insert(12);
//        tree.insert(20);
//        tree.insert(17);
//        tree.insert(10);
//        tree.insert(18);
//        tree.insert(7);
        tree.display();

    }
}
