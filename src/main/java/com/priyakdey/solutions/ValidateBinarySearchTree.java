package com.priyakdey.solutions;

import com.priyakdey.model.TreeNode;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
         return isValidBSTNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTNode(TreeNode node, long lowerBound, long upperBound) {
        if (node == null) return true;
        return node.val > lowerBound && node.val < upperBound
            && isValidBSTNode(node.left, lowerBound, node.val)
            && isValidBSTNode(node.right, node.val, upperBound);
    }

}
