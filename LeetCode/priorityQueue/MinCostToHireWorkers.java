package com.LeetCode.priorityQueue;

import java.util.*;

public class MinCostToHireWorkers {
    public double minCostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double min = Double.MAX_VALUE;
        for (int i = 0;i<n;i++){
            double ratio = (double) wage[i] /quality[i];
            List<Double> group = new ArrayList<>();
            for (int j = 0;j<n;j++){
                double workerWage = quality[j] * ratio;
                if (workerWage >= wage[j]){
                    group.add(workerWage);
                }
            }
            if (group.size() < k) continue;
            PriorityQueue<Double> heap = new PriorityQueue<>(group);
            double sumWage = 0;
            for (double wages:group){
                sumWage+=wages;
                heap.offer(wages);
                if (heap.size() > k){
                    sumWage -= heap.poll();
                }
            } min = Math.min(min,sumWage);
        }
        return min;
    }
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer>[] personLanguages = new Set[n+1];
        for (int i = 1;i<=n;i++){
            personLanguages[i] = new HashSet<>();
        }
        for (int i = 0; i  < languages.length ; i++) {
            for (int lang:languages[i]){
                personLanguages[i+1].add(lang);
            }
        }
        Set<Integer> candidates = new HashSet<>();
        for (int[] f : friendships){
            int u = f[0],v=f[1];
            boolean canTalk = false;
            for (int lang : personLanguages[u]){
                if (personLanguages[v].contains(lang)){
                    canTalk = true;
                    break;
                }
            }
            if (!canTalk){
                candidates.add(u);
                candidates.add(v);
            }
        }
        if (candidates.isEmpty()) return 0;
        int[] count = new int[n+1];
        for (int person : candidates){
            for(int lang:personLanguages[person]){
                count[lang]++;
            }
        }
        int maxAlreadyKnow = 0;
        for (int lang = 1;lang<=n;lang++){
            maxAlreadyKnow = Math.max(maxAlreadyKnow,count[lang]);
        }
        return candidates.size() - maxAlreadyKnow;
    }
}
