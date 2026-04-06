package com.CollectionFrameWorks.Trees.AVL;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AVL tree=new AVL();
        int[] arr=new int[1000];
        for (int i=0;i<1000;i++){
            tree.insert(i);
        }
        tree.display();

    }
}
