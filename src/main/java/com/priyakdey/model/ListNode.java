package com.priyakdey.model;

/**
 * Definition for singly-linked list.
 *
 * @author Priyak Dey
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
