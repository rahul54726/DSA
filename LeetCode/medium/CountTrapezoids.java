package com.LeetCode.medium;

import java.util.*;

public class CountTrapezoids {
    static final int MOD = 1_000_000_007;
    static final long INV2 = 500000004;
    public int countTrapezoids(int[][] points) {
        HashMap<Integer,Integer> yGroup = new HashMap<>();
        for(int[] point : points){
            int y = point[1];
            yGroup.put(y,yGroup.getOrDefault(y,0)+1);
        }
        long prevSum = 0;
        long result = 0;
        for(int key : yGroup.keySet()){
            long c = yGroup.get(key);
            long lines = (c * (c - 1)) %MOD;
            lines = (lines * INV2)%MOD;
            result = (result + prevSum * lines)% MOD;
            prevSum = (prevSum + lines) % MOD;
        }
        return (int)result;
    }
    public int countTrapezoidsII(int[][] points) {
        int n = points.length;
        double inf = 1e9 + 7;
        Map<Double, List<Double>> slopeToIntercept = new HashMap<>();
        Map<Integer, List<Double>> midToSlope = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dx = x1 - x2;
                int dy = y1 - y2;
                double k;
                double b;

                if (x2 == x1) {
                    k = inf;
                    b = x1;
                } else {
                    k = (1.0 * (y2 - y1)) / (x2 - x1);
                    b = (1.0 * (y1 * dx - x1 * dy)) / dx;
                }
                if (k == -0.0) {
                    k = 0.0;
                }
                if (b == -0.0) {
                    b = 0.0;
                }
                int mid = (x1 + x2) * 10000 + (y1 + y2);
                slopeToIntercept
                        .computeIfAbsent(k, key -> new ArrayList<>())
                        .add(b);
                midToSlope
                        .computeIfAbsent(mid, key -> new ArrayList<>())
                        .add(k);
            }
        }

        for (List<Double> sti : slopeToIntercept.values()) {
            if (sti.size() == 1) {
                continue;
            }
            Map<Double, Integer> cnt = new TreeMap<>();
            for (double b : sti) {
                cnt.put(b, cnt.getOrDefault(b, 0) + 1);
            }
            int sum = 0;
            for (int count : cnt.values()) {
                ans += sum * count;
                sum += count;
            }
        }

        for (List<Double> mts : midToSlope.values()) {
            if (mts.size() == 1) {
                continue;
            }
            Map<Double, Integer> cnt = new TreeMap<>();
            for (double k : mts) {
                cnt.put(k, cnt.getOrDefault(k, 0) + 1);
            }
            int sum = 0;
            for (int count : cnt.values()) {
                ans -= sum * count;
                sum += count;
            }
        }

        return ans;
    }

}
