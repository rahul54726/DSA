package com.LeetCode.medium;

import java.util.Arrays;

public class MatchPlayersAndTrainers {
    public static int matchPlayersAndTrainers(int[] players,int[] trainers){
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < players.length){
            int player = players[i];
            while (j<trainers.length){
                if(player <= trainers[j]) {
                    count++;
                    j++;
                    break;
                }
                else j++;
            }
            i++;
        }
        return count;
    }
    public static int matchPlayersAndTrainersOpti(int[] players,int[] trainers){
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < players.length && j < trainers.length){
           if(players[i] <= trainers[j]){
               count++;
               i++;
           }
           j++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(matchPlayersAndTrainersOpti(new int[]{1,1,1},new int[]{10}));
    }
}
