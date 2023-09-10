package com.priyakdey.blind75;

import com.priyakdey.blind75.models.TreeNode;

/**
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
