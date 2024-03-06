package com.priyakdey.solutions;

import com.priyakdey.model.TreeNode;

/**
 * <a href="https://leetcode.com/problems/invert-binary-tree/description">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;

        TreeNode leftChild = root.left, rightChild = root.right;

        root.left  = invertTree(rightChild);
        root.right = invertTree(leftChild);
        return root;
    }

}
