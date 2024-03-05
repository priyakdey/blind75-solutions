package com.priyakdey.solutions;

import com.priyakdey.model.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        return slow == fast;
    }

}
