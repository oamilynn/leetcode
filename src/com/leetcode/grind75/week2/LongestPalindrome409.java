package com.leetcode.grind75.week2;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome409 {

    public int longestPalindrome(String s) {
        Map<Character, Boolean> letters = new HashMap<>();
        int longest = 0;
        int spareSymbols = 0;
        for (char c : s.toCharArray()) {
            Boolean cnt = letters.get(c);
            if (cnt == null || !cnt) {
                letters.put(c, true);
                spareSymbols++;
            } else {
                letters.put(c, false);
                longest += 2;
                spareSymbols--;
            }
        }
        if (spareSymbols > 0) {
            longest++;
        }
        return longest;
    }

}
