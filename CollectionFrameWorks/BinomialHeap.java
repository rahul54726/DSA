package com.CollectionFrameWorks;

public class BinomialHeap {
    private Node head;
    public BinomialHeap(){
        this.head = null;
    }
    private void linkTrees(Node y,Node z){
        y.parent = z;
        y.sibling = z.child;
        z.child = y;
        z.degree++;
    }
}
class Node {
    int key, degree;
    Node parent, child, sibling;

    public Node(int key) {
        this.key = key;
        this.degree = 0;
        this.parent = null;
        this.child = null;
        this.sibling = null;
    }
}
