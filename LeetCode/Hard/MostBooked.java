package com.LeetCode.Hard;

import com.Array.Array;
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MostBooked {
    public  static int mostBooked(int n ,int[][] meetings){
        Arrays.sort(meetings, Comparator.comparing(a ->a[0]));
        PriorityQueue<Integer> heap1 = new PriorityQueue<>();
        PriorityQueue<Integer> heap2 = new PriorityQueue<>();
        long[] finish = new long[n];
        int[] count = new int[n];
        Arrays.fill(count,0);

        for(int[] meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            boolean flag = false;
            long firstEnd = Long.MAX_VALUE;
            int firstEndRoom = 0;

            for(int room = 0;room < n;room++){
                if (finish[room] <= start ){
                    flag = true;
                    finish[room] = end;
                    count[room]++;
                    break;
                }
                if(finish[room]<firstEnd){
                    firstEnd = finish[room];
                    firstEndRoom = room;
                }

            }
            if(!flag){
                finish[firstEndRoom] += duration;
                count[firstEndRoom]++;
            }
        }
        int result = -1;
        int maxUse = 0;
        for(int room = 0;room<n;room++){
            if(count[room] >  maxUse){
                maxUse = count[room];
                result = room;
            }
        }
        return result;
    }
}
