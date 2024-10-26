package com.venkat.codility.hard.binarySearchTrees;
/*
3. Range Sum of BST
Problem: Given the root of a BST and a range [low, high], return the sum of all values in the BST that fall within the range.

Approach:
Traverse the tree using DFS or BFS.
For each node:
Add the node’s value to the sum if it falls within [low, high].
Recur or iterate left if node.val > low and right if node.val < high to prune unnecessary branches.

Explanation:
We perform a depth-first search, adding nodes that fall within the range [low, high].
If node.val > low, we search the left subtree since values there might fall within the range.
If node.val < high, we search the right subtree for the same reason.
Example Output:
Range Sum of BST: 32
 */
class RangeSumBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        int sum = rangeSumBST(root, 7, 15);
        System.out.println("Range Sum of BST: " + sum); // Expected Output: 32
    }
}

