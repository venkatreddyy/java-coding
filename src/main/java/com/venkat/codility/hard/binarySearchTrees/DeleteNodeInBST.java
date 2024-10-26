package com.venkat.codility.hard.binarySearchTrees;
/*
1. Delete Node in BST
Problem: Given a root of a BST and a key, delete the node with the key from the BST while maintaining the BST properties.

Approach:

Locate the node to be deleted:
If the key is smaller, move left; if larger, move right.
Delete the node:
Case 1: Node has no children (leaf) – simply remove it.
Case 2: Node has one child – replace it with its child.
Case 3: Node has two children – find the in-order successor (smallest in the right subtree), replace the node’s value with the successor’s value, and delete the successor.


 Explanation:
We recursively search for the node with the given key and apply the appropriate delete case.
For nodes with two children, we find the in-order successor and replace the current node’s value.
Example Output:

Node deleted. New root left child: 4

 */
class DeleteNodeInBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to be deleted found
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Node with two children: find the inorder successor
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        root = deleteNode(root, 3);
        System.out.println("Node deleted. New root left child: " + root.left.val); // Expected: 4
    }
}

