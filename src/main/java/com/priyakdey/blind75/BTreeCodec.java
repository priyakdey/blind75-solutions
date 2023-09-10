package com.priyakdey.blind75;

import com.priyakdey.blind75.models.TreeNode;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class BTreeCodec {

//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//
//    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        print(root);
    }

    private static void print(TreeNode node) {
        if (node == null) {
            return;
        }

        print(node.left);
        System.out.println(node.val);
        print(node.right);
    }
}
