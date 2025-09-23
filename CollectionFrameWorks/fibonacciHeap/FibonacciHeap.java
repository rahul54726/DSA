package com.CollectionFrameWorks.fibonacciHeap;

import java.util.ArrayList;
import java.util.List;

class FibNode {
    int key, degree;
    FibNode parent, child, left, right;
    boolean mark;

    FibNode(int key) {
        this.key = key;
        this.degree = 0;
        this.parent = null;
        this.child = null;
        this.left = this;
        this.right = this; // circular doubly-linked
        this.mark = false;
    }
}

public class FibonacciHeap {
    private FibNode min;
    private int n;

    public FibonacciHeap() {
        min = null;
        n = 0;
    }

    // Insert a new key
    public FibNode insert(int key) {
        FibNode node = new FibNode(key);
        if (min == null) {
            min = node;
        } else {
            // insert into root list
            node.right = min.right;
            node.left = min;
            min.right.left = node;
            min.right = node;
            if (key < min.key) {
                min = node;
            }
        }
        n++;
        return node;
    }

    // Return min key
    public int findMin() {
        if (min == null) throw new IllegalStateException("Heap is empty");
        return min.key;
    }

    // Union two heaps
    public static FibonacciHeap union(FibonacciHeap h1, FibonacciHeap h2) {
        FibonacciHeap h = new FibonacciHeap();
        h.min = h1.min;

        if (h.min != null && h2.min != null) {
            // concatenate root lists
            FibNode h1Right = h1.min.right;
            FibNode h2Left = h2.min.left;

            h1.min.right = h2.min;
            h2.min.left = h1.min;
            h1Right.left = h2Left;
            h2Left.right = h1Right;

            if (h2.min.key < h1.min.key) {
                h.min = h2.min;
            }
        } else if (h2.min != null) {
            h.min = h2.min;
        }

        h.n = h1.n + h2.n;
        return h;
    }

    // Extract the minimum node
    public int extractMin() {
        FibNode z = min;
        if (z != null) {
            // add z’s children to root list
            if (z.child != null) {
                FibNode x = z.child;
                do {
                    FibNode next = x.right;
                    // add x to root list
                    x.left.right = x.right;
                    x.right.left = x.left;

                    x.left = min;
                    x.right = min.right;
                    min.right.left = x;
                    min.right = x;

                    x.parent = null;
                    x = next;
                } while (x != z.child);
            }

            // remove z from root list
            z.left.right = z.right;
            z.right.left = z.left;

            if (z == z.right) {
                min = null;
            } else {
                min = z.right;
                consolidate();
            }
            n--;
            return z.key;
        }
        throw new IllegalStateException("Heap is empty");
    }

    private void consolidate() {
        int arraySize = ((int) Math.floor(Math.log(n) / Math.log(2))) + 1;
        List<FibNode> A = new ArrayList<>(arraySize);
        for (int i = 0; i < arraySize; i++) A.add(null);

        List<FibNode> rootList = new ArrayList<>();
        FibNode x = min;
        if (x != null) {
            do {
                rootList.add(x);
                x = x.right;
            } while (x != min);
        }

        for (FibNode w : rootList) {
            x = w;
            int d = x.degree;
            while (A.get(d) != null) {
                FibNode y = A.get(d);
                if (x.key > y.key) {
                    FibNode temp = x;
                    x = y;
                    y = temp;
                }
                link(y, x);
                A.set(d, null);
                d++;
            }
            if (d >= A.size()) {
                for (int i = A.size(); i <= d; i++) A.add(null);
            }
            A.set(d, x);
        }

        min = null;
        for (FibNode a : A) {
            if (a != null) {
                if (min == null) {
                    min = a;
                    a.left = a.right = a;
                } else {
                    a.left = min;
                    a.right = min.right;
                    min.right.left = a;
                    min.right = a;
                    if (a.key < min.key) {
                        min = a;
                    }
                }
            }
        }
    }

    private void link(FibNode y, FibNode x) {
        // remove y from root list
        y.left.right = y.right;
        y.right.left = y.left;
        // make y a child of x
        y.parent = x;
        if (x.child == null) {
            y.left = y.right = y;
            x.child = y;
        } else {
            y.left = x.child;
            y.right = x.child.right;
            x.child.right.left = y;
            x.child.right = y;
        }
        x.degree++;
        y.mark = false;
    }

    // Decrease key
    public void decreaseKey(FibNode x, int k) {
        if (k > x.key) throw new IllegalArgumentException("new key is greater");
        x.key = k;
        FibNode y = x.parent;
        if (y != null && x.key < y.key) {
            cut(x, y);
            cascadingCut(y);
        }
        if (x.key < min.key) min = x;
    }

    private void cut(FibNode x, FibNode y) {
        // remove x from child list of y
        if (x.right == x) {
            y.child = null;
        } else {
            x.right.left = x.left;
            x.left.right = x.right;
            if (y.child == x) y.child = x.right;
        }
        y.degree--;

        // add x to root list
        x.left = min;
        x.right = min.right;
        min.right.left = x;
        min.right = x;

        x.parent = null;
        x.mark = false;
    }

    private void cascadingCut(FibNode y) {
        FibNode z = y.parent;
        if (z != null) {
            if (!y.mark) {
                y.mark = true;
            } else {
                cut(y, z);
                cascadingCut(z);
            }
        }
    }

    // Delete node
    public void delete(FibNode x) {
        decreaseKey(x, Integer.MIN_VALUE);
        extractMin();
    }

    public boolean isEmpty() {
        return min == null;
    }

    public int size() {
        return n;
    }
}

