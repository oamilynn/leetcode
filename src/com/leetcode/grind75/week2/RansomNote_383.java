package com.leetcode.grind75.week2;

import java.util.HashMap;
import java.util.Map;

public class RansomNote_383 {
    // TODO: inefficient
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> letters = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            letters.merge(c, 1, Integer::sum);
        }
        for (char c : ransomNote.toCharArray()) {
            Integer cnt = letters.get(c);
            if (cnt != null && cnt > 0) {
                letters.put(c, cnt - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
