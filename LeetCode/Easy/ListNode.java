package com.LeetCode.Easy;

import com.CollectionFrameWorks.Heap.Heaps;

import java.util.Arrays;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    public ListNode() {

    }
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        if (list1.val<list2.val){
            list1.next=list2;
        }
        if(list1.val>=list2.val){
            list2.next=list1;
        }

        return mergeTwoLists(list1.next,list2.next);
    }
    public static void moveZeroes(int[] nums) {
        int lastNonZeroIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[lastNonZeroIndex]=nums[i];
                lastNonZeroIndex++;
            }
        }
        for(int i=lastNonZeroIndex;i<nums.length;i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        int[] nums={0,1,0,3,0,1,0,5,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1==null && list2==null ){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;

        while (list1!=null  && list2!=null){
            if(list1.val<=list2.val){
                current.next=list1;
                list1=list1.next;
            }
            else {
                current.next=list2;
                list2=list2.next;
            }
            current=current.next;

        }
        if (list1!=null ){
            current.next=list1;
        }
        if(list2!=null ){
            current.next=list2;
        }
        return dummy.next;
    }

}
