package com.leetcode.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createList(int[] val) {
        ListNode root = null;
        ListNode current = null;
        for (int i : val) {
            if (root == null) {
                root = new ListNode(i);
                current = root;
            } else {
                current.next = new ListNode(i);
                current = current.next;
            }
        }
        return root;
    }
}
