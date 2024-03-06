package com.priyakdey.solutions;

import com.priyakdey.model.TreeNode;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        // Step 1. take the first element of the preorder and make it the node
        int nodeVal = preorder[0];
        TreeNode node = new TreeNode(nodeVal);

        if (preorder.length == 1) return node;

        // Step 2: Find index of this element in inorder
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == nodeVal) {
                index = i;
                break;
            }
        }

        // Step 3: Take left of this position
        int length = index - 1 - 0 + 1;
        int[] leftInorder = new int[length];
        int[] leftPreorder = new int[length];
        System.arraycopy(inorder,  0, leftInorder,  0, length);
        System.arraycopy(preorder, 1, leftPreorder, 0, length);

        // Step 4: recurse the left side to build the left subtree of node
        node.left = buildTree(leftPreorder, leftInorder);

        // Step 5: Take right of this position
        int length2 = inorder.length - 1 - index - 1 + 1;
        int[] rightInorder = new int[length2];
        int[] rightPreorder = new int[length2];
        System.arraycopy(inorder,  index + 1,  rightInorder,  0, length2);
        System.arraycopy(preorder, 1 + length, rightPreorder, 0, length2);

        node.right = buildTree(rightPreorder, rightInorder);

        return node;
    }

}
