package com.venkat.programs.basic;

import java.util.*;

class BinaryTreeNode {
    int data; // Data field for each node
    BinaryTreeNode left, right; // Left and right child nodes

    // Constructor to initialize the node
    BinaryTreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeSolutions {

    // 1. Calculate the difference between the sum of the odd level and even level nodes of a binary tree
    // Time Complexity: O(n) - We traverse each node once
    // Space Complexity: O(h) - Where h is the height of the tree (recursion stack)
    public static int getLevelDifference(BinaryTreeNode root) {
        return getLevelDifferenceUtil(root, 1); // Start from level 1 (odd level)
    }

    private static int getLevelDifferenceUtil(BinaryTreeNode node, int level) {
        if (node == null) return 0; // Base case: return 0 if the node is null

        // If it's an odd level, add the node value
        if (level % 2 != 0) return node.data + getLevelDifferenceUtil(node.left, level + 1) + getLevelDifferenceUtil(node.right, level + 1);
            // If it's an even level, subtract the node value
        else return -node.data + getLevelDifferenceUtil(node.left, level + 1) + getLevelDifferenceUtil(node.right, level + 1);
    }

    // 2. Insert a node in a Binary Search Tree (BST), delete a node, and perform inorder traversal
    // Time Complexity for Insert/Delete: O(h), where h is the height of the BST
    // Inorder Traversal: O(n), where n is the number of nodes
    // Space Complexity: O(h) for recursion stack during insert/delete, O(n) for inorder traversal

    // Insert a node in the BST
    public static BinaryTreeNode insertBST(BinaryTreeNode root, int key) {
        if (root == null)
            return new BinaryTreeNode(key); // If the root is null, create a new node

        if (key < root.data) // If key is less, insert in the left subtree
            root.left = insertBST(root.left, key);
        else if (key > root.data) // If key is greater, insert in the right subtree
            root.right = insertBST(root.right, key);

        return root; // Return the modified root node
    }

    // Inorder Traversal of the BST
    public static void inorderTraversal(BinaryTreeNode root) {
        if (root == null) return; // Base case: return if the node is null
        inorderTraversal(root.left); // Recursively visit the left subtree
        System.out.print(root.data + " "); // Print the current node
        inorderTraversal(root.right); // Recursively visit the right subtree
    }

    // Delete a node in the BST
    public static BinaryTreeNode deleteBST(BinaryTreeNode root, int key) {
        if (root == null) return null; // If the node is null, return null

        // Traverse to the correct node
        if (key < root.data)
            root.left = deleteBST(root.left, key); // Key is in the left subtree
        else if
        (key > root.data)
            root.right = deleteBST(root.right, key); // Key is in the right subtree
        else {
            // Node to be deleted has one or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node has two children, find the inorder successor
            root.data = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteBST(root.right, root.data);
        }
        return root; // Return the modified root node
    }

    // Find the minimum value node in the BST
    private static int minValue(BinaryTreeNode root) {
        int minVal = root.data; // Store the root data
        while (root.left != null) { // Traverse to the leftmost node
            minVal = root.left.data;
            root = root.left;
        }
        return minVal; // Return the minimum value
    }

    // 3. Convert a Binary Tree to Binary Search Tree
    // Time Complexity: O(n log n), because we sort the elements
    // Space Complexity: O(n) for storing the elements
    public static BinaryTreeNode binaryTreeToBST(BinaryTreeNode root) {
        List<Integer> nodes = new ArrayList<>(); // List to store nodes in inorder
        storeInorder(root, nodes); // Store inorder traversal of the binary tree
        Collections.sort(nodes); // Sort the list to convert to BST
        return buildBSTFromSorted(nodes, 0, nodes.size() - 1); // Build a BST from the sorted list
    }

    // Store inorder traversal of the tree in a list
    private static void storeInorder(BinaryTreeNode node, List<Integer> nodes) {
        if (node == null) return; // Base case: return if the node is null
        storeInorder(node.left, nodes); // Recursively visit the left subtree
        nodes.add(node.data); // Add the current node to the list
        storeInorder(node.right, nodes); // Recursively visit the right subtree
    }

    // Build a BST from a sorted list
    private static BinaryTreeNode buildBSTFromSorted(List<Integer> nodes, int start, int end) {
        if (start > end) return null; // Base case: return null when start exceeds end
        int mid = start + (end - start) / 2; // Find the middle element
        BinaryTreeNode node = new BinaryTreeNode(nodes.get(mid)); // Create a new node with the middle element
        node.left = buildBSTFromSorted(nodes, start, mid - 1); // Recursively build the left subtree
        node.right = buildBSTFromSorted(nodes, mid + 1, end); // Recursively build the right subtree
        return node; // Return the root of the newly created subtree
    }

    // 4. Check if all leaves are at the same level
    // Time Complexity: O(n), where n is the number of nodes
    // Space Complexity: O(h), where h is the height of the tree (for recursion)
    public static boolean checkLeavesAtSameLevel(BinaryTreeNode root) {
        return checkLeavesUtil(root, 0, new HashSet<>()); // Start checking from level 0
    }

    private static boolean checkLeavesUtil(BinaryTreeNode node, int level, Set<Integer> leafLevels) {
        if (node == null) return true; // Base case: null node returns true

        // If the node is a leaf, add the level to the set
        if (node.left == null && node.right == null) {
            leafLevels.add(level);
            return leafLevels.size() == 1; // If all leaves are at the same level, size will be 1
        }

        // Check the left and right subtrees
        return checkLeavesUtil(node.left, level + 1, leafLevels) && checkLeavesUtil(node.right, level + 1, leafLevels);
    }

    // 5. Check if two trees are identical
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), for recursion stack
    public static boolean areIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) return true; // Both trees are empty, they are identical
        if (root1 == null || root2 == null) return false; // One tree is empty, they are not identical
        return root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right); // Check the data and recurse
    }

    // 6. Find the maximum width of a binary tree
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(n), because we use a queue to perform level-order traversal
    public static int getMaxWidth(BinaryTreeNode root) {
        if (root == null) return 0; // If the tree is empty, width is 0
        Queue<BinaryTreeNode> queue = new LinkedList<>(); // Queue for level-order traversal
        queue.add(root); // Add the root node
        int maxWidth = 0; // Initialize max width

        // Perform level-order traversal
        while (!queue.isEmpty()) {
            int count = queue.size(); // Get the number of nodes at the current level
            maxWidth = Math.max(maxWidth, count); // Update max width
            for (int i = 0; i < count; i++) {
                BinaryTreeNode temp = queue.poll(); // Dequeue the current node
                if (temp.left != null) queue.add(temp.left); // Enqueue left child
                if (temp.right != null) queue.add(temp.right); // Enqueue right child
            }
        }
        return maxWidth; // Return the maximum width
    }

    // 7. Find the largest element in a binary tree
    // Time Complexity: O(n), where n is the number of nodes
    // Space Complexity: O(h), for recursion stack
    public static int findLargest(BinaryTreeNode root) {
        if (root == null) return Integer.MIN_VALUE; // Base case: return minimum value if the tree is empty

        int result = root.data; // Store the current node's value
        int leftResult = findLargest(root.left); // Recursively find the largest in the left subtree
        int rightResult = findLargest(root.right); // Recursively find the largest in the right subtree

        return Math.max(result, Math.max(leftResult, rightResult)); // Return the maximum of all
    }

    // 8. Find the maximum depth or height of a tree
    // Time Complexity: O(n), where n is the number of nodes
    // Space Complexity: O(h), for recursion stack
    public static int findMaxDepth(BinaryTreeNode root) {
        if (root == null) return 0; // Base case: return 0 if the tree is empty
        return 1 + Math.max(findMaxDepth(root.left), findMaxDepth(root.right)); // Return 1 + max of left and right subtree depths
    }

    // 9. Find nodes at maximum distance in a binary tree (diameter)
    // Time Complexity: O(n), where n is the number of nodes
    // Space Complexity: O(h), for recursion stack
    public static int findMaxDistance(BinaryTreeNode root) {
        return findDiameter(root).diameter; // Find and return the diameter
    }

    // Helper class to store height and diameter
    private static class DiameterInfo {
        int height; // Height of the subtree
        int diameter; // Diameter of the subtree

        public DiameterInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    // Function to calculate diameter
    private static DiameterInfo findDiameter(BinaryTreeNode root) {
        if (root == null) return new DiameterInfo(0, 0); // Base case: return 0 for height and diameter if the tree is empty

        DiameterInfo left = findDiameter(root.left); // Recursively find left subtree diameter
        DiameterInfo right = findDiameter(root.right); // Recursively find right subtree diameter

        int height = 1 + Math.max(left.height, right.height); // Height of current node is 1 + max of left and right heights
        int diameter = Math.max(left.height + right.height, Math.max(left.diameter, right.diameter)); // Diameter is max of left + right heights or left/right diameters

        return new DiameterInfo(height, diameter); // Return the height and diameter of the current node
    }

    // 10. Find the smallest element in a binary tree
    // Time Complexity: O(n), where n is the number of nodes
    // Space Complexity: O(h), for recursion stack
    public static int findSmallest(BinaryTreeNode root) {
        if (root == null) return Integer.MAX_VALUE; // Base case: return max value if the tree is empty

        int result = root.data; // Store the current node's value
        int leftResult = findSmallest(root.left); // Recursively find the smallest in the left subtree
        int rightResult = findSmallest(root.right); // Recursively find the smallest in the right subtree

        return Math.min(result, Math.min(leftResult, rightResult)); // Return the minimum of all
    }

    // 11. Find the sum of all nodes in a binary tree
    // Time Complexity: O(n), where n is the number of nodes
    // Space Complexity: O(h), for recursion stack
    public static int findSumOfNodes(BinaryTreeNode root) {
        if (root == null) return 0; // Base case: return 0 if the tree is empty
        return root.data + findSumOfNodes(root.left) + findSumOfNodes(root.right); // Return the sum of current node, left subtree, and right subtree
    }

    // 12. Total number of possible BSTs with N keys (Catalan number)
    // Time Complexity: O(n^2), as we calculate the nth Catalan number iteratively
    // Space Complexity: O(n), for storing the catalan numbers
    public static int countBSTs(int N) {
        int[] catalan = new int[N + 1]; // Array to store catalan numbers
        catalan[0] = catalan[1] = 1; // Base cases

        for (int i = 2; i <= N; i++) { // Calculate each catalan number from 2 to N
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1]; // Use the recursive formula
            }
        }
        return catalan[N]; // Return the nth catalan number
    }

    // 13. Implement Binary Tree using Linked List
    // Time Complexity: O(1) for node creation
    // Space Complexity: O(1) for creating nodes
    public static BinaryTreeNode createBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode(1); // Create the root node
        root.left = new BinaryTreeNode(2); // Create left child
        root.right = new BinaryTreeNode(3); // Create right child
        root.left.left = new BinaryTreeNode(4); // Create left-left child
        root.left.right = new BinaryTreeNode(5); // Create left-right child
        return root; // Return the root of the binary tree
    }

    // 14. Search a node in a Binary Tree
    // Time Complexity: O(n), where n is the number of nodes
    // Space Complexity: O(h), for recursion stack
    public static boolean searchNode(BinaryTreeNode root, int key) {
        if (root == null) return false; // Base case: return false if tree is empty
        if (root.data == key) return true; // If the current node matches the key, return true
        return searchNode(root.left, key) || searchNode(root.right, key); // Recursively search in left and right subtrees
    }

    // Main method to test all the problems
    public static void main(String[] args) {
        BinaryTreeNode root = createBinaryTree(); // Create a sample binary tree

        // 1. Difference between odd and even level nodes
        System.out.println("Difference between odd and even level nodes: " + getLevelDifference(root));

        // 2. BST Insertion, Deletion, and Inorder Traversal
        BinaryTreeNode bstRoot = null;
        bstRoot = insertBST(bstRoot, 50); // Insert node 50
        bstRoot = insertBST(bstRoot, 30); // Insert node 30
        bstRoot = insertBST(bstRoot, 70); // Insert node 70
        System.out.print("Inorder Traversal of BST: ");
        inorderTraversal(bstRoot); // Expected output: 30 50 70
        System.out.println();
        bstRoot = deleteBST(bstRoot, 50); // Delete node 50
        System.out.print("Inorder Traversal after Deletion: ");
        inorderTraversal(bstRoot); // Expected output: 30 70
        System.out.println();

        // 3. Binary Tree to Binary Search Tree Conversion
        BinaryTreeNode convertedBST = binaryTreeToBST(root); // Convert binary tree to BST
        System.out.print("Inorder traversal of converted BST: ");
        inorderTraversal(convertedBST); // Expected output: 1 2 3 4 5
        System.out.println();

        // 4. Check if leaves are at the same level
        System.out.println("All leaves at same level: " + checkLeavesAtSameLevel(root)); // Expected output: true

        // 5. Check if two trees are identical
        BinaryTreeNode root2 = createBinaryTree(); // Create another tree identical to root
        System.out.println("Are the two trees identical? " + areIdentical(root, root2)); // Expected output: true

        // 6. Maximum width of the tree
        System.out.println("Maximum width of the tree: " + getMaxWidth(root)); // Expected output: 2

        // 7. Largest element in the tree
        System.out.println("Largest element in the tree: " + findLargest(root)); // Expected output: 5

        // 8. Maximum depth or height of the tree
        System.out.println("Maximum depth of the tree: " + findMaxDepth(root)); // Expected output: 3

        // 9. Maximum distance between nodes in the tree
        System.out.println("Maximum distance between nodes in the tree: " + findMaxDistance(root)); // Expected output: 4

        // 10. Smallest element in the tree
        System.out.println("Smallest element in the tree: " + findSmallest(root)); // Expected output: 1

        // 11. Sum of all nodes in the tree
        System.out.println("Sum of all nodes in the tree: " + findSumOfNodes(root)); // Expected output: 15

        // 12. Total number of possible BSTs with N keys
        System.out.println("Total number of possible BSTs with 3 keys: " + countBSTs(3)); // Expected output: 5

        // 13. Search a node in the tree
        System.out.println("Search 4 in the tree: " + searchNode(root, 4)); // Expected output: true
    }
}

