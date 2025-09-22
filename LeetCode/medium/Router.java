package com.LeetCode.medium;

import java.util.*;

public class Router {
    private final int memoryLimit;
    private Deque<Packet> packetQueue;
    private Set<Packet> uniquePackets;
    private Map<Integer, List<Integer>> destToTimestamps;
    private Map<Integer, Integer> destToForwardedCount;
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packetQueue = new ArrayDeque<>();
        this.uniquePackets = new HashSet<>();
        this.destToTimestamps = new HashMap<>();
        this.destToForwardedCount = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);
        if (uniquePackets.contains(p)) {
            return false;
        }
        // If full, remove oldest
        if (packetQueue.size() == memoryLimit) {
            forwardPacket();
        }
        // Add new packet
        packetQueue.addLast(p);
        uniquePackets.add(p);

        // Add timestamp to the list for this destination
        destToTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        // Note: no need to sort since timestamps for calls addPacket come in non-decreasing order

        return true;
    }

    public List<Integer> forwardPacket() {
        if (packetQueue.isEmpty()) {
            return Collections.emptyList();
        }
        Packet oldest = packetQueue.removeFirst();
        uniquePackets.remove(oldest);

        int dest = oldest.destination;
        // Mark that one more packet for this destination was forwarded
        // This means in future getCount, we skip counting the earliest timestamp(s) for this dest
        destToForwardedCount.put(dest, destToForwardedCount.getOrDefault(dest, 0) + 1);

        return Arrays.asList(oldest.source, dest, oldest.timestamp);
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> tsList = destToTimestamps.get(destination);
        if (tsList == null) return 0;

        int forwarded = destToForwardedCount.getOrDefault(destination, 0);

        // We only consider timestamps from index = forwarded up to end
        int n = tsList.size();
        if (forwarded >= n) return 0;

        // Find first index in tsList[forwarded..] with value >= startTime
        int lo = lowerBound(tsList, forwarded, n, startTime);
        // Find first index in tsList[forwarded..] with value > endTime
        int hi = upperBound(tsList, forwarded, n, endTime);

        return hi - lo;
    }
    private int lowerBound(List<Integer> list, int lo, int hi, int target) {
        int l = lo, r = hi;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // helper: first index with value > target
    private int upperBound(List<Integer> list, int lo, int hi, int target) {
        int l = lo, r = hi;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    private static class Packet {
        int source;
        int destination;
        int timestamp;
        public Packet(int s, int d, int t) {
            source = s;
            destination = d;
            timestamp = t;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Packet)) return false;
            Packet p = (Packet) o;
            return source == p.source && destination == p.destination && timestamp == p.timestamp;
        }
        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }
}
