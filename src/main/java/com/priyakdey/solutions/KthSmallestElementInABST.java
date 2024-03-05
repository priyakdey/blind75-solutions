package com.priyakdey.solutions;

import com.priyakdey.model.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) throw new IllegalArgumentException("invalid input");
        if (root.left == null && root.right == null) {
            if (k == 1) return root.val;
            throw new IllegalArgumentException("not enough nodes");
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty() && k > 0) {
            curr = stack.pop();
            k--;

            TreeNode child = curr.right;
            while (child != null) {
                stack.push(child);
                child = child.left;
            }
        }

        if (k != 0) throw new IllegalArgumentException("not enough nodes");
        return curr.val;
    }

}
