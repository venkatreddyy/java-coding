package com.venkat.hundred;

import java.util.*;
/*
Explanation of Each Problem and Test Cases:
Check if a Binary Tree is BST: Verifies if a given binary tree satisfies the Binary Search Tree property.

Output: true
Count BST Nodes that Lie in a Given Range: Counts the number of nodes in the BST that lie within a specified range.

Output: 5
Searching in Binary Search Tree (BST): Searches for a key in the BST and returns whether it exists.

Output: true
Lowest Common Ancestor in a Binary Search Tree: Finds the lowest common ancestor of two nodes in a BST.

Output: 12
K'th Largest Element in BST (Without Modification): Finds the K'th largest element in a BST using reverse inorder traversal.

Output: 14
Find the Node with Minimum Value in a Binary Search Tree: Finds the node with the smallest value in a BST.

Output: 4
Inorder Successor in Binary Search Tree: Finds the inorder successor of a given node in a BST.

Output: 10
Find the Median of BST: Computes the median value of all nodes in the BST.

Output: 12.0
Binary Tree to Binary Search Tree Conversion: Converts a binary tree into a BST while maintaining the structure but sorting the node values.

Output (Inorder Traversal): 5 10 15 20 30
Count Pairs from Two BSTs Whose Sum is Equal to a Given Value: Counts the number of pairs from two different BSTs whose node values sum to a specified value.

Output: 1

 */
public class Level1BSTProblems {

    // TreeNode class definition
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // 1. Check if a Binary Tree is a BST or not
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static boolean isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(TreeNode node, int min, int max) {
        if (node == null) return true; // An empty tree is a BST
        if (node.data <= min || node.data >= max) return false; // BST property violation
        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }

    // 2. Count BST Nodes that Lie in a Given Range
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static int countNodesInRange(TreeNode root, int low, int high) {
        if (root == null) return 0; // Base case
        if (root.data >= low && root.data <= high) {
            return 1 + countNodesInRange(root.left, low, high) + countNodesInRange(root.right, low, high); // Node lies in range
        } else if (root.data < low) {
            return countNodesInRange(root.right, low, high); // Move to the right subtree
        } else {
            return countNodesInRange(root.left, low, high); // Move to the left subtree
        }
    }

    // 3. Searching in a Binary Search Tree (BST)
    // Time Complexity: O(h), where h is the height of the tree
    // Space Complexity: O(1), iterative approach
    public static TreeNode searchBST(TreeNode root, int key) {
        while (root != null && root.data != key) {
            if (key < root.data) root = root.left;
            else root = root.right;
        }
        return root; // Return the node if found, else null
    }

