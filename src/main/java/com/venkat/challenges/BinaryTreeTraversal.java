package com.venkat.challenges;


public class BinaryTreeTraversal {

    // Method for postorder traversal using recursion
    public static void postorderRecursive(Node1 root) {
        if (root == null) {
            return;  // Base case: if the node is null, return
        }

        // Recur on left subtree
        postorderRecursive(root.left);

        // Recur on right subtree
        postorderRecursive(root.right);

        // Visit the root node (print the node's data)
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // Create a binary tree
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);
        root.right.left = new Node1(6);
        root.right.right = new Node1(7);

        // Perform postorder traversal
        System.out.println("Postorder traversal (recursive):");
        postorderRecursive(root);
    }
}

