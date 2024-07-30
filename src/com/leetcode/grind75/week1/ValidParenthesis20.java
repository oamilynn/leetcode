package com.leetcode.grind75.week1;

import java.util.Stack;

public class ValidParenthesis20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[': {
                    stack.push(c);
                    break;
                }
                case ')': {
                    if (stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                }
                case '}': {
                    if (stack.empty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                }
                case ']': {
                    if (stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                }
            }
        }
        return stack.empty();
    }
}
