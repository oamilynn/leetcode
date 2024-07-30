package com.codility;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SmallestInt {

    public int solution(int[] A) {
        boolean ints[] = new boolean[100002];
        Arrays.fill(ints, false);
        for (int i: A) {
            if (i <= 100002) {
                ints[i] = true;
            }
        }
        for (int i = 1; i < ints.length; i++) {
            if (!ints[i]) {
                return i;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        solution(new int[] {});
    }
}
