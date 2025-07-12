package com.LeetCode.Graph;

import java.util.*;
public class MinMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> setBank = new HashSet<>(List.of(bank));
        if (!setBank.contains(endGene)) return -1; // Early exit if endGene isn't in the bank.

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);

        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) return level;

                char[] currentChars = current.toCharArray();
                for (int j = 0; j < currentChars.length; j++) {
                    char originalChar = currentChars[j];
                    for (char ch : "ACGT".toCharArray()) {
                        if (ch == originalChar) continue; // Skip if the mutation is the same.

                        currentChars[j] = ch;
                        String neighbor = new String(currentChars);

                        if (setBank.contains(neighbor) && !visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                    currentChars[j] = originalChar; // Revert mutation.
                }
            }
            level++;
        }

        return -1; // If no mutation path exists.
    }
}


