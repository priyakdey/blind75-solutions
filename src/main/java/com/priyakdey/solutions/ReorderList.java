package com.priyakdey.solutions;

import com.priyakdey.model.ListNode;

/**
 * <a href="https://leetcode.com/problems/reorder-list/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverseList(head2);

        ListNode curr1 = head, curr2 = head2;
        while (curr1 != null && curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            curr1.next = curr2;
            curr2.next = next1;
            curr1 = next1;
            curr2 = next2;
        }

    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode findMid(ListNode head) {
        ListNode mid = head, curr = head.next;
        while (curr != null && curr.next != null) {
            mid = mid.next;
            curr = curr.next.next;
        }

        return mid;
    }

}
