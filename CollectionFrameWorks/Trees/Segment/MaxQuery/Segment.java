package com.CollectionFrameWorks.Trees.Segment.MaxQuery;

public class Segment {
    private Node root;

    public Segment(int[] arr) {
        // Create a tree using this array
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            // At leaf node
            return new Node(arr[start], start, end);
        }
        // Create a new node for the current interval
        int mid = start + (end - start) / 2;
        Node node = new Node(start, end);
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);
        node.data =Math.max(node.left.data,node.right.data);
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str += "Interval [" + node.left.startInterval + " - " + node.left.endInterval + "] and Data: " + node.left.data + " => ";
        } else {
            str += "No left child ";
        }
        // Current node
        str += "Interval [" + node.startInterval + " - " + node.endInterval + "] and Data: " + node.data + " <= ";
        if (node.right != null) {
            str += "Interval [" + node.right.startInterval + " - " + node.right.endInterval + "] and Data: " + node.right.data;
        } else {
            str += "No right child ";
        }
        System.out.println(str);
        // Recursive calls
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    public int query(int qsi, int qei) {
        return query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        // Node's range is completely inside the query range
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        }
        // Node's range is completely outside the query range
        if (node.startInterval > qei || node.endInterval < qsi) {
            return Integer.MIN_VALUE; // Neutral value for multiplication
        }
        // Partial overlap: Query left and right children
        return Math.max(this.query(node.left, qsi, qei) , this.query(node.right, qsi, qei));
    }

    private class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

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
        int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
        Segment tree = new Segment(arr);
        tree.display(); // Display the segment tree
        System.out.println("Query result (1, 4): " + tree.query(1, 4)); // Query range [1, 4]
        System.out.println("Query result (0, 7): " + tree.query(0, 7)); // Query entire range
        System.out.println("Query result (3, 5): " + tree.query(3, 5)); // Query range [3, 5]
    }
}
