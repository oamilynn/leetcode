package com.leetcode.grind75.week3;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int start = 0;
        int max = 0;
        int steak = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (chars.contains(c)) {
                while (charArray[start] != c) {
                    chars.remove(charArray[start]);
                    start++;
                    steak--;
                }
                start++;
            } else {
                steak++;
                if (steak > max) {
                    max = steak;
                }
                chars.add(c);
            }
        }
        return max;
    }
}
