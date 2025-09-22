package com.LeetCode.medium;

import java.util.*;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map;
    private final Deque<Integer> deque;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.deque = new ArrayDeque<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        deque.remove(key);
        deque.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.put(key,value);
            deque.remove(key);
            deque.addFirst(key);
            return;
        }
        if (map.size() == capacity){
            int lruKey = deque.removeLast();
            map.remove(lruKey);
        }
        map.put(key,value);
        deque.addFirst(key);

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

