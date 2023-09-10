package com.priyakdey.blind75;

import com.priyakdey.blind75.models.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        MinHeap heap = new MinHeap();

        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null) {
                heap.push(head);
            }
        }

        ListNode head = null, curr = null;

        while (!heap.isEmpty()) {
            ListNode node = heap.pop();

            if (head == null) {
                head = node;
                curr = head;
            } else {
                curr.next = node;
                curr = curr.next;
            }

            if (node.next != null) {
                heap.push(node.next);
            }
        }

        if (curr != null) {
            curr.next = null;
        }


        return head;
    }

}

class MinHeap {
    private final List<ListNode> data = new ArrayList<>();

    public void push(ListNode node) {
        data.add(node);

        // go bottom to top and swap nodes if necessary
        int currIndex = data.size() - 1;
        while (currIndex > 0) {
            int parentIndex = getParentIndex(currIndex);

            if (data.get(currIndex).val < data.get(parentIndex).val) {
                ListNode temp = data.get(currIndex);
                data.set(currIndex, data.get(parentIndex));
                data.set(parentIndex, temp);
            } else {
                break;
            }

            currIndex = parentIndex;
        }

    }

    public ListNode pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("no data to pop");
        }

        // pop the head
        ListNode root = data.get(0);

        // swap the head and tail
        data.set(0, data.get(data.size() - 1));
        // remove the last element
        data.remove(data.size() - 1);

        // no go from top to bottom and swap if necessary
        int currIndex = 0;
        while (currIndex < data.size()) {
            int leftChildIndex = getLeftChildIndex(currIndex);
            int rightChildIndex = getRightChildIndex(currIndex);

            if (leftChildIndex >= data.size()) {
                break;        // out of bounds
            }

            int swapIndex = leftChildIndex;
            if (rightChildIndex < data.size()
                && data.get(rightChildIndex).val < data.get(leftChildIndex).val) {
                swapIndex = rightChildIndex;
            }

            if (data.get(currIndex).val > data.get(swapIndex).val) {
                ListNode temp = data.get(currIndex);
                data.set(currIndex, data.get(swapIndex));
                data.set(swapIndex, temp);
            } else {
                break;
            }

            currIndex = swapIndex;
        }

        return root;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // -------- private methods ----------
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

}
