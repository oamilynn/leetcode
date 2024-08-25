package com.leetcode;

public class PalindromeNumber_9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String xStr = String.valueOf(x);
        char[] chars = xStr.toCharArray();
        for (int i = 0; i < Math.floor((double) chars.length / 2); i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

}
