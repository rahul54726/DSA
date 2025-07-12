package com.CollectionFrameWorks.LinkedList.Doubly;

public class DLL {
    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        this.size = 0;
    }
    public Node find(int val){
        Node node=head;
        while (node!=null){
            if (node.value==val){
                return node;
            }
        }
        return null;
    }
    public void insertFirst(int val){
        Node node =new Node(val);
        node.next=head;
        node.prev=null;
        if(head!=null){
            head.prev=node;
        }
        head=node;
        size++;
    }
    public void insertalast(int val){
        Node node=new Node(val);
        Node last=head;
        node.next=null;
        if(head==null){
            node.prev=null;
            head=node;
        }
        while (last.next!=null){
            last=last.next;
        }
        last.next=node;
        node.prev=last;
    }
    public void insert(int after,int val) throws Exception{
        Node p=find(after);
        if (p==null) {
            throw new Exception("Not Found");
        }
        Node node=new Node(val);
        node.next=p.next;
        p.next=node;
        node.prev=p;
        if(node.next!=null){
            node.next.prev=node;
        }


    }
    public void display(){
        Node node=head;
        Node last=null;
        while (node!=null){
            System.out.print(node.value+"->");
            last=node;
            node=node.next;
        }
        System.out.println("Null");
//        System.out.println("Print reverse ");
//        while (last!=null){
//            System.out.print(last.value+"->");
//            last=last.prev;
//        }
//        System.out.println("Null");
    }


    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }

}
