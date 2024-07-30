package com.leetcode.grind75.week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] array = s.toCharArray();
        int start = 0, end = array.length - 1;

        while (start < end) {
            if (!Character.isAlphabetic(array[start]) && !Character.isDigit(array[start])) {
                start++;
            } else if (!Character.isAlphabetic(array[end]) && !Character.isDigit(array[end])) {
                end--;
            } else if (array[start] != array[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }

    @Test
    public void test() {
        assertTrue(isPalindrome(" "));
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
