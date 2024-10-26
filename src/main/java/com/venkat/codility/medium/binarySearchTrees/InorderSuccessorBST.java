package com.venkat.codility.medium.binarySearchTrees;

public class InorderSuccessorBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.right = new TreeNode(15);

        TreeNode result = inorderSuccessor(root, root.left);
        System.out.println("Inorder Successor: " + (result != null ? result.val : "null")); // Output: 15
    }
}

