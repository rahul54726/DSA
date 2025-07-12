package com.CollectionFrameWorks.Trees.Segment.MinQuery;

public class Segment {
    private Node root;

    // Constructor to build the segment tree
    public Segment(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    // Method to construct the segment tree
    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            // Leaf node
            return new Node(arr[start], start, end);
        }
        int mid = start + (end - start) / 2;
        Node node = new Node(start, end);
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);
        node.data=Math.min(node.left.data,node.right.data);
        return node;
    }

    // Query the sum of a given range
    public int query(int qsi, int qei) {
        return query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if (node == null) return 0; // Neutral value for sum

        // Total overlap: Node's range is completely within the query range
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        }

        // No overlap: Node's range is completely outside the query range
        if (node.endInterval < qsi || node.startInterval > qei) {
            return Integer.MAX_VALUE; // Neutral value for sum
        }

        // Partial overlap: Query left and right children
        int leftResult = this.query(node.left, qsi, qei);
        int rightResult = this.query(node.right, qsi, qei);
        return Math.min(leftResult , rightResult);
    }

    // Display the segment tree structure
    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        if (node == null) return;
        String str = "";

        if (node.left != null) {
            str += "Interval [" + node.left.startInterval + " - " + node.left.endInterval + "] and Data: " + node.left.data + " => ";
        } else {
            str += "No left child ";
        }

        str += "Interval [" + node.startInterval + " - " + node.endInterval + "] and Data: " + node.data + " <= ";

        if (node.right != null) {
            str += "Interval [" + node.right.startInterval + " - " + node.right.endInterval + "] and Data: " + node.right.data;
        } else {
            str += "No right child ";
        }

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // Node class for the segment tree
    private class Node {
        int data; // Sum of the interval
        int startInterval; // Start of the interval
        int endInterval; // End of the interval
        Node left; // Left child
        Node right; // Right child

        public Node(int data, int startInterval, int endInterval) {
            this.data = data;
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,-5};
        Segment tree=new Segment(arr);
        tree.display();
        System.out.println(tree.query(1,5));
    }

}
