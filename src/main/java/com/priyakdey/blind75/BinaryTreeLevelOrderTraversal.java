package com.priyakdey.blind75;

import com.priyakdey.blind75.models.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */

class Queue {
    private final List<TreeNode> data = new ArrayList<>();

    public void enqueue(TreeNode node) {
        data.add(node);
    }

    public TreeNode dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("queue empty....");
        }

        return data.remove(0);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public Queue copy() {
        Queue q = new Queue();
        while (!this.isEmpty()) {
            q.enqueue(this.dequeue());
        }

        return q;
    }

    public void clear() {
        this.data.clear();
    }

}

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();

        if (root == null) {
            return levelOrder;
        }

        Queue currLevel = new Queue();
        currLevel.enqueue(root);

        Queue nextLevel = new Queue();

        List<Integer> values = new ArrayList<>();

        while (!currLevel.isEmpty()) {
            TreeNode node = currLevel.dequeue();
            values.add(node.val);

            if (node.left != null) {
                nextLevel.enqueue(node.left);
            }

            if (node.right != null) {
                nextLevel.enqueue(node.right);
            }

            if (currLevel.isEmpty()) {
                // add the level values
                levelOrder.add(new ArrayList<>(values));
                values.clear();

                // copy over elements from next level to curr level for next iteration
                currLevel = nextLevel.copy();
                nextLevel.clear();
            }

        }

        return levelOrder;

    }
}
