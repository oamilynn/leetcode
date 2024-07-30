package com.codility;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformingStringEfficient {

    private static final String[] REMOVALS = new String[]{"AB", "BA", "CD", "DC"};

    public String solution(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c: S.toCharArray()) {
            switch (c) {
                case 'A': {
                    handle(stack, 'A', 'B');
                    break;
                }
                case 'B': {
                    handle(stack, 'B', 'A');
                    break;
                }
                case 'C': {
                    handle(stack, 'C', 'D');
                    break;
                }
                case 'D': {
                    handle(stack, 'D', 'C');
                    break;
                }
            }
        }
        for (char c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static void handle(Stack<Character> stack, char current, char adjacent) {
        if (!stack.empty() && stack.peek() == adjacent) {
            stack.pop();
        } else {
            stack.push(current);
        }
    }

    @Test
    public void test() {
        assertEquals("ACBDACBD", solution("ACBDACBD"));
        assertEquals("C", solution("CBACD"));
        assertEquals("", solution("CABABD"));
        assertEquals("", solution("AAABBB"));
    }
}
