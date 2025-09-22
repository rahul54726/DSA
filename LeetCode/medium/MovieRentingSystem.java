package com.LeetCode.medium;

import java.util.*;

public class MovieRentingSystem {
    private static class Entry {
        int shop, movie, price;
        Entry(int s, int m, int p) { shop = s; movie = m; price = p; }
    }

    private Map<Integer, TreeSet<Entry>> availableByMovie;  // movie -> available shops
    private TreeSet<Entry> rented;                          // all rented movies
    private Map<String, Entry> entryMap;                    // (shop,movie) -> entry

    public MovieRentingSystem(int n, int[][] entries) {
        availableByMovie = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a.price != b.price) return a.price - b.price;
            if (a.shop != b.shop) return a.shop - b.shop;
            return a.movie - b.movie;
        });
        entryMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Entry entry = new Entry(shop, movie, price);
            entryMap.put(key(shop, movie), entry);

            availableByMovie
                    .computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                        if (a.price != b.price) return a.price - b.price;
                        return a.shop - b.shop;
                    }))
                    .add(entry);
        }
    }

    public void rent(int shop, int movie) {
        Entry e = entryMap.get(key(shop, movie));
        availableByMovie.get(movie).remove(e);
        rented.add(e);
    }

    public void drop(int shop, int movie) {
        Entry e = entryMap.get(key(shop, movie));
        rented.remove(e);
        availableByMovie.get(movie).add(e);
    }

    // ✅ Return only shops (not [shop, price])
    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!availableByMovie.containsKey(movie)) return result;
        Iterator<Entry> it = availableByMovie.get(movie).iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            Entry e = it.next();
            result.add(e.shop);
            count++;
        }
        return result;
    }

    // ✅ Return list of [shop, movie] for rented movies
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Iterator<Entry> it = rented.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            Entry e = it.next();
            result.add(Arrays.asList(e.shop, e.movie));
            count++;
        }
        return result;
    }

    private String key(int shop, int movie) {
        return shop + "#" + movie;
    }
}
