package com.CollectionFrameWorks.Trees.RBT;

public class RBT {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    /* ================= NODE ================= */

    private static class Node {
        int val;
        boolean color;
        Node left, right, parent;

        Node(int val) {
            this.val = val;
            this.color = RED; // new node always starts RED
        }
    }

    /* ================= UTIL ================= */

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    private boolean isBlack(Node node) {
        return node == null || node.color == BLACK;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /* ================= DISPLAY ================= */

    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node node, String details) {
        if (node == null) return;

        System.out.println(details + node.val + " (" + (node.color == RED ? "R" : "B") + ")");
        display(node.left, "Left of " + node.val + " : ");
        display(node.right, "Right of " + node.val + " : ");
    }

    /* ================= ROTATIONS ================= */

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node t = y.left;

        y.left = x;
        x.right = t;

        y.parent = x.parent;
        x.parent = y;
        if (t != null) t.parent = x;

        if (y.parent == null)
            root = y;
        else if (y.parent.left == x)
            y.parent.left = y;
        else
            y.parent.right = y;

        return y;
    }

    private Node rightRotate(Node x) {
        Node y = x.left;
        Node t = y.right;

        y.right = x;
        x.left = t;

        y.parent = x.parent;
        x.parent = y;
        if (t != null) t.parent = x;

        if (y.parent == null)
            root = y;
        else if (y.parent.left == x)
            y.parent.left = y;
        else
            y.parent.right = y;

        return y;
    }

    /* ================= INSERT ================= */

    public void insert(int val) {
        root = insert(root, val);
        root.color = BLACK; // rule: root always black
    }

    private Node insert(Node node, int val) {
        if (node == null)
            return new Node(val);

        if (val < node.val) {
            node.left = insert(node.left, val);
            node.left.parent = node;
        } else if (val > node.val) {
            node.right = insert(node.right, val);
            node.right.parent = node;
        } else {
            return node; // duplicates ignored
        }

        return fixViolation(node);
    }

    /* ================= FIX RED-RED ================= */

    private Node fixViolation(Node node) {

        // LEFT RED + LEFT RED (LL)
        if (isRed(node.left) && isRed(node.left.left)) {
            if (isRed(node.right))
                flipColors(node);
            else
                node = rightRotate(node);
        }

        // LEFT RED + RIGHT RED (LR)
        if (isRed(node.left) && isRed(node.left.right)) {
            if (isRed(node.right))
                flipColors(node);
            else {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        }

        // RIGHT RED + RIGHT RED (RR)
        if (isRed(node.right) && isRed(node.right.right)) {
            if (isRed(node.left))
                flipColors(node);
            else
                node = leftRotate(node);
        }

        // RIGHT RED + LEFT RED (RL)
        if (isRed(node.right) && isRed(node.right.left)) {
            if (isRed(node.left))
                flipColors(node);
            else {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }

        return node;
    }

    /* ================= COLOR FLIP ================= */

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /* ================= TRAVERSALS ================= */

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.val + "(" + (node.color ? "R" : "B") + ") ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + "(" + (node.color ? "R" : "B") + ") ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "(" + (node.color ? "R" : "B") + ") ");
    }

    /* ================= TEST ================= */

    public static void main(String[] args) {
        RBT tree = new RBT();

        int[] arr = {10, 20, 30, 15, 25, 5, 1};

        for (int x : arr)
            tree.insert(x);

        tree.display();

        System.out.print("InOrder   : ");
        tree.inOrder();

        System.out.print("PreOrder  : ");
        tree.preOrder();
    }
}
