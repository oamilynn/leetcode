package com.leetcode.grind75.week2;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    // TODO: inefficient
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int majority = (nums.length + 1) / 2;
        for (int n : nums) {
            Integer cnt = numbers.get(n);
            if (cnt == null) {
                cnt = 0;
            }
            numbers.put(n, ++cnt);
            if (majority <= cnt) {
                return n;
            }
        }
        return -1;
    }
}
