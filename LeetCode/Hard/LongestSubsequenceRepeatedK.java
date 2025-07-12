package com.LeetCode.Hard;

import com.Rahul.Interface.Annotations.B;

import java.util.*;

public class LongestSubsequenceRepeatedK {
    public String longestSubsequenceRepeatedK(String s, int k) {
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        String result = "";

        // BFS to explore subsequences
        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (char c = 'a'; c <= 'z'; c++) {
                String candidate = current + c;

                if (isValid(s, candidate, k)) {
                    queue.add(candidate);

                    // Update result if the candidate is better
                    if (candidate.length() > result.length() ||
                            (candidate.length() == result.length() && candidate.compareTo(result) > 0)) {
                        result = candidate;
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String s, String subseq, int k) {
        int count = 0, index = 0;

        for (char c : s.toCharArray()) {
            if (index < subseq.length() && c == subseq.charAt(index)) {
                index++;
                if (index == subseq.length()) {
                    count++;
                    index = 0;
                    if (count >= k) {
                        return true;
                    }
                }
            }
        }

        return count >= k;
    }
}
