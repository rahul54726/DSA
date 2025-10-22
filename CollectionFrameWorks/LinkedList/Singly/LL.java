package com.CollectionFrameWorks.LinkedList.Singly;
//import com.LeetCode.medium.ListNode;
//import com.LeetCode.medium.N;
import java.util.*;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size=0;
    }
    public int deleteFirst(){
        int val= head.value;
        head= head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secLast=get(size-2);
        int val= tail.value;
        tail=secLast;
        tail.next=null;
        return val;
    }
    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node prev=get(index-1);
        int val=prev.next.value;
        prev.next=prev.next.next;
        return val;
    }
    public Node find(int value){
        Node node=head;
        for(int i=0;i<size;i++){
            if(node.value == value) {
                return node;
            }
            node=node.next;
        }
        return null;

    }
    public Node get(int index){
        Node node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }
    public void insert(int val,int index){
        if(index==0) {
            insertFirst(val);
            return;
        }
        else if (index==size) {
            insertLast(val);
            return;
        }
        Node temp=head;
        for (int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node =new Node(val,temp.next);
        temp.next=node;
    }
    //insert using recursions
    public void insertRec(int val,int index){
        head = insertRec(val,index,head);
    }
    private Node insertRec(int val,int index,Node node){
        if (index==0){
            Node temp=new Node(val,node);
            size++;
            return temp;
        }
        node.next= insertRec(val ,--index,node.next);
       return node;
    }
    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }
    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.value+ "->");
            temp=temp.next;
        }
        System.out.println("Null");
    }
    private class Node{
       private int value;
       private Node next;
       public Node(int value){
           this.value=value;
       }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    //questions
    public void duplicate(){
        Node node = head;
        while(node.next!=null){
            if(node.value==node.next.value){
                node.next=node.next.next;
                size--;
            }
            else{
                node=node.next;
            }
        }
        tail=node;
        tail.next=null;
    }
    public static Node merge(Node first,Node second){

        LL ans=new LL();
        while (first != null && second != null){
            if(first.value<second.value){
                ans.insertLast(first.value);
                first=first.next;
            }
            else {
                ans.insertLast(second.value);
                second=second.next;
            }
        }
        while (first!=null){
            ans.insertLast(first.value);
            first=first.next;
        }
        while (second!=null){
            ans.insertLast(second.value);
            second=second.next;
        }
        return ans.head;
    }
    static boolean isCyclic(Node head){
        Node fast=head;
        Node slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    static int lengthOfCycle(Node head){
        Node fast=head;
        Node slow=head;

        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                // calculate the Length of the Cycle
                int length=0;
                Node temp=slow;
                do {
                    temp=temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }
    public Node detectCycle(Node head){
        int length=0;
        Node fast=head;
        Node slow=head;
        if(length == 0) return null;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                // calculate the Length of the Cycle
                length=lengthOfCycle(slow);
                break;
            }
        }
        Node first=head;
        Node second=head;
        while(length-->0){
            second=second.next;
//            length--;
        }
        //keep moving both forward and they will meet at Start
        while (first != second){
            first=first.next;
            second=second.next;
        }
        return first;
    }

    public boolean isHappy(int num){
        int slow =num;
        int fast=num;
        do{
            slow=findSqr(slow);
            fast=findSqr(findSqr(fast));
        }while (slow != fast);
        if(slow == 1) return true;
        return false;
    }
    private int findSqr(int num){
        int ans=0;
        while (num>0){
            int rem=num%10;
            ans += rem*rem;
            num/=10;
        }
        return ans;
    }
    //recursive reverse
    public  void reverse(Node node){
        if (node == tail){
            head=tail;
            return;
        }
        reverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }
    //in-place reversal
    public void  reverseList(){
        if(size<2){
            return ;
        }
        Node prev=null;
        Node present=head;
        Node next=present.next;
        while (present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if (next != null){
                next=next.next;
            }
        }
        head=prev;
    }
    public Node reverseBetween(Node head,int left,int right){
        if(left == right) return head;
        // skip the first left-1 nodes
        Node current =head;
        Node prev=null;
        for(int i=0;current != null && i<left-1;i++){
           prev=current;
           current=current.next;
        }
        Node last=prev;
        Node newEnd=current;
        //reverse
        Node next=current.next;
        for(int i=0;current!=null && i<right-left+1;i++){
            current.next=prev;
            prev=current;
            current=next;
            if (next != null){
                next=next.next;
            }
        }
        if (last!=null){
            last.next=prev;
        }else {
            head=prev;
        }
        newEnd=current;
        return head;
    }
    public boolean isPalindrome(Node head) {
        Node mid=middle(head);
        Node headSecond=reverseList(mid);
        Node reverseHead=headSecond;
        //compare both
        while (head!=null && headSecond!=null){
            if (head.value!=headSecond.value){
                break;
            }
            head=head.next;
            headSecond=headSecond.next;
        }
        reverseList(reverseHead);
        if(head==null||headSecond==null){
            return true;
        }
        return false;
    }
    public Node reverseList(Node head){
        if (head==null){
            return head;
        }
        Node prev=null;
        Node present=head;
        Node next=present.next;
        while (present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if (next != null){
                next=next.next;
            }
        }
        return prev;

    }
    public  void reorderList(Node head){
        if (head==null || head.next==null){
            return;
        }
        Node mid = middle(head);
        Node headSecond=reverseList(mid);
        Node heafFirst=head;
        //rearrange
        while (heafFirst!=null && headSecond!=null){
            Node temp=heafFirst.next;
            heafFirst.next=headSecond;
            heafFirst=temp;
            temp=headSecond.next;
            headSecond.next=heafFirst;
            headSecond=temp;

        }
        if (heafFirst!=null){
            heafFirst.next=null;
        }
    }
    public Node reverseKGroup(Node head, int k) {
    if(k==1 || head ==null){
        return head;
    }
        Node current =head;
        Node prev=null;
        while (true){
            Node last=prev;
            Node newEnd=current;
            //reverse
            Node next=current.next;
            for(int i=0;current!=null && i<k;i++){
                current.next=prev;
                prev=current;
                current=next;
                if (next != null){
                    next=next.next;
                }
            }
            if (last!=null){
                last.next=prev;
            }else {
                head=prev;
            }
            newEnd=current;
            if (current==null) break;
            else{
                prev=newEnd;
            }

        }
        return head;
    }
    public Node rotateRight(Node head, int k) {
        if(k==0 || head==null||head.next==null){
            return head;
        }
        Node current =head;
        int length=1;
        while (current.next!=null){
            current=current.next;
            length++;
        }current.next=head;

        k=k%length;
        Node newTail =head;
        int newTailIndex=length-k;
        while (newTailIndex-->1){
            newTail = newTail.next;
//            newTailIndex--;
        }
        Node newHead= newTail.next;
        newTail.next=null;
        return newHead;
    }
    public int length(Node head){
        Node temp=head;
        int length=0;
        while (temp!=null || head.next!=null){
            temp=temp.next;
            length++;
        }
        return length;
    }
    public Node removeNthFromEnd(Node head, int n) {
        int length=length(head);
        if (n>length){
            return head;
        }
        if(length==1 && n==1){
            return null;
        }
        int kthFromLast=length-n+1;
        Node prev=get(kthFromLast-1);
        prev.next=prev.next.next;
        return head;
    }
    public Node swapPairs(Node head) {
        if(head==null || head.next==null) return head;
        Node firstNode=head;
        Node secondNode=head.next;
        firstNode.next=swapPairs(secondNode.next);
        secondNode.next=firstNode;
        return secondNode;

    }
    public Node deleteDuplicates(Node head) {
        if(head==null || head.next==null) return head;
        Node dummy=new Node(0);
        dummy.next=head;
        Node prev=dummy;
        while (head!=null){
            if(head.next==null && head.value==head.next.value){
                while (head.next!=null && head.value==head.next.value){
                    head=head.next;
                }
                prev.next=head.next;
            }
            else {
                prev=prev.next;
            }
            head=head.next;
        }
        return dummy.next;
    }
    public Node partition(Node head, int x) {
        if(head==null){
            return head;
        }
        Node beforeHead=new Node(0);
        Node afterHead=new Node(0);
        Node before =beforeHead;
        Node after=afterHead;
        while(head!=null){
            if(head.value < x){
                before.next=head;
                before=before.next;
            }
            else {
                after.next=head;
                after=after.next;
            }
            head=head.next;
        }
        after.next=null;
        before.next=afterHead.next;
        return beforeHead.next;
    }
    public Node deleteMiddle(Node head) {
        if (head==null || head.next==null){
            return null;
        }
        Node slow=head;
        Node fast=head;
        Node prev=null;
        while (fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null){
            prev.next=slow.next;
        }
        return head;

    }
    public Node middle(Node head){
        Node slow= head;
        Node fast=head;
        while (fast != null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public Node oddEvenList(Node head) {
        if (head == null || head.next == null) {
            return head; // If the list is empty or has one node, return as is.
        }

        Node odd = head; // Start with the first node as odd
        Node even = head.next; // Second node as even
        Node evenHead = even; // Store the head of the even list

        // Traverse the list
        while (even != null && even.next != null) {
            odd.next = even.next; // Link odd nodes together
            odd = odd.next; // Move to the next odd node
            even.next = odd.next; // Link even nodes together
            even = even.next; // Move to the next even node
        }

        odd.next = evenHead; // Attach even list after odd list
        return head;
    }
    public Node removeNodes(Node head) {
        if(head == null) return null;
        Node current=head;
        while (head!=null && head.next!=null){
            if(head.value<head.next.value){
                while (head.next!=null){
                    head=head.next;
                }
            }
            head=head.next;
        }
        return current;
    }
    public Node addTwoNumbers(Node l1, Node l2) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while (l1 != null){
            stack1.push(l1.value);
            l1=l1.next;
        }
        while (l2 != null){
            stack2.push(l2.value);
            l2=l2.next;
        }
        Node head=null;
        int carry=0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int sum=carry;
            if(!stack1.isEmpty()) sum += stack1.pop();
            if(!stack2.isEmpty()) sum += stack2.pop();
            carry = sum /10;
            Node newNode=new Node(sum%10);
            newNode.next=head;
            head=newNode;
        }
        return head;
    }
    public int numComponents(Node head, int[] nums) {
        HashSet<Integer> numSet=new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int components = 0;
        boolean inComponent=false;
        while (head!=null){
            if(numSet.contains(head.value)){
                if(!inComponent){
                    components++;
                    inComponent=true;
                }
            }else {
                inComponent = false;
            }
            head=head.next;
        }
        return components;
    }
    public Node removeElements(Node head, int val) {
        if(head==null) return head;
        Node dummy=new Node(0);
        dummy.next=head;
        Node current=head;
        Node prev=dummy;
        while (current != null){
            if(current.value == val){
                    prev.next=current.next;
            }
            else {
                prev=current;
            }
            current=current.next;

        }
        return dummy.next;
    }
   // https://leetcode.com/problems/split-linked-list-in-parts/?envType=problem-list-v2&envId=linked-list
   public Node[] splitListToParts(Node head, int k) {
        Node[] ans=new Node[k];
        int len=len(head);
        int partzize=len/k;
        int mod=len%k;
        for (int i = 0;i<k;i++){
            Node partHead=head;
            ans[i]=partHead;
            int currentPartSize = partzize + (i<mod ? 1 : 0);
            for (int j=0;j<currentPartSize-1;j++){
                if (head != null){
                    head=head.next;
                }
            }
            if(head != null){
                Node nextPart=head.next;
                head.next=null;
                head=nextPart;
            }
        }
        return ans;
   }
   private int len(Node node){
        int count=0;
        Node temp=node;
        while (temp != null){
            count++;
            temp=temp.next;
        }
        return count;
   }
   //leetcode1290
   public int getDecimalValue(Node head) {
       if(head.value == 0 && head.next ==null) return 0;
        int length = len(head) - 1;
        int result = 0;
        while(length >=0){
            if(head.value == 1){
                result+= Math.pow(2,length);
            }
            head= head.next;
            length--;
        }
        return result;
   }

}
