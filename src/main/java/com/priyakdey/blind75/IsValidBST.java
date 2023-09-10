package com.priyakdey.blind75;

import com.priyakdey.blind75.models.TreeNode;

/**
 * @author Priyak Dey
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lowerBound, long upperBound) {
        if (root == null) {
            return true;
        }

        boolean isValidBSTNode = root.val > lowerBound && root.val < upperBound;

        return isValidBSTNode && isValidBST(root.left, lowerBound, root.val) &&
            isValidBST(root.right, root.val, upperBound);

    }


}
