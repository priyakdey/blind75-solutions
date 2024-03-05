package com.priyakdey.solutions;

import com.priyakdey.model.TreeNode;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        Objects.requireNonNull(root);
        if (root.left == null && root.right == null) return root.val;
        int[] maxSumRef = {Integer.MIN_VALUE};
        maxPathSumAtNode(root, maxSumRef);
        return maxSumRef[0];
    }

    private int maxPathSumAtNode(TreeNode node, int[] maxSumRef) {
        if (node == null) return 0;

        int leftTreeSum  = maxPathSumAtNode(node.left, maxSumRef);
        int rightTreeSum = maxPathSumAtNode(node.right, maxSumRef);

        int maxSum = max(node.val, node.val + leftTreeSum, node.val + rightTreeSum,
            node.val + leftTreeSum + rightTreeSum);
        maxSumRef[0] = max(maxSumRef[0], maxSum);

        return max(node.val, node.val + leftTreeSum, node.val + rightTreeSum);
    }


    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private int max(int a, int b, int c) {
        return max(a, max(b, c));
    }

    private int max(int a, int b, int c, int d) {
        return max(a, max(b, max(c, d)));
    }

}
