package com.LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Spellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        HashMap<String,String> capitalization = new HashMap<>();
        HashMap<String,String> vowel = new HashMap<>();

        for (int i = 0;i<wordlist.length;i++){
            exact.add(wordlist[i]);
            String word = wordlist[i].toLowerCase();
            if (!capitalization.containsKey(word)) capitalization.put(word,wordlist[i]);
            String word2 = word.replaceAll("[aeiou]","*");
            if (!vowel.containsKey(word2)) vowel.put(word2,wordlist[i]);
        }
        String[] result = new String[queries.length];
        int i = 0;
        for (String st : queries){
            String word = st.toLowerCase();
            String  word2 = word.replaceAll("[aeiou]","*");
            if (exact.contains(st)) result[i++] = st;
            else if (capitalization.containsKey(word)) result[i++] = capitalization.get(word);
            else if (vowel.containsKey(word2)) result[i++] = vowel.get(word2);
            else result[i++] = "";
        }
        return result;
    }
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char ch : brokenLetters.toCharArray()) {
            broken[ch - 'a'] = true;
        }
        String[] words = text.split(" ");
        int count = 0;

        for (String word:words){
            boolean valid = true;
            for (char ch :word.toCharArray()){
                if (broken[ch - 'a']){
                    valid = false;
                    break;
                }
            }
            if (valid) count++;
        }
        return count;
        }
    }

