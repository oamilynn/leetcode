package com.leetcode.grind75.week2;

import com.leetcode.model.ListNode;

public class MiddleOfTheLinkedList876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;

        while (pointer1 != null && pointer2 != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
            if (pointer2 != null) {
                pointer2 = pointer2.next;
            }
        }

        return pointer1;
    }
}
