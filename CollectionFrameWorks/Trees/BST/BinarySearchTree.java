package com.CollectionFrameWorks.Trees.BST;
import java.util.ArrayList;
public class BinarySearchTree {
   private Node root;
   public BinarySearchTree(){
   }
   public int height(Node node){
       if(node==null){
           return -1;
       }
       return  node.height;
   }
   private boolean isEmpty(){
       return this.root == null;
   }
   public void display(){
       display(this.root,"Root Node : ");
   }

    private void display(Node node, String details) {
       if(node==null) {
           return;
       }
        System.out.println(details + node.getVal());
       display(node.left,"This is left child of " +node.getVal()+ " : ");
       display(node.right,"This is right child of " +node.getVal()+ " : ");
    }
    public void insert(int val){
       root=insert(val,this.root);
    }
    private Node insert(int val,Node node){
        if (node==null){
            node=new Node(val);
            return node;
        }
        if (val<=node.val){
            node.left = insert(val,node.left);
        }
        else {
            node.right = insert(val,node.right);
        }
        node.height=Math.max(height(node.left), height(node.right))+1;
        return node;
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
           this.insert(num);
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
           this.insert(nums[mid]);
           populateSorted(nums,start,mid);
           populateSorted(nums,mid+1,end);

    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node  node){
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
    private void inOrder(Node  node){
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
    public void delete(int key){
       root=deleteNode(root,key);
    }
    private Node deleteNode(Node root,int key){
       if(root==null) return null;
       if(key<root.val){
           root.left=deleteNode(root.left,key);
       }
       else if(key>root.val){
           root.right=deleteNode(root.right,key);
       }
       else{
           //case1 no child
           if(root.left==null && root.right==null ) return null;
           //case2 one child
           if(root.left==null) return root.right;
           else if(root.right==null ) return root.left;
           //case3 two child
           Node successor=findMin(root.right);
           root.val=successor.val;
           root.right=deleteNode(root.right,successor.val);
       }
       return root;
    }

    private Node findMin(Node node) {
       while (node.left!=null){
           node=node.left;
       }
       return node;
    }

    private static class Node{
        int val;
        int height;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node left,Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }

        public int getVal() {
            return val;
        }
    }

}
