package com.leetcode.grind75.week3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsertInterval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        if (i >= intervals.length || intervals[i][0] > newInterval[1]) {
            result.add(newInterval);
        } else {
            int addedTo = i;
            while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                i++;
            }

            result.add(new int[]{Math.min(intervals[addedTo][0], newInterval[0]),
                    Math.max(intervals[i - 1][1], newInterval[1])});
        }

        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    @Test
    public void test() {
        assertTrue(Arrays.deepEquals(new int[][]{{1, 5}, {6, 9}}, insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        assertTrue(Arrays.deepEquals(new int[][]{{1, 5}, {6, 9}}, insert(new int[][]{{2, 3}, {6, 9}}, new int[]{1, 5})));
        assertTrue(Arrays.deepEquals(new int[][]{{1, 5}, {6, 9}}, insert(new int[][]{{2, 5}, {6, 9}}, new int[]{1, 3})));

        assertTrue(Arrays.deepEquals(new int[][]{{1, 3}, {4, 5}, {6, 9}}, insert(new int[][]{{1, 3}, {6, 9}}, new int[]{4, 5})));

        assertTrue(Arrays.deepEquals(new int[][]{{1, 9}}, insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 7})));

        assertTrue(Arrays.deepEquals(new int[][]{{1, 3}, {4, 5}, {6, 9}}, insert(new int[][]{{4, 5}, {6, 9}}, new int[]{1, 3})));
        assertTrue(Arrays.deepEquals(new int[][]{{4, 5}, {6, 9}, {10, 11}}, insert(new int[][]{{4, 5}, {6, 9}}, new int[]{10, 11})));
        assertTrue(Arrays.deepEquals(new int[][]{{1, 3}}, insert(new int[][]{}, new int[]{1, 3})));

        assertTrue(Arrays.deepEquals(new int[][]{{0, 3}, {6, 9}}, insert(new int[][]{{1, 3}, {6, 9}}, new int[]{0, 1})));
        assertTrue(Arrays.deepEquals(new int[][]{{1, 5}, {6, 9}}, insert(new int[][]{{1, 3}, {6, 9}}, new int[]{3, 5})));
    }
}
