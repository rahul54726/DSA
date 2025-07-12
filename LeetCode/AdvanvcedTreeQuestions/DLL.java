package com.LeetCode.AdvanvcedTreeQuestions;

public class DLL {
    LLNode head;
    LLNode tail;

    public Node convert(Node root){
        if(root == null) return null;
        help(root);
        return root;
    }
    private void help(Node node){
        if (node == null) return;
        help(node.left);
        LLNode newNode=new LLNode(node.val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        newNode = tail;
        help(node.right);

    }


    private class LLNode {
        int val;
        LLNode next;
        LLNode prev;

        public LLNode(int val) {
            this.val = val;
        }


    }
    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}

