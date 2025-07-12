package com.CollectionFrameWorks.Trees.AVL;

public class AVL {
    private Node root;
    public AVL(){
    }
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return  node.height;
    }
    boolean isEmpty(){
        return root == null;
    }
    public void display(){
        display(root,"Root Node : ");
    }
    private void display(Node node, String details) {
        if(node==null) {
            return;
        }
        System.out.println(details + node.getVal());
        display(node.left,"This is left child of " + node.getVal()+ " : ");
        display(node.right,"This is right child of " + node.getVal()+ " : ");
    }
    public void insert(int val){
        root=insert(val,root);
    }
    private Node insert(int val, Node node){
        if (node==null){
            node=new Node(val);
            return node;
        }
        if (val<=node.val){
            node.left=insert(val,node.left);
        }
        else {
            node.right=insert(val,node.right);
        }
        node.height=Math.max(height(node.left), height(node.right))+1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        if(height(node.left)-height(node.right)>1){
            //left heavy
            //left left case
            if(height(node.left.left)-height(node.left.right) > 0){
                return rightRotate(node);
            }
            //left right case
            if(height(node.left.left)-height(node.left.right) < 0){
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        //right heavy
        if(height(node.left)-height(node.right) < -1){
            //right heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                return leftRotate(node);
            }
            //right left case
            if(height(node.right.left) - height(node.right.right) > 0){
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p) {
        Node c=p.left;
        Node t=c.right;
        c.right=p;
        p.left=t;
        p.height=Math.max(height(p.left),height(p.right) + 1);
        c.height=Math.max(height(c.left),height(c.right) + 1);

        return c;
    }
    private Node leftRotate(Node p) {
        Node c=p.right;
        Node t=c.left;

        c.left=p;
        p.right=t;

        p.height=Math.max(height(p.left),height(p.right) + 1);
        c.height=Math.max(height(c.left),height(c.right) + 1);
        return c;
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node) {
        if (node==null){
            return true;
        }
        return  Math.abs(height(node.left)- height(node.right)) <= 1  && balanced(node.left) && balanced(node.right);
    }
    public void populate(int[] nums){
        for(int num:nums){
            insert(num);
        }
    }
    public void populateSorted(int[] nums){
        populateSorted(nums,0,nums.length);
    }
    private void populateSorted(int[] nums,int start,int end){
        if (start>=end){
            return;
        }

        int mid=(start+end)/2;
        insert(nums[mid]);
        populateSorted(nums,start,mid);
        populateSorted(nums,mid+1,end);

    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+ " ");
    }
    private static class Node{
        int val;
        int height;
        Node left;
       Node right;
        public Node(int val){
            this.val=val;
        }
        public Node(int val, Node left, Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }

        public int getVal() {
            return val;
        }
    }
}

