package com.LeetCode.DynamicProgramming;

import java.util.Arrays;

public class FloydWarshallAPSP {
    static  final  int INF = (int)1e9;
    public static int[][] floydWarshall(int[][] graph){
        int n = graph.length;
        int[][] dist = new int[n][n];
        for (int i = 0;i<n;i++){
            System.arraycopy(graph[i],0,dist[i],0,n);
        }
        for (int k = 0;k<n;k++){
            for (int i = 0;i<n;i++){
                for (int j = 0;j<n;j++){
                    if(dist[i][k] < INF && dist[k][j] <INF){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int INF = (int)1e9;
        int[][] graph = {
                {0,   3,   INF, 7},
                {8, 0,   2,   INF},
                {5, INF, 0,   1},
                {2, INF, INF, 0}
        };

        int[][] ans = floydWarshall(graph);

        // print result
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }
}
