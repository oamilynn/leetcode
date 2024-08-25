package com.leetcode.grind75.week2;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int n : nums) {
            if (numbers.contains(n)) {
                return true;
            }
            numbers.add(n);
        }
        return false;
    }
}
