package com.venkat.dsa.patterns;

/*
Tree Structure:
The tree is structured as follows:
    1
   / \
  2   3
 / \   \
4   5   6
Traversal Outputs:

Inorder Traversal: 4 2 5 1 3 6
First, visit leftmost nodes, process root, then right subtree.
Preorder Traversal: 1 2 4 5 3 6
First, process the root, then visit the left subtree, followed by the right subtree.
Postorder Traversal: 4 5 2 6 3 1
First, visit the left subtree, then the right subtree, and finally process the root.
*/

// Class to implement and demonstrate DFS traversals (Inorder, Preorder, Postorder)
public class TreeDFSTraversal {

    // Inorder DFS Traversal: Left, Root, Right
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);             // Visit left subtree
        System.out.print(root.val + " "); // Process root node
        inorder(root.right);            // Visit right subtree
    }

    // Preorder DFS Traversal: Root, Left, Right
    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " "); // Process root node
        preorder(root.left);              // Visit left subtree
        preorder(root.right);             // Visit right subtree
    }

    // Postorder DFS Traversal: Left, Right, Root
    public void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);            // Visit left subtree
        postorder(root.right);           // Visit right subtree
        System.out.print(root.val + " "); // Process root node
    }

    public static void main(String[] args) {
        // Create the binary tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreeDFSTraversal treeTraversal = new TreeDFSTraversal();

        // Perform Inorder DFS Traversal
        System.out.print("Inorder Traversal (Left, Root, Right): ");
        treeTraversal.inorder(root);  // Expected Output: 4 2 5 1 3 6
        System.out.println();

        // Perform Preorder DFS Traversal
        System.out.print("Preorder Traversal (Root, Left, Right): ");
        treeTraversal.preorder(root); // Expected Output: 1 2 4 5 3 6
        System.out.println();

        // Perform Postorder DFS Traversal
        System.out.print("Postorder Traversal (Left, Right, Root): ");
        treeTraversal.postorder(root); // Expected Output: 4 5 2 6 3 1
        System.out.println();
    }
}

