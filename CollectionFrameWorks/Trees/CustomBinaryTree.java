package com.CollectionFrameWorks.Trees;
import java.util.Scanner;
public class CustomBinaryTree {
    private Node root;
    private int size;
    public CustomBinaryTree(){
        this.size=0;
    }
// insert elements
    public void  populate(Scanner in){
        System.out.println("Enter the Root Node val");
        int value= in.nextInt();
        root=new Node(value);
        populate(in,root);
    }

    private void populate(Scanner in, Node node) {
        System.out.println("Do you want to enter left of "+ node.value);
        boolean left=in.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of this node "+ node.value);
            int value=in.nextInt();
            node.left=new Node(value);
            populate(in,node.left);
        }
        System.out.println("Do you want to enter right of "+ node.value);
        boolean right=in.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of this node "+ node.value);
            int value=in.nextInt();
            node.right=new Node(value);
            populate(in,node.right);
        }
    }

public void display() {
    display(root, "");
}

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }
    public void prettyDisplay(){
        prettyDisplay(root,0);
    }

    private void prettyDisplay(Node node, int level) {
        if(node==null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level!=0) {
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->"+node.value);
        }
        else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);
    }

    private static class Node{
         int value;
        Node left;
         Node right;
        public Node(int val){
            this.value=val;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
