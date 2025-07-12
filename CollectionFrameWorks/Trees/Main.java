package com.CollectionFrameWorks.Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomBinaryTree tree=new CustomBinaryTree();
        tree.populate(new Scanner(System.in));
//        tree.display();
        tree.prettyDisplay();
    }
}
