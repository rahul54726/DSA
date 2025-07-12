package com.CollectionFrameWorks.Trees.Segment;

public class Main {
    public  static void main(String [] args){
        int[] arr ={3,8,7,6,-2,-8,4,9};
        Segment tree=new Segment(arr);
        tree.display();
        System.out.println(tree.query(1,6));
    }
}
