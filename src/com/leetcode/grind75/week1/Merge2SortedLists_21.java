package com.leetcode.grind75.week1;

import com.leetcode.model.ListNode;

public class Merge2SortedLists_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = null, current = null;
        ListNode pointer1 = list1, pointer2 = list2;
        while (pointer1 != null || pointer2 != null) {
            if (pointer1 == null) {
                current = getListNode(current, pointer2);
                pointer2 = pointer2.next;
            } else if (pointer2 == null) {
                current = getListNode(current, pointer1);
                pointer1 = pointer1.next;
            } else if (pointer1.val < pointer2.val) {
                current = getListNode(current, pointer1);
                pointer1 = pointer1.next;
            } else {
                current = getListNode(current, pointer2);
                pointer2 = pointer2.next;
            }
            if (root == null) {
                root = current;
            }
        }
        return root;
    }

    private static ListNode getListNode(ListNode current, ListNode pointer1) {
        if (current == null) {
            current = new ListNode(pointer1.val);
        } else {
            current.next = new ListNode(pointer1.val);
            current = current.next;
        }
        return current;
    }
}
