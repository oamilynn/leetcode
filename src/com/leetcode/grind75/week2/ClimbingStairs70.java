package com.leetcode.grind75.week2;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs70 {

    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        return fibonacchi(n);
    }

    public int fibonacchi(int n) {
        Integer cached = cache.get(n);
        if (cached != null) {
            return cached;
        }
        int res = switch (n) {
            case 0, 1 -> 1;
            default -> fibonacchi(n - 1) + fibonacchi(n - 2);
        };
        cache.put(n, res);
        return res;
    }
}
