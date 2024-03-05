package com.priyakdey.solutions;

import com.priyakdey.model.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;

        int length = lists.length;
        if (length == 0) return null;
        if (length == 1) return lists[0];

        PriorityQueue<ListNode> minHeap =
            new PriorityQueue<>(length, Comparator.comparing((ListNode node) -> node.val));

        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        if (minHeap.isEmpty()) return null;

        ListNode head = minHeap.poll();
        ListNode curr = head;

        if (head.next != null) minHeap.offer(head.next);


        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) minHeap.offer(node.next);
        }

        return head;
    }

}
