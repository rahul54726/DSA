package com.CollectionFrameWorks.SkipList;

import java.util.Random;

public class SkipList {
    private static final int MAX_LEVEL = 16;
    private final double P = 0.5;
    private int level;
    private Node header;
    private Random random;

    public SkipList() {
        this.level = 0;
        this.header = new Node(-1, MAX_LEVEL);
        this.random = new Random();

    }
    private int randomLevel(){
        int lvl = 0;
        while (random.nextDouble() < this.P && lvl < MAX_LEVEL){
            lvl++;
        }
        return lvl;
    }
    public boolean search(int key){
        Node current = header;
        for (int i = level;i>=0;i--){
            while (current.forward[i] != null && current.forward[i].key <key){
                current = current.forward[i];
            }
        }
        current = current.forward[0];
        return current !=null && current.key == key;
    }
    public void insert(int key) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node current = header;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key < key) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];

        if (current == null || current.key != key) { // only insert if not exists
            int newLevel = randomLevel();
            if (newLevel > level) {
                for (int i = level + 1; i <= newLevel; i++) {
                    update[i] = header;
                }
                level = newLevel;
            }

            Node newNode = new Node(key, newLevel);
            for (int i = 0; i <= newLevel; i++) {
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }
    }
    public void delete(int key) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node current = header;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key < key) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];

        if (current != null && current.key == key) {
            for (int i = 0; i <= level; i++) {
                if (update[i].forward[i] != current) break;
                update[i].forward[i] = current.forward[i];
            }
            while (level > 0 && header.forward[level] == null) {
                level--;
            }
        }
    }
    public void display() {
        System.out.println("Skip List:");
        for (int i = level; i >= 0; i--) {
            Node current = header.forward[i];
            System.out.print("Level " + i + ": ");
            while (current != null) {
                System.out.print(current.key + " ");
                current = current.forward[i];
            }
            System.out.println();
        }
    }
}
class Node{
    int key;
    Node[] forward;
    public Node(int key,int level){
        this.key = key;
        this.forward = new Node[level+1];
    }
}
