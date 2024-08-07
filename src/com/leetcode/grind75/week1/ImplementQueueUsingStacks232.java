package com.leetcode.grind75.week1;

import com.leetcode.model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplementQueueUsingStacks232 {

    public class MyQueue {

        Stack<Integer> stack1;

        public MyQueue() {
            stack1 = new Stack<>();
        }

        public void push(int x) {
            Stack<Integer> stack2 = new Stack<>();
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }

        public int pop() {
            return stack1.pop();
        }

        public int peek() {
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.empty();
        }
    }

}
