package com.LeetCode.Easy;

public class IsValid {
    public static boolean isValid(String word) {
        return word.length() >= 3 &&
                word.chars().allMatch(Character::isLetterOrDigit) &&
                word.chars().anyMatch(c -> "aeiouAEIOU".indexOf(c) >= 0) &&
                word.chars().anyMatch(c -> Character.isLetter(c) &&
                        "aeiouAEIOU".indexOf(c) < 0);
    }

    public static void main(String[] args) {
        System.out.println(isValid("3pp"));
    }
}
