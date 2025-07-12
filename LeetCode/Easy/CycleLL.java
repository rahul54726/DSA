package com.LeetCode.Easy;

public class CycleLL {
   // https://leetcode.com/problems/linked-list-cycle/
    // Amazon And Microsoft
   public boolean hasCycle(ListNode head) {
       ListNode fast=head;
       ListNode slow=head;
       while(fast!=null && fast.next!=null){
           fast=fast.next.next;
           slow=slow.next;
           if(fast == slow ){
               return true;
           }
       }
       return false;
   }
   // find length of cycle
   public int lengthofCycle(ListNode head) {
       ListNode fast=head;
       ListNode slow=head;
       while(fast!=null && fast.next!=null){
           fast=fast.next.next;
           slow=slow.next;
           if(fast == slow ){
               //calculate the length
               int len=0;
               do {
                   slow=slow.next;
                   len++;
               }while (slow!=fast);

               return len;
           }
       }
       return 0;
   }
    class ListNode{
       int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
   }
   public boolean isHappy(int n){
       int slow=n;
       int fast=n;
       do {
           slow=findSqr(slow);
           fast=findSqr(findSqr(fast));
       }while (fast!=slow);
       if(slow==1){
           return true;
       }
       return false;
   }
   private int findSqr(int number){
       int ans=0;
       while(number>0){
           int rem = number%10;
           ans += rem * rem;
           number /= 10;
       }
       return ans;
   }
}
