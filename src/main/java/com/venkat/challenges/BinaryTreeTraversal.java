package com.venkat.challenges;


public class BinaryTreeTraversal {

    // Method for postorder traversal using recursion
    public static void postorderRecursive(Node1 root) {
        // Base case: if the current node is null, return (end recursion for this branch)
        if (root == null) {
            return;
        }

        // Recur on the left subtree (visit all nodes in the left subtree first)
        postorderRecursive(root.left);

        // Recur on the right subtree (visit all nodes in the right subtree next)
        postorderRecursive(root.right);

        // Visit the root node (print the node's data after left and right subtrees have been visited)
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // Create the root node of the binary tree with value 1
        Node1 root = new Node1(1);

        // Create and attach left and right children to the root node
        root.left = new Node1(2);  // Node with value 2 attached to the left of root
        root.right = new Node1(3); // Node with value 3 attached to the right of root

        // Create and attach children to the left child of the root (Node 2)
        root.left.left = new Node1(4);  // Node with value 4 attached to the left of Node 2
        root.left.right = new Node1(5); // Node with value 5 attached to the right of Node 2

        // Create and attach children to the right child of the root (Node 3)
        root.right.left = new Node1(6);  // Node with value 6 attached to the left of Node 3
        root.right.right = new Node1(7); // Node with value 7 attached to the right of Node 3

        // Output message indicating that the postorder traversal is about to begin
        System.out.println("Postorder traversal (recursive):");

        // Perform the postorder traversal starting from the root node
        postorderRecursive(root);
    }
}

// A class representing the structure of a binary tree node (not included in the original code but assumed

