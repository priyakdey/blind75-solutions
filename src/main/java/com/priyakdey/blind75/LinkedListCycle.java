package com.priyakdey.blind75;

import com.priyakdey.blind75.models.ListNode;

/**
 * @author Priyak Dey
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slowPtr = head, fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (fastPtr == slowPtr) {
                break;
            }
        }

        return fastPtr == slowPtr;
    }
}
