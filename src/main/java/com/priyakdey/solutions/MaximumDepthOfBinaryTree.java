package com.priyakdey.solutions;

import com.priyakdey.model.TreeNode;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int depth) {
        if (node == null) return 0;
        int leftDepth  = 1 + maxDepth(node.left, depth + 1);
        int rightDepth = 1 + maxDepth(node.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }

}
