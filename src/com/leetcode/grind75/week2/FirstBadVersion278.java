package com.leetcode.grind75.week2;

import org.junit.jupiter.api.Test;

import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstBadVersion278 {

    // TODO: doesn't work
    public int firstBadVersion(int n, IntPredicate method) {
        int middle = n / 2;
        int end = n;
        while (middle < end && middle > 0) {
            if (method.test(middle)) {
                // if (isBadVersion(middle)) {
                end = middle;
                middle = middle / 2;
            } else {
                middle = middle + middle / 2;
            }
        }
        return end;
    }

    @Test
    public void test() {
        assertEquals(4, firstBadVersion(5, new MyIntPredicate(4)));
        assertEquals(1, firstBadVersion(1, new MyIntPredicate(1)));
        assertEquals(1, firstBadVersion(2, new MyIntPredicate(1)));
        assertEquals(2, firstBadVersion(2, new MyIntPredicate(2)));
    }

    private static class MyIntPredicate implements IntPredicate {

        private final int checkValue;

        public MyIntPredicate(int checkValue) {
            this.checkValue = checkValue;
        }

        @Override
        public boolean test(int value) {
            return value >= checkValue;
        }
    }
}