    // 4. Lowest Common Ancestor in a Binary Search Tree
    // Time Complexity: O(h), where h is the height of the tree
    // Space Complexity: O(1), no extra space used
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.data < root.data && q.data < root.data) root = root.left; // Move to left subtree
            else if (p.data > root.data && q.data > root.data) root = root.right; // Move to right subtree
            else return root; // This is the lowest common ancestor
        }
        return null;
    }

    // 5. K'th Largest Element in BST (Without modification)
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    static int kthLargestCount;
    static int kthLargestResult;

    public static int kthLargest(TreeNode root, int k) {
        kthLargestCount = 0;
        kthLargestResult = -1;
        kthLargestUtil(root, k);
        return kthLargestResult;
    }

    private static void kthLargestUtil(TreeNode node, int k) {
        if (node == null || kthLargestCount >= k) return;
        kthLargestUtil(node.right, k);
        kthLargestCount++;
        if (kthLargestCount == k) {
            kthLargestResult = node.data;
            return;
        }
        kthLargestUtil(node.left, k);
    }

    // 6. Find the Node with Minimum Value in a Binary Search Tree
    // Time Complexity: O(h), where h is the height of the tree
    // Space Complexity: O(1), no extra space used
    public static TreeNode findMin(TreeNode root) {
        while (root.left != null) root = root.left; // Keep moving left to find the minimum
        return root; // The leftmost node is the minimum
    }

    // 7. Inorder Successor in a Binary Search Tree
    // Time Complexity: O(h), where h is the height of the tree
    // Space Complexity: O(1), no extra space used
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
        TreeNode successor = null;
        while (root != null) {
            if (node.data < root.data) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    // 8. Find the Median of BST
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static double findMedian(TreeNode root) {
        int count = countNodes(root);
        int[] medianNodes = new int[2];
        if (count % 2 == 0) {
            inorderForMedian(root, count / 2, medianNodes);
            return (medianNodes[0] + medianNodes[1]) / 2.0;
        } else {
            inorderForMedian(root, (count + 1) / 2, medianNodes);
            return medianNodes[0];
        }
    }

    private static int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private static void inorderForMedian(TreeNode node, int target, int[] medianNodes) {
        inorderForMedianUtil(node, target, new int[]{0}, medianNodes);
    }

    private static void inorderForMedianUtil(TreeNode node, int target, int[] currentCount, int[] medianNodes) {
        if (node == null) return;
        inorderForMedianUtil(node.left, target, currentCount, medianNodes);
        currentCount[0]++;
        if (currentCount[0] == target) {
            medianNodes[0] = node.data;
        } else if (currentCount[0] == target + 1) {
            medianNodes[1] = node.data;
            return;
        }
        inorderForMedianUtil(node.right, target, currentCount, medianNodes);
    }

    // 9. Binary Tree to Binary Search Tree Conversion
    // Time Complexity: O(n log n), where n is the number of nodes (due to sorting)
    // Space Complexity: O(n), for storing tree nodes
    public static TreeNode binaryTreeToBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        storeInorder(root, nodes); // Store inorder traversal of the binary tree
        Collections.sort(nodes); // Sort the values
        return buildBSTFromSortedArray(nodes, 0, nodes.size() - 1); // Convert sorted array to BST
    }

    private static void storeInorder(TreeNode node, List<Integer> nodes) {
        if (node == null) return;
        storeInorder(node.left, nodes);
        nodes.add(node.data);
        storeInorder(node.right, nodes);
    }

    private static TreeNode buildBSTFromSortedArray(List<Integer> nodes, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = buildBSTFromSortedArray(nodes, start, mid - 1);
        node.right = buildBSTFromSortedArray(nodes, mid + 1, end);
        return node;
    }

    // 10. Count Pairs from Two BSTs Whose Sum is Equal to a Given Value x
    // Time Complexity: O(n1 + n2), where n1 and n2 are the number of nodes in the two trees
    // Space Complexity: O(h1 + h2), where h1 and h2 are the heights of the two trees
    public static int countPairsWithSum(TreeNode root1, TreeNode root2, int x) {
        Set<Integer> values = new HashSet<>();
        storeValuesInSet(root1, values);
        return countPairsUtil(root2, values, x);
    }

    private static void storeValuesInSet(TreeNode node, Set<Integer> set) {
        if (node == null) return;
        set.add(node.data);
        storeValuesInSet(node.left, set);
        storeValuesInSet(node.right, set);
    }

    private static int countPairsUtil(TreeNode node, Set<Integer> set, int x) {
        if (node == null) return 0;
        int count = 0;
        if (set.contains(x - node.data)) count++;
        count += countPairsUtil(node.left
                , set, x);
        count += countPairsUtil(node.right, set, x);
        return count;
    }

    // Main method to test all the functions
    public static void main(String[] args) {
        // Example tree
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        // 1. Test Check if a Binary Tree is BST
        System.out.println("Is BST: " + isBST(root)); // Expected: true

        // 2. Test Count BST Nodes that Lie in a Given Range
        System.out.println("Count Nodes in Range [10, 22]: " + countNodesInRange(root, 10, 22)); // Expected: 5

        // 3. Test Searching in BST
        System.out.println("Search 10 in BST: " + (searchBST(root, 10) != null)); // Expected: true

        // 4. Test Lowest Common Ancestor in BST
        TreeNode p = root.left.right.left;  // Node with value 10
        TreeNode q = root.left.right.right; // Node with value 14
        System.out.println("Lowest Common Ancestor of 10 and 14: " + lowestCommonAncestor(root, p, q).data); // Expected: 12

        // 5. Test K'th Largest Element in BST
        System.out.println("K'th Largest Element (k=3): " + kthLargest(root, 3)); // Expected: 14

        // 6. Test Find the Node with Minimum Value in a Binary Search Tree
        System.out.println("Minimum Value in BST: " + findMin(root).data); // Expected: 4

        // 7. Test Inorder Successor in Binary Search Tree
        TreeNode node = root.left;  // Node with value 8
        System.out.println("Inorder Successor of 8: " + (inorderSuccessor(root, node) != null ? inorderSuccessor(root, node).data : "null")); // Expected: 10

        // 8. Test Find the Median of BST
        System.out.println("Median of BST: " + findMedian(root)); // Expected: 12.0

        // 9. Test Binary Tree to Binary Search Tree Conversion
        TreeNode binaryTree = new TreeNode(10);
        binaryTree.left = new TreeNode(30);
        binaryTree.right = new TreeNode(15);
        binaryTree.left.left = new TreeNode(20);
        binaryTree.right.right = new TreeNode(5);
        TreeNode bst = binaryTreeToBST(binaryTree);
        System.out.print("Converted Binary Tree to BST (Inorder): ");
        printInorder(bst); // Expected: 5 10 15 20 30

        // 10. Test Count Pairs from Two BSTs Whose Sum is Equal to a Given Value
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        System.out.println("Count of Pairs with Sum 25: " + countPairsWithSum(root, root2, 25)); // Expected: 1
    }

    // Helper function to print inorder traversal
    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
