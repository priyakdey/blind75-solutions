package com.priyakdey.solutions;

import com.priyakdey.model.TreeNode;

/**
 * <a href="https://leetcode.com/problems/subtree-of-another-tree/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        return isSubtreeInternal(root, subRoot)
            || isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    private boolean isSubtreeInternal(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        return node1.val == node2.val
            && isSubtreeInternal(node1.left, node2.left)
            && isSubtreeInternal(node1.right, node2.right);
    }

}
