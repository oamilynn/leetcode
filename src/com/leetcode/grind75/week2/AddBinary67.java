package com.leetcode.grind75.week2;

public class AddBinary67 {
    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int pointerA = aChars.length - 1;
        int pointerB = bChars.length - 1;
        boolean plus1 = false;
        char c;
        StringBuilder sb = new StringBuilder();
        while (pointerB >= 0 && pointerA >= 0) {
            boolean a1 = aChars[pointerA] == '1';
            boolean b1 = bChars[pointerB] == '1';
            if (a1 && b1 && plus1) {
                c = '1';
            } else if (a1 && b1 || a1 && plus1 || b1 && plus1) {
                c = '0';
                plus1 = true;
            } else if (a1 || b1 || plus1) {
                c = '1';
                plus1 = false;
            } else {
                c = '0';
            }
            sb.insert(0, c);
            pointerA--;
            pointerB--;
        }
        while (pointerB >= 0) {
            boolean b1 = bChars[pointerB] == '1';
            if (b1 && plus1) {
                c = '0';
            } else if (b1 || plus1) {
                c = '1';
                plus1 = false;
            } else {
                c = '0';
            }
            sb.insert(0, c);
            pointerB--;
        }
        while (pointerA >= 0) {
            boolean a1 = aChars[pointerA] == '1';
            if (a1 && plus1) {
                c = '0';
            } else if (a1 || plus1) {
                c = '1';
                plus1 = false;
            } else {
                c = '0';
            }
            sb.insert(0, c);
            pointerA--;
        }
        if (plus1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

}
