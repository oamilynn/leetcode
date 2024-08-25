package com.leetcode.grind75.week2;

import com.leetcode.model.ListNode;

public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode last = head.next;
        ListNode newHead = head;
        while (last != null) {
            ListNode tmp = newHead;
            newHead = last;
            last = newHead.next;
            newHead.next = tmp;
        }
        head.next = null;
        return newHead;
    }
}
