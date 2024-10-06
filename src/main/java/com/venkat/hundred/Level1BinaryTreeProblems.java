package com.venkat.hundred;

/*
Explanation of the Test Cases in main:
Height of the Tree: Tests the height of a binary tree.

Output: 3
Identical Trees: Compares two binary trees to check if they are identical.

Output: true
Mirror Tree: Creates a mirror image of the binary tree.

Output: 1 (Root of the tree remains unchanged)
Symmetric Tree: Checks if a binary tree is symmetric (i.e., a mirror of itself).

Output: true
Diameter of the Tree: Computes the diameter of the binary tree (longest path between two nodes).

Output: 4
Check for Balanced Tree: Tests if the binary tree is balanced.

Output: true
Children Sum Property: Tests if every node’s value is equal to the sum of its children’s values.

Output: true
Check for Binary Search Tree (BST): Verifies if a binary tree is a valid BST.

Output: true
Convert Array to BST: Converts a sorted array into a balanced binary search tree (BST).

Output: 4 (Root of the balanced BST)
Largest Value in Each Level: Finds the largest value at each level of the binary tree.

Output: [1, 3, 7]
Maximum GCD of Siblings: Finds the maximum GCD between any siblings in the tree.

Output: 1
Zigzag Traversal: Performs a zigzag (spiral) level-order traversal of the tree.

Output: [[1], [3, 2], [4, 5, 6, 7]]

 */
// TreeNode class representing a node of the binary tree
class TreeNode {
    int data; // Data field to store the value of the node
    TreeNode left, right; // Left and right children of the current node

    // Constructor to initialize the node with data
    public TreeNode(int data) {
        this.data = data; // Assign the data
        left = right = null; // Initialize left and right children as null
    }
}

public class Level1BinaryTreeProblems {

    // 1. Height of a Binary Tree
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static int height(TreeNode root) {
        if (root == null) return 0; // Base case: if tree is empty, height is 0
        return 1 + Math.max(height(root.left), height(root.right)); // Return 1 + max height of left and right subtrees
    }

