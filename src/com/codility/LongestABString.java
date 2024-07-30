package com.codility;

public class LongestABString {

    public String solution(int AA, int AB, int BB) {
        StringBuilder sb = new StringBuilder();
        if (AA > BB) {
            for (int i = 0; i < AB; i++) {
                sb.append("AB");
            }
            for (int i = 0; i < BB; i++) {
                sb.append("AABB");
            }
            sb.append("AA");
        } else if (BB > AA) {
            for (int i = 0; i < AA; i++) {
                sb.append("BBAA");
            }
            sb.append("BB");
            for (int i = 0; i < AB; i++) {
                sb.append("AB");
            }
        } else {
            for (int i = 0; i < AA; i++) {
                sb.append("AABB");
            }
            for (int i = 0; i < AB; i++) {
                sb.append("AB");
            }
        }

        return sb.toString();
    }
}
