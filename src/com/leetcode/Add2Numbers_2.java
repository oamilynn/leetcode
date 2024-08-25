package com.leetcode;

import com.leetcode.model.ListNode;

public class Add2Numbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode res = null;
        ListNode resc = null;
        boolean plus1 = false;
        while (c1 != null && c2 != null) {
            int sum = c1.val + c2.val;
            if (plus1) {
                sum += 1;
            }
            plus1 = (sum >= 10);
            if (resc == null) {
                resc = new ListNode(sum % 10);
                res = resc;
            } else {
                resc.next = new ListNode(sum % 10);
                resc = resc.next;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        while (c1 != null) {
            int sum = c1.val;
            if (plus1) {
                sum += 1;
            }
            plus1 = (sum >= 10);
            if (resc == null) {
                resc = new ListNode(sum % 10);
                res = resc;
            } else {
                resc.next = new ListNode(sum % 10);
                resc = resc.next;
            }
            c1 = c1.next;
        }
        while (c2 != null) {
            int sum = c2.val;
            if (plus1) {
                sum += 1;
            }
            plus1 = (sum >= 10);
            if (resc == null) {
                resc = new ListNode(sum % 10);
                res = resc;
            } else {
                resc.next = new ListNode(sum % 10);
                resc = resc.next;
            }
            c2 = c2.next;
        }
        if (plus1) {
            resc.next = new ListNode(1);
        }
        return res;
    }
}
