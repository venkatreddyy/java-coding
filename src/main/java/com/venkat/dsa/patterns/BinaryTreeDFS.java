package com.venkat.dsa.patterns;

/*
Tree Structure:
The tree that is created has the following structure:
markdown
Copy code
    1
   / \
  2   3
 / \   \
4   5   6
Traversal Explanation:
Start at the root node (1).
Process node 1, then move to its left subtree.
Process node 2, then move to its left subtree (node 4).
Process node 4, backtrack to node 2, then move to its right subtree (node 5).
Process node 5, backtrack to the root node (1), and then move to its right subtree.
Process node 3, then move to its right subtree (node 6).
Process node 6, complete the traversal.
Time Complexity:
O(n): Every node is visited exactly once, where n is the number of nodes in the tree.
Space Complexity:
O(h): The space complexity is proportional to the height of the tree (h) because of the recursion stack. In the worst case, if the tree is skewed, the space complexity becomes O(n). For a balanced tree, it's O(log n).
 */
// Define the TreeNode1 class for the binary tree nodes
class TreeNode {
    int val;            // The value stored in the node
    TreeNode left, right;  // References to the left and right children

    // Constructor to create a TreeNode1 with a given value
    TreeNode(int val) {
        this.val = val;  // Assign the value to the node
        left = right = null;  // Initially, both children are set to null
    }
}

// Class to implement the binary tree and DFS traversal
public class BinaryTreeDFS {

    // Function to perform preorder traversal (Depth-First Search) on a binary tree
    public void preorder(TreeNode root) {
        // If the root is null, return (base case of the recursion)
        if (root == null) {
            return;
        }

        // Process the current node (in preorder, the current node is visited first)
        System.out.print(root.val + " ");

        // Recur for the left subtree (left child is visited before right in preorder)
        preorder(root.left);

        // Recur for the right subtree
        preorder(root.right);
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

        // Create left and right children of the root
        root.left = new TreeNode(2);   // Left child of root
        root.right = new TreeNode(3);  // Right child of root

        // Create further children of node 2 (left subtree of root)
        root.left.left = new TreeNode(4);   // Left child of node 2
        root.left.right = new TreeNode(5);  // Right child of node 2

        // Create the right child of node 3 (right subtree of root)
        root.right.right = new TreeNode(6);  // Right child of node 3

        // Instantiate the BinaryTreeDFS class and perform the preorder traversal
        BinaryTreeDFS tree = new BinaryTreeDFS();

        // Output the result of preorder traversal of the binary tree
        System.out.print("Preorder Traversal (DFS) of Binary Tree: ");
        tree.preorder(root);  // Expected Output: 1 2 4 5 3 6
    }
}

