package com.leetcode.grind75.week4;

import java.util.Stack;

public class MinStack_155 {

    public MinStack_155() {
    }

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        Integer peeked = null;
        if (!minStack.empty()) {
            peeked = minStack.peek();
        }
        stack.push(val);
        if (peeked != null && peeked < val) {
            minStack.push(peeked);
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
