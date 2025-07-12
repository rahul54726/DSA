package com.LeetCode.Graph;

import java.util.*;

public class CoinChange {
    public static int coinChange(int[] coins,int amount){
        if(amount == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        Set<Integer> visite = new HashSet<>();
        visite.add(amount);
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int size = queue.size();

            for(int i = 0;i<size;i++){
                int current = queue.poll();
                for(int coin : coins){
                    int next = current - coin;
                    if(next == 0) return level;
                    if(next > 0 && !visite.contains(next)) {
                        queue.offer(next);
                        visite.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private static int solve(int[] coins, int amount, int n, int count) {
        if(n == 0) return count;

        int last = coins[n];
        if(amount >= last){
            count++;
            return  solve(coins,amount-last,n,count);
        }
        return solve(coins,amount,n-1,count);
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5},11));
    }

}
