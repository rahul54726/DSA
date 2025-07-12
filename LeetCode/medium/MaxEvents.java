package com.LeetCode.medium;



import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxEvents {
    public static int maxEvents(int[][] events){
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = events[0][0], i = 0,res = 0;
        int n  = events.length;
        int lastDay = 0;
        for(int[] e :events){
            lastDay = Math.max(lastDay,e[1]);
        }
        while (day <= lastDay){
            while ( i < n && events[i][0] == day){
                minHeap.add(events[i][1]);
                i++;
            }
            while (!minHeap.isEmpty() && minHeap.peek() < day){
                minHeap.poll();
            }
            if(!minHeap.isEmpty()){
                minHeap.poll();
                res++;
            }
            day++;
        }
        return res;
    }
    // hard version
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b) -> (a[0]-b[0]));
        int n = events.length;
        int[] nextIndex = new int[n];
        for(int i = 0 ;i<n;i++){
            nextIndex[i] = binarySearch(i + 1,events,events[i][1]);
        }
        Integer[][] memo = new Integer[n][k+1];

        return solution(0,k,events,nextIndex,memo);
    }

    private int solution(int i, int k, int[][] events,int[] nextIndex,Integer[][] memo) {
        if(k == 0 || i >= events.length){
            return 0;
        }
        if(memo[i][k] != null) return memo[i][k];
        int skip = solution(i+1,k,events,nextIndex,memo);
        int attend = events[i][2] + solution(nextIndex[i],k-1,events,nextIndex,memo);
        return memo[i][k]=Math.max(skip,attend);
    }

    private int binarySearch(int start, int[][] events, int endTime) {
        int end = events.length - 1;
        int ans = end + 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(events[mid][0] > endTime){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
