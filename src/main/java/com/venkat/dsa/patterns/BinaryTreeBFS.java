package com.venkat.dsa.patterns;

import java.util.LinkedList;
import java.util.Queue;

// Define the TreeNode1 class for the binary tree nodes


// Class that implements the binary tree and BFS traversal
/*
levelOrderTraversal() Function:
Line 12: We check if the root is null. If it is, there’s nothing to traverse, so we return.
Line 15: We create a Queue to keep track of the nodes that need to be processed. This is required for BFS.
Line 17: Add the root node to the queue to start traversal.
Line 20: A loop that runs until the queue is empty (i.e., all nodes have been processed).
Line 22: The poll() method dequeues the node at the front of the queue (the current node to process).
Line 24: Print the value of the current node.
Line 27-31: If the current node has a left child, add it to the queue. Similarly, if it has a right child, add it to the queue.
 */
public class BinaryTreeBFS {

    // Function to perform level-order traversal (BFS) on a binary tree
    public void levelOrderTraversal(TreeNode root) {
        // If the root is null, there's no tree to traverse, return early
        if (root == null) return;

        // Use a queue to track nodes at each level (BFS needs a queue for processing)
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the root node to start the traversal
        queue.add(root);

        // Continue processing while there are nodes in the queue
        while (!queue.isEmpty()) {
            // Poll the node at the front of the queue (dequeue it)
            TreeNode current = queue.poll();

            // Process the current node by printing its value
            System.out.print(current.val + " ");

            // If the current node has a left child, enqueue it
            if (current.left != null) {
                queue.add(current.left);
            }

            // If the current node has a right child, enqueue it
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

        // Create the root node with value 1
        TreeNode root = new TreeNode(1);

        // Create the left and right children of root
        root.left = new TreeNode(2);   // Left child of root
        root.right = new TreeNode(3);  // Right child of root

        // Create further children of node 2 (left subtree of root)
        root.left.left = new TreeNode(4);   // Left child of node 2
        root.left.right = new TreeNode(5);  // Right child of node 2

        // Create the right child of node 3 (right subtree of root)
        root.right.right = new TreeNode(6);  // Right child of node 3

        // Instantiate the BinaryTreeBFS class and perform the level-order traversal
        BinaryTreeBFS tree = new BinaryTreeBFS();

        // Output the result of level-order traversal of the binary tree
        System.out.print("Level Order Traversal of Binary Tree: ");
        tree.levelOrderTraversal(root);  // Expected Output: 1 2 3 4 5 6
    }
}


