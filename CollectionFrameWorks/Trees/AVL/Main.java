package com.CollectionFrameWorks.Trees.AVL;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AVL tree=new AVL();
        int[] arr=new int[1000];
        for (int i=1;i<=1024;i++){
            tree.insert(i);
        }
        tree.display();

    }
}
