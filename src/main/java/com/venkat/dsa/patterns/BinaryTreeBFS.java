package com.venkat.dsa.patterns;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode1 left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeBFS {

    // Perform level-order traversal (BFS) on a binary tree
    public void levelOrderTraversal(TreeNode1 root) {
        if (root == null) return;

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode1 current = queue.poll();
            System.out.print(current.val + " "); // Process the current node

            // Add left and right children to the queue
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        // Create a binary tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);
        root.right.right = new TreeNode1(6);

        BinaryTreeBFS tree = new BinaryTreeBFS();
        System.out.print("Level Order Traversal of Binary Tree: ");
        tree.levelOrderTraversal(root);  // Output: 1 2 3 4 5 6
    }
}

