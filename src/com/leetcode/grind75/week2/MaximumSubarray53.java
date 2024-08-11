package com.leetcode.grind75.week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int latestSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int sum = latestSum + nums[i];
            if (sum > nums[i]) {
                latestSum = sum;
            } else {
                latestSum = nums[i];
            }
            if (latestSum > currentMax) {
                currentMax = latestSum;
            }
        }

        return currentMax;
    }

    @Test
    public void test() {
        assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, maxSubArray(new int[]{1}));
        assertEquals(-1, maxSubArray(new int[]{-1}));
        assertEquals(23, maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
