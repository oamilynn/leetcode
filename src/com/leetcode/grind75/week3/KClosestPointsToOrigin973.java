package com.leetcode.grind75.week3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KClosestPointsToOrigin973 {

    // TODO: make it faster
    public int[][] kClosest(int[][] points, int k) {
        List<Double> results = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            double distance = calculateDistance(points[i]);
            int j = 0;
            int min = Math.min(k, results.size());
            boolean added = false;
            for (; j < min; j++) {
                if (results.get(j) > distance) {
                    results.add(j, distance);
                    ids.add(j, i);
                    added = true;
                    break;
                }
            }
            if (!added && j < k) {
                results.add(j, distance);
                ids.add(j, i);
            }
        }
        int min = Math.min(k, results.size());
        int[][] res = new int[min][];
        for (int i = 0; i < min; i++) {
            res[i] = points[ids.get(i)];
        }
        return res;
    }

    private double calculateDistance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }

    @Test
    public void test() {
        assertTrue(Arrays.deepEquals(new int[][]{{-2, 2}}, kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        assertTrue(Arrays.deepEquals(new int[][]{{-2, 2}, {2, -2}}, kClosest(new int[][]{{1, 3}, {-2, 2}, {2, -2}}, 2)));
    }

}
