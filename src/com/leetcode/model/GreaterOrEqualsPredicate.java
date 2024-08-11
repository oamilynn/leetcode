package com.leetcode.model;

import java.util.function.IntPredicate;

public class GreaterOrEqualsPredicate implements IntPredicate {
    private final int checkValue;

    public GreaterOrEqualsPredicate(int checkValue) {
        this.checkValue = checkValue;
    }

    @Override
    public boolean test(int value) {
        return value >= checkValue;
    }
}
