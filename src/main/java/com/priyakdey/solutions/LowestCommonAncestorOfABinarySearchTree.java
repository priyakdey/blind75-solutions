package com.priyakdey.solutions;

import com.priyakdey.model.TreeNode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">Problem  Statement</a>
 *
 * @author Priyak Dey
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) return root;
        TreeNode smaller = p, bigger = q;
        if (q.val < p.val) {
            smaller = q;
            bigger = p;
        }

        if (smaller.val < root.val && bigger.val > root.val) return root;
        if (bigger.val < root.val) return lowestCommonAncestor(root.left, smaller, bigger);
        return lowestCommonAncestor(root.right, smaller, bigger);
    }

}
