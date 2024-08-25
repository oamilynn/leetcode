package com.leetcode.grind75.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum3_15 {
    // TODO: make it faster
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> ints1 = new HashMap<>();
        for (int i : nums) {
            ints1.compute(i, (k, cnt) -> cnt == null ? 1 : (cnt + 1));
        }

        for (Map.Entry<Integer, Integer> entry : ints1.entrySet()) {
            if (entry.getValue() > 1) {
                int value = entry.getKey() + entry.getKey();
                if (value == entry.getKey()) {
                    if (entry.getValue() > 2) {
                        addValues(result, entry.getKey(), entry.getKey(), entry.getKey());
                    }
                } else if (ints1.containsKey(-value)) {
                    addValues(result, entry.getKey(), entry.getKey(), -value);
                }
            }
            for (Map.Entry<Integer, Integer> entry2 : ints1.entrySet()) {
                int value = entry.getKey() + entry2.getKey();
                if (entry2.getKey() > entry.getKey() &&
                        -value > entry.getKey() &&
                        -value > entry2.getKey()) {
                    if (ints1.containsKey(-value)) {
                        addValues(result, entry.getKey(), entry2.getKey(), -value);
                    }
                }
            }
        }

        return result;
    }

    private void addValues(List<List<Integer>> result, int i1, int i2, int i3) {
        List<Integer> res = new ArrayList<>(3);
        res.add(i1);
        res.add(i2);
        res.add(i3);
        result.add(res);
    }

}
