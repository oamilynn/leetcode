package com.codility;

import org.junit.jupiter.api.Test;

public class TransformingString {

    private static final String[] REMOVALS = new String[]{"AB", "BA", "CD", "DC"};

    public String solution(String S) {
        String result = S;
        String resultTransformed = transform(result);
        while (!resultTransformed.equals(result)) {
            result = resultTransformed;
            resultTransformed = transform(result);
        }
        return result;
    }

    private String transform(String s) {
        for (String removal: REMOVALS) {
            int indexOfA = s.indexOf(removal);
            if (indexOfA != -1) {
                return s.replace(removal, "");
            }
        }
        return s;
    }

    @Test
    public void test() {
    }
}
