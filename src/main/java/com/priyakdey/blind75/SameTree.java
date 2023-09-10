package com.priyakdey.blind75;

import com.priyakdey.blind75.models.TreeNode;

/**
 * @author Priyak Dey
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        // p and q are both non-null, we validate the values and then go down to same child
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

}
