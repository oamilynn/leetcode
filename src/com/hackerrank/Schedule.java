package com.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Schedule {

    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        char[] days = pattern.toCharArray();
        int used = 0;
        int freeDays = 0;
        for (char c : days) {
            if (c == '?') {
                freeDays++;
            } else {
                used += c - '0';
            }
        }
        int freeHours = workHours - used;
        List<String> possibleDays = splitHours(freeDays, dayHours, freeHours);

        List<String> results = new ArrayList<>(possibleDays.size());
        for (String possible : possibleDays) {
            String result = pattern;
            for (char c : possible.toCharArray()) {
                result = result.replaceFirst("/?", String.valueOf(c));
            }
            results.add(result);
        }

        return results;
    }

    private static List<String> splitHours(int days, int dayMax, int hours) {
        List<String> res = new ArrayList<>();
        int minUsedDays = (int) Math.ceil((double) hours / dayMax);
        if (minUsedDays > days) {
            throw new IllegalArgumentException();
        }

        int minForDay = 0;
        if (minUsedDays == days) {
            minForDay = hours % dayMax;
            if (minForDay == 0) {
                minForDay = dayMax;
            }
        }

        int maxForDay = dayMax;
        if (maxForDay > hours) {
            maxForDay = hours;
        }

        for (int i = minForDay; i <= maxForDay; i++) {
            if (days == 1) {
                res.add(i + "");
            } else {
                List<String> resForI = splitHours(days - 1, dayMax, hours - i);
                for (String s : resForI) {
                    res.add(i + s);
                }
            }
        }

        return res;
    }

    @Test
    public void test() {
        assertEquals(splitHours(2, 8, 4).size(), 5);
        assertEquals(splitHours(2, 8, 4).get(0), "04");
        assertEquals(splitHours(2, 8, 4).get(1), "13");
        assertEquals(splitHours(2, 8, 4).get(2), "22");
        assertEquals(splitHours(2, 8, 4).get(3), "31");
        assertEquals(splitHours(2, 8, 4).get(4), "40");
    }

    @Test
    public void test2() {
        assertEquals(splitHours(2, 4, 4).size(), 5);
        assertEquals(splitHours(2, 4, 4).get(0), "04");
        assertEquals(splitHours(2, 4, 4).get(1), "13");
        assertEquals(splitHours(2, 4, 4).get(2), "22");
        assertEquals(splitHours(2, 4, 4).get(3), "31");
        assertEquals(splitHours(2, 4, 4).get(4), "40");
    }

    @Test
    public void test3() {
        assertEquals(splitHours(1, 4, 4).size(), 1);
        assertEquals(splitHours(1, 4, 4).get(0), "4");
    }

    @Test
    public void test4() {
        assertEquals(splitHours(1, 4, 3).size(), 1);
        assertEquals(splitHours(1, 4, 3).get(0), "3");
    }

    @Test
    public void test5() {
        assertEquals(splitHours(0, 4, 0).size(), 0);
    }
}
