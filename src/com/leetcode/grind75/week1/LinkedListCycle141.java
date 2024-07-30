package com.leetcode.grind75.week1;

import com.leetcode.model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle141 {

    //TODO: Inefficient
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }
}
