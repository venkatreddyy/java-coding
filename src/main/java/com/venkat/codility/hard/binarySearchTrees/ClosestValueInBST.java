package com.venkat.codility.hard.binarySearchTrees;
/*
hese solutions cover:
Deleting a node in BST while maintaining its structure,
Finding the closest value to a target in BST using efficient traversal, and
Calculating the sum of values within a specified range in a BST using pruning techniques.





2. Closest Value in BST
Problem: Given a target value, find the value in the BST that is closest to the target.

Approach:
Traverse the tree:
At each node, compare its value with the target to see if it’s closer than the previously recorded closest value.
Move left or right based on whether the target is smaller or larger than the current node’s value.
Keep updating the closest value until the entire tree is traversed.

Explanation:
The closest variable keeps track of the closest value found so far.
We use the BST properties to efficiently narrow down to the closest value by moving left or right depending on the target.

 */
class ClosestValueInBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int closestValue(TreeNode root, double target) {
        int closest = root.val;

        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - closest)) {
                closest = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }

        return closest;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int result = closestValue(root, 3.714);
        System.out.println("Closest Value: " + result); // Expected Output: 4
    }
}

