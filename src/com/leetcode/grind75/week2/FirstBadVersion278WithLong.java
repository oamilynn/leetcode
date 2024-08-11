package com.leetcode.grind75.week2;

import com.leetcode.model.GreaterOrEqualsPredicate;
import org.junit.jupiter.api.Test;

import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstBadVersion278WithLong {

    public int firstBadVersion(int n, IntPredicate method) {
        long end = n;
        long start = 1;
        long middle = (start + end) >> 1;
        while (middle < end && middle > start) {
            if (method.test((int) middle)) {
                // if (isBadVersion((int) middle)) {
                end = middle;
            } else {
                start = middle;
            }
            middle = start + ((end - start) >> 1);
        }
        // if (isBadVersion((int) start)) {
        if (method.test((int) start)) {
            return (int) start;
        }
        return (int) end;
    }

    @Test
    public void test() {
        assertEquals(2147483644, firstBadVersion(2147483647, new GreaterOrEqualsPredicate(2147483644)));
        assertEquals(1702766719, firstBadVersion(2126753390, new GreaterOrEqualsPredicate(1702766719)));
        assertEquals(4, firstBadVersion(5, new GreaterOrEqualsPredicate(4)));
        assertEquals(1, firstBadVersion(1, new GreaterOrEqualsPredicate(1)));
        assertEquals(1, firstBadVersion(2, new GreaterOrEqualsPredicate(1)));
        assertEquals(2, firstBadVersion(2, new GreaterOrEqualsPredicate(2)));
    }

}
