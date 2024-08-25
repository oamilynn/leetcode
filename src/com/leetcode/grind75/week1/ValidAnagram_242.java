package com.leetcode.grind75.week1;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> letters = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer cnt = letters.get(c);
            if (cnt == null) {
                letters.put(c, 1);
            } else {
                letters.put(c, cnt + 1);
            }
        }

        for (char c : t.toCharArray()) {
            Integer cnt = letters.get(c);
            if (cnt == null || cnt == 0) {
                return false;
            } else {
                letters.put(c, cnt - 1);
            }
        }

        for (int cnt : letters.values()) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
