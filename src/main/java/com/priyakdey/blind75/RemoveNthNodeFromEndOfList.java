package com.priyakdey.blind75;

import com.priyakdey.blind75.models.ListNode;

/**
 * @author Priyak Dey
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        System.out.println(head.val);
        ListNode curr = head;
        // offset curr by n number of nodes from head
        while (curr.next != null && n > 1) {
            curr = curr.next;
            n--;
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

        nodeToDelete = null;

        return head;
    }
}
