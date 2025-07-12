package com.CollectionFrameWorks.Trees.Segment;

public class Segment {
    Node root;
    public Segment(int [] arr) {
        //create a tree using this array
        this.root=constructTree(arr,0,arr.length-1);
    }
    private Node constructTree(int[] arr,int start ,int end) {
        if(start==end){
            // at leaf node
            return new Node(arr[start],start,end);
        }
        // create new node with index you are at
        Node node=new Node(start,end);
        int mid=start+(end-start)/2;
        node.left=this.constructTree(arr,start,mid);
        node.right=this.constructTree(arr,mid+1,end);
        node.data = node.left.data + node.right.data;
        return node;
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node) {
        String str="";
        if(node.left!=null){
            str = str + "Interval [" + node.left.endInterval + " - " + node.left.startInterval + "] and Data: " + node.left.data + " => ";
        }
        else {
            str = str+"No left child ";
        }
        // for current node
        str = str + "Interval [" + node.endInterval + " - " + node.startInterval + "] and Data: " + node.data + " <= ";
        if(node.right!=null){
            str = str + "Interval [" + node.right.endInterval + " - " + node.right.startInterval + "] and Data: " + node.right.data;
        }
        else {
            str=str+"No right child ";
        }
        System.out.println(str);
        //        call recursion
        if (node.left != null){
            display(node.left);
        }if (node.right != null){
            display(node.right);
        }
    }
           // query
    public int query(int qsi,int qei){
        return this.query(this.root,qsi,qei);
    }
    private int query(Node node,int qsi,int qei){
        if(node.startInterval >= qsi && node.endInterval <= qei) {
            //node lies inside query
            return node.data;
        }
        else if(node.startInterval > qei || node.endInterval < qsi){
            return 0;
        }
        else {
            return this.query(node.left,qsi,qei)+this.query(node.right,qsi,qei);
        }
    }
            //update
    public void update(int index,int val){
        this.root.data=update(this.root,index,val);
    }
    private int update(Node node,int index,int val){
        if (index>=node.startInterval && index<=node.endInterval){
            if (index==node.startInterval && index==node.endInterval){
                node.data = val;
                return node.data;
            } else {
                int leftAns=update(node.left,index,val);
                int rightAns=update(node.right,index,val);
                node.data=leftAns+rightAns;
                return node.data;
            }
        }
        return node.data;
    }
    private class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        public Node( int endInterval, int startInterval) {
            this.endInterval = endInterval;
            this.startInterval = startInterval;
        }
        public Node( int data,int endInterval, int startInterval) {
            this.data=data;
            this.endInterval = endInterval;
            this.startInterval = startInterval;
        }
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}