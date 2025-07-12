package com.CollectionFrameWorks.Trees.Segment;

public class Main {
    public  static void main(String [] args){
        int[] arr = {1,2,3,4,5};
//        int[] nums=new int[10000];
//        for(int i=0;i<nums.length;i++){
//            nums[i]=i;
//        }
        Segment tree=new Segment(arr);
        tree.display();
        System.out.println("Query result (1, 1): " + tree.query(2,3 )); // Sum range [1, 4]

    }
}
