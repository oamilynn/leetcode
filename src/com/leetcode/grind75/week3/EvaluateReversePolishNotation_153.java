package com.leetcode.grind75.week3;

import java.util.Stack;

public class EvaluateReversePolishNotation_153 {

    interface Operation {
        int getResult(int v1, int v2);
    }

    class Plus implements Operation {

        @Override
        public int getResult(int v1, int v2) {
            return v1 + v2;
        }
    }

    class Minus implements Operation {

        @Override
        public int getResult(int v1, int v2) {
            return v1 - v2;
        }
    }

    class Divide implements Operation {

        @Override
        public int getResult(int v1, int v2) {
            return v1 / v2;
        }
    }

    class Multiply implements Operation {

        @Override
        public int getResult(int v1, int v2) {
            return v1 * v2;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int value = 0;
        for (String token: tokens) {
            Operation op = null;
            switch (token) {
                case "+":
                    op = new Plus();
                    break;
                case "-":
                    op = new Minus();
                    break;
                case "/":
                    op = new Divide();
                    break;
                case "*":
                    op = new Multiply();
                    break;
                default:
                    Integer i = Integer.valueOf(token);
                    stack.push(i);
                    value = i;
            }
            if (op != null) {
                int v2 = stack.pop();
                value = op.getResult(stack.pop(), v2);
                stack.push(value);
            }
        }
        return value;
    }
}
