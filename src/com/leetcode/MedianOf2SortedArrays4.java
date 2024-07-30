package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOf2SortedArrays4 {

    //1h
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int i1 = 0, i2 = 0;
        int first = 0, second = 0;

        for (int i = 0; i < Math.floor((double) length / 2) + 1; i++) {
            if (i2 >= nums2.length) {
                first = second;
                second = nums1[i1];
                i1++;
            } else if (i1 >= nums1.length) {
                first = second;
                second = nums2[i2];
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                first = second;
                second = nums1[i1];
                i1++;
            } else {
                first = second;
                second = nums2[i2];
                i2++;
            }
        }

        if ((length % 2 == 1)) {
            return second;
        }

        return (double) (first + second) / 2;
    }

    @Test
    public void test() {
        assertEquals(1, findMedianSortedArrays(new int[]{}, new int[]{1}));
        assertEquals(2.5, findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.01);
    }

}
