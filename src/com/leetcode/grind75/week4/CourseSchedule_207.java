package com.leetcode.grind75.week4;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseSchedule_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] preqs = new Set[numCourses];
        boolean[] checked = new boolean[numCourses];
        for (int[] p : prerequisites) {
            Set<Integer> pqs = preqs[p[0]];
            if (pqs == null) {
                pqs = new HashSet<>();
                preqs[p[0]] = pqs;
            }
            pqs.add(p[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(preqs, checked, new HashSet<>(), i)) {
                return false;
            }
            checked[i] = true;
        }
        return true;
    }

    private boolean hasCycle(Set<Integer>[] preqs, boolean[] checked, Set<Integer> path, int root) {
        if (path.contains(root)) {
            return true;
        }
        Set<Integer> rootPreqs = preqs[root];
        if (rootPreqs == null || checked[root]) {
            return false;
        }
        path.add(root);
        for (int i : rootPreqs) {
            if (hasCycle(preqs, checked, path, i)) {
                return true;
            }
            path.remove(i);
        }
        return false;
    }

    @Test
    public void test() {
        assertTrue(canFinish(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}}));
    }
}