    // 2. Determine if Two Trees are Identical
    // Time Complexity: O(n), where n is the number of nodes in both trees
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static boolean areIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true; // Both trees are empty
        if (root1 == null || root2 == null) return false; // One tree is empty, the other is not
        // Check if current nodes' data are equal and recursively check the left and right subtrees
        return (root1.data == root2.data) && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
    }

    // 3. Mirror Tree
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null; // Base case: if tree is empty
        // Recursively mirror the left and right subtrees
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        // Swap left and right subtrees
        root.left = right;
        root.right = left;
        return root; // Return the root of the mirrored tree
    }

    // 4. Symmetric Tree
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root); // A tree is symmetric if it is a mirror of itself
    }

    // Helper function to check if two subtrees are mirror images of each other
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true; // Both subtrees are empty
        if (t1 == null || t2 == null) return false; // One subtree is empty, the other is not
        // Check if the current nodes are equal and recursively check left-right and right-left subtrees
        return (t1.data == t2.data) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    // 5. Diameter of a Tree
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static int diameter(TreeNode root) {
        int[] diameter = new int[1]; // Initialize an array to store the maximum diameter
        heightWithDiameter(root, diameter); // Helper function to calculate both height and diameter
        return diameter[0]; // Return the maximum diameter found
    }

    // Helper function to calculate both height and diameter of the tree
    private static int heightWithDiameter(TreeNode node, int[] diameter) {
        if (node == null) return 0; // Base case: height of an empty tree is 0
        int leftHeight = heightWithDiameter(node.left, diameter); // Calculate height of left subtree
        int rightHeight = heightWithDiameter(node.right, diameter); // Calculate height of right subtree
        // Update the diameter if the current path through the node is the longest found so far
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight); // Return the height of the current node
    }

    // 6. Check for Balanced Tree
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static boolean isBalanced(TreeNode root) {
        return heightBalanced(root) != -1; // If the helper function returns -1, tree is unbalanced
    }

    // Helper function to check if the tree is height-balanced
    private static int heightBalanced(TreeNode node) {
        if (node == null) return 0; // Base case: height of an empty tree is 0
        int leftHeight = heightBalanced(node.left); // Calculate the height of the left subtree
        if (leftHeight == -1) return -1; // Left subtree is unbalanced
        int rightHeight = heightBalanced(node.right); // Calculate the height of the right subtree
        if (rightHeight == -1) return -1; // Right subtree is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Current node is unbalanced
        return 1 + Math.max(leftHeight, rightHeight); // Return the height of the current node
    }

    // 7. Children Sum Parent
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static boolean childrenSum(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return true; // Base case: leaf node or null
        int sum = 0; // Initialize sum to store the sum of left and right children
        if (node.left != null) sum += node.left.data; // Add left child's data to sum
        if (node.right != null) sum += node.right.data; // Add right child's data to sum
        // Check if node's data equals the sum of its children's data, and recursively check subtrees
        return (node.data == sum) && childrenSum(node.left) && childrenSum(node.right);
    }

    // 8. Check for Binary Search Tree (BST)
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static boolean isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE); // Helper function with valid range
    }

    // Helper function to check if a tree is a valid BST
    private static boolean isBSTUtil(TreeNode node, int min, int max) {
        if (node == null) return true; // Base case: an empty tree is a valid BST
        // Check if node violates the BST property
        if (node.data <= min || node.data >= max) return false;
        // Recursively check left and right subtrees with updated ranges
        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }

    // 9. Convert Array to BST
    // Time Complexity: O(n), where n is the number of elements in the array
    // Space Complexity: O(h), where h is the height of the tree (recursion depth)
    public static TreeNode arrayToBST(int[] arr) {
        return arrayToBSTUtil(arr, 0, arr.length - 1); // Helper function call
    }

    // Helper function to recursively build a BST from a sorted array
    private static TreeNode arrayToBSTUtil(int[] arr, int start, int end) {
        if (start > end) return null; // Base case: no elements left in the array
        int mid = (start + end) / 2; // Find the middle element
        TreeNode node = new TreeNode(arr[mid]); // Create a new node with the middle element
        node.left = arrayToBSTUtil(arr, start, mid - 1); // Recursively construct the left subtree
        node.right = arrayToBSTUtil(arr, mid + 1, end); // Recursively construct the right subtree
        return node; // Return the constructed node
    }

    // 10. Largest Value in Each Level of Binary Tree
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(n), for the queue used in BFS
/*    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // List to store the largest values in each level
        if (root == null) return result; // If the tree is empty, return an empty list
        Queue<TreeNode> queue = new LinkedList<>(); // Initialize a queue for level-order traversal
        queue.add(root); // Start with the root node
        while (!queue.isEmpty()) { // Continue until the queue is empty
            int size = queue.size(); // Number of nodes at the current level
            int max = Integer.MIN_VALUE; // Initialize max for the current level
            for (int i = 0; i < size; i++) { // Iterate through nodes at the current level
                TreeNode node = queue.poll(); // Remove the node from the queue
                max = Math.max(max, node.data); // Update the max value for this level
                if (node.left != null) queue.add(node.left); // Add left child to the queue
                if (node.right != null) queue.add(node.right); // Add right child to the queue
            }
            result.add(max); // Add the max value of the current level to the result list
        }
        return result; // Return the list of largest values
    }*/

    // 11. Maximum GCD of Siblings in a Binary Tree
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree (recursion stack)
    public static int maxGcdOfSiblings(TreeNode root) {
        if (root == null) return 0; // If the tree is empty, return 0
        int[] maxGcd = new int[1]; // To store the maximum GCD
        maxGcdUtil(root, maxGcd); // Call helper function to calculate GCD
        return maxGcd[0]; // Return the maximum GCD found
    }

    // Helper function to calculate GCD of siblings
    private static void maxGcdUtil(TreeNode node, int[] maxGcd) {
        if (node == null || node.left == null || node.right == null) return; // Skip if there are no siblings
        int gcdValue = gcd(node.left.data, node.right.data); // Calculate GCD of left and right children
        maxGcd[0] = Math.max(maxGcd[0], gcdValue); // Update maximum GCD if necessary
        maxGcdUtil(node.left, maxGcd); // Recursively check left subtree
        maxGcdUtil(node.right, maxGcd); // Recursively check right subtree
    }

    // Helper function to calculate GCD of two numbers
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b); // Euclidean algorithm to calculate GCD
    }

    // 12. Zigzag Tree Traversal (Level order in a zigzag manner)
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(n), for the queue used in BFS
/*    public static List<List<Integer>> zigzagTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // List to store the traversal result
        if (root == null) return result; // If the tree is empty, return an empty list
        Queue<TreeNode> queue = new LinkedList<>(); // Queue for level-order traversal
        queue.add(root); // Start with the root node
        boolean leftToRight = true; // Flag to track direction of zigzag traversal
        while (!queue.isEmpty()) { // Continue until the queue is empty
            int size = queue.size(); // Number of nodes at the current level
            List<Integer> level = new LinkedList<>(); // List to store nodes at the current level
            for (int i = 0; i < size; i++) { // Process each node at the current level
                TreeNode node = queue.poll(); // Remove the node from the queue
                if (leftToRight) level.add(node.data); // If left to right, add node's data normally
                else level.add(0, node.data); // If right to left, add node's data at the front
                if (node.left != null) queue.add(node.left); // Add left child to the queue
                if (node.right != null) queue.add(node.right); // Add right child to the queue
            }
            result.add(level); // Add the current level to the result list
            leftToRight = !leftToRight; // Toggle the direction for the next level
        }
        return result; // Return the zigzag traversal result
    }*/

    // Main method to test the functions
    public static void main(String[] args) {
        // Example binary tree construction:
        //           1
        //         /   \
        //        2     3
        //       / \   / \
        //      4   5 6   7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Test case 1: Height of the tree
        System.out.println("Height of the tree: " + height(root)); // Output: 3

        // Test case 2: Identical trees
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);
        System.out.println("Are trees identical? " + areIdentical(root, root2)); // Output: true

        // Test case 3: Mirror tree
        TreeNode mirrored = mirrorTree(root);
        System.out.println("Mirrored tree root: " + mirrored.data); // Output: 1 (Root remains the same)

        // Test case 4: Symmetric tree
        TreeNode symmetricRoot = new TreeNode(1);
        symmetricRoot.left = new TreeNode(2);
        symmetricRoot.right = new TreeNode(2);
        symmetricRoot.left.left = new TreeNode(3);
        symmetricRoot.right.right = new TreeNode(3);
        System.out.println("Is tree symmetric? " + isSymmetric(symmetricRoot)); // Output: true

        // Test case 5: Diameter of the tree
        System.out.println("Diameter of the tree: " + diameter(root)); // Output: 4

        // Test case 6: Check if the tree is balanced
        System.out.println("Is tree balanced? " + isBalanced(root)); // Output: true

        // Test case 7: Children sum property
        TreeNode childrenSumTree = new TreeNode(10);
        childrenSumTree.left = new TreeNode(3);
        childrenSumTree.right = new TreeNode(7);
        System.out.println("Does the tree follow children sum property? " + childrenSum(childrenSumTree)); // Output: true

        // Test case 8: Check if the tree is a BST
        TreeNode bstRoot = new TreeNode(10);
        bstRoot.left = new TreeNode(5);
        bstRoot.right = new TreeNode(20);
        bstRoot.left.left = new TreeNode(1);
        bstRoot.left.right = new TreeNode(7);
        bstRoot.right.left = new TreeNode(15);
        System.out.println("Is the tree a BST? " + isBST(bstRoot)); // Output: true

        // Test case 9: Convert array to BST
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bstFromArray = arrayToBST(arr);
        System.out.println("BST root from array: " + bstFromArray.data); // Output: 4

        // Test case 10: Largest value in each level
      //  List<Integer> largestValues = largestValues(root);
      //  System.out.println("Largest values at each level: " + largestValues); // Output: [1, 3, 7]

        // Test case 11: Maximum GCD of siblings
        System.out.println("Maximum GCD of siblings: " + maxGcdOfSiblings(root)); // Output: 1

        // Test case 12: Zigzag traversal
     //   List<List<Integer>> zigzag = zigzagTraversal(root);
     //   System.out.println("Zigzag traversal: " + zigzag); // Output: [[1], [3, 2], [4, 5, 6, 7]]
    }
}
