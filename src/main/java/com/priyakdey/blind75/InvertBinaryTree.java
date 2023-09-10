package com.priyakdey.blind75;

import com.priyakdey.blind75.models.TreeNode;

/**
 * @author Priyak Dey
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        TreeNode leftChild = root.left, rightChild = root.right;

        root.left = invertTree(rightChild);
        root.right = invertTree(leftChild);
        return root;
    }

}
