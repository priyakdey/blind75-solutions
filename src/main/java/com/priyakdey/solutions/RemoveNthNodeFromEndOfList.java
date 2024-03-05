package com.priyakdey.solutions;

import com.priyakdey.model.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        System.out.println(head.val);
        ListNode curr = head;

        while (curr.next != null && n > 1) {
            curr = curr.next;
            n--;
        }

        if (n != 1) {
            throw new IllegalArgumentException("not enough nodes");
        }

        ListNode nodeToDelete = head, prev = null;
        while (curr.next != null) {
            prev = nodeToDelete;
            nodeToDelete = nodeToDelete.next;
            curr = curr.next;
        }

        if (nodeToDelete == head) {
            head = head.next;
        } else {
            prev.next = nodeToDelete.next;
        }

        return head;
    }

}
