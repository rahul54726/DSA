package com.CollectionFrameWorks.Trees.BST;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree();
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9,10};

//        tree.insert(20);
//        tree.insert(10);
//        tree.insert(5);
//        tree.insert(15);
//        tree.insert(30);
//        tree.insert(25);
//        tree.insert(35);
//        tree.populate(arr);
        tree.populateSorted(arr);
        tree.display();
        System.out.println(tree.balanced());
        System.out.println("preOrder");
        tree.preOrder();
        System.out.println();
        System.out.println("inOder");
        tree.inOrder();
        System.out.println();
        System.out.println("postOrder");
        tree.postOrder();
    }
}
