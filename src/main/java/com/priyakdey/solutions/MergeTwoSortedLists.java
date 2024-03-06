package com.priyakdey.solutions;

import com.priyakdey.model.ListNode;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/description">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null || list2 == null) return list1 != null ? list1 : list2;

        if (list1.val > list2.val) {
            ListNode temp = list2;
            list2 = list1;
            list1 = temp;
        }

        ListNode iter1 = list1.next, prev = list1, iter2 = list2;

        while (iter1 != null && iter2 != null) {
            if (iter1.val <= iter2.val) {
                prev = iter1;
                iter1 = iter1.next;
            } else {
                ListNode next = iter2.next;
                prev.next = iter2;
                prev = prev.next;
                prev.next = iter1;
                iter2 = next;
            }
        }

        if (iter2 != null) {
            prev.next = iter2;
        }

        return list1;
    }

}
