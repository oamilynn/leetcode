package com.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseInteger {

    public String solution(int N) {
        String result = "";
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0) {
                enable_print = N % 10;
            }
            if (enable_print > 0) {
                //System.out.print(N % 10);
                result += String.valueOf(N % 10);
            }
            N = N / 10;
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals("12345", solution(54321));
        assertEquals("11001", solution(10011));
        assertEquals("1", solution(1));
        assertEquals("1", solution(10));
        assertEquals("1", solution(1000000000));
        assertEquals("11", solution(11));
        assertEquals("900001", solution(100009000));
        assertEquals("3", solution(3000));
        assertEquals("935701", solution(107539000));
    }
}
