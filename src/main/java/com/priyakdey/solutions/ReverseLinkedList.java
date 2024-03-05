package com.priyakdey.solutions;

import com.priyakdey.model.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        // return reverseListIterative(head);
        return reverseListRecursive(head, null);
    }

    private ListNode reverseListIterative(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode reverseListRecursive(ListNode curr, ListNode prev) {
        if (curr == null) return prev;

        ListNode next = curr.next;
        curr.next = prev;
        return reverseListRecursive(next, curr);
    }
}
