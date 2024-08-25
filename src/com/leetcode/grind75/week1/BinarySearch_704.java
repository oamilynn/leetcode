package com.leetcode.grind75.week1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearch_704 {
    public int search(int[] nums, int target) {
        return search(nums, target, 0);
    }

    public int search(int[] nums, int target, int offset) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return offset;
            }
            return -1;
        }
        int id = nums.length / 2;
        if (nums[id] == target) {
            return id + offset;
        }
        if (nums[id] < target) {
            return search(Arrays.copyOfRange(nums, id + 1, nums.length), target, offset + id + 1);
        }
        return search(Arrays.copyOfRange(nums, 0, id), target, offset);
    }

    @Test
    public void test() {
        assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
