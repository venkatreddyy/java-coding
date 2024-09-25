package com.venkat.dsa.patterns;

class TreeNode1 {
    int val;
    TreeNode1 left, right;

    TreeNode1(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeDFS {

    // Preorder traversal (DFS)
    public void preorder(TreeNode1 root) {
        if (root == null) {
            return;
        }

        // Process the current node
        System.out.print(root.val + " ");

        // Recur for the left and right subtrees
        preorder(root.left);
        preorder(root.right);
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

        BinaryTreeDFS tree = new BinaryTreeDFS();
        System.out.print("Preorder Traversal (DFS) of Binary Tree: ");
        tree.preorder(root);  // Output: 1 2 4 5 3 6
    }
}

