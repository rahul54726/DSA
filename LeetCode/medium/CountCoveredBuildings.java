package com.LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CountCoveredBuildings {
    public static int countCoveredBuildings(int n, int[][] buildings) {
        int len = buildings.length;
        if(len <= 4) return 0;
        HashMap<Integer,List<Integer>> colMap = new HashMap<>();
        HashMap<Integer,List<Integer>> rowMap = new HashMap<>();
        for(int[] building : buildings){
            int x = building[0],y = building[1];
            colMap.computeIfAbsent(x,k -> new ArrayList<>()).add(y);
            rowMap.computeIfAbsent(y,k -> new ArrayList<>()).add(x);
        }

        for(List<Integer> list : colMap.values()){
            Collections.sort(list);
        }
        for(List<Integer> list : rowMap.values()){
            Collections.sort(list);
        }
        System.out.println(colMap);
        int count = 0;
        for(int[] b : buildings){
            int x = b[0] , y = b[1];
            List<Integer> colList = colMap.get(x);
            List<Integer> rowList = rowMap.get(y);
            int yIndex = Collections.binarySearch(colList , y);
            boolean hasBelow = yIndex > 0;
            boolean hasAbove = yIndex < colList.size() -  1;
            int xIndex = Collections.binarySearch(rowList , x);
            boolean hasLeft = xIndex > 0;
            boolean hasRight = xIndex < rowList.size() -  1;
            if (hasLeft && hasRight && hasAbove && hasBelow) count++;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countCoveredBuildings(3,new int[][]{
                {1,2},
                {2,2},
                {3,2},
                {2,1},
                {2,3}
        }));
    }
}
