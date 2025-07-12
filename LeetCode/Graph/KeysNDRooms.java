package com.LeetCode.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysNDRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<List<Integer>> queue = new LinkedList<>();
        int[] visited = new int[rooms.size()];
        Arrays.fill(visited,0);
        queue.offer(rooms.getFirst());
        visited[0] = 1;
        while (!queue.isEmpty()){
            List<Integer> keys = queue.poll();
            for(int key:keys){
                if(visited[key] != 1){
                    visited[key] =1;
                    queue.offer(rooms.get(key));
                }
            }
        }
        int flag = 1;
        for(int nums:visited){
            flag *=nums;
        }
        return flag != 0;
    }
}
