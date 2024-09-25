package com.venkat.hundred;

import java.util.*;
/*
      1
     / \
    2   3
   / \
  4   5

 */
class BinaryTree {

    // Node definition for a Binary Tree
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root; // Root of the binary tree

    // 1. Inorder, Preorder, Postorder Traversal
    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left); // Visit left subtree
            System.out.print(node.data + " "); // Visit root
            inorderTraversal(node.right); // Visit right subtree
        }
    }

    public void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " "); // Visit root
            preorderTraversal(node.left); // Visit left subtree
            preorderTraversal(node.right); // Visit right subtree
        }
    }

    public void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left); // Visit left subtree
            postorderTraversal(node.right); // Visit right subtree
            System.out.print(node.data + " "); // Visit root
        }
    }

    // 2. Find the Height of a Binary Tree
    public int findHeight(Node node) {
        if (node == null) {
            return 0; // Base case: empty tree has height 0
        }
        int leftHeight = findHeight(node.left); // Height of left subtree
        int rightHeight = findHeight(node.right); // Height of right subtree
        return Math.max(leftHeight, rightHeight) + 1; // Return the larger height plus one (for the current node)
    }

    // 3. Check if a Binary Tree is Balanced
    public boolean isBalanced(Node node) {
        return checkBalance(node) != -1;
    }

    private int checkBalance(Node node) {
        if (node == null) return 0; // Base case

        int leftHeight = checkBalance(node.left); // Height of left subtree
        if (leftHeight == -1) return -1; // Unbalanced subtree

        int rightHeight = checkBalance(node.right); // Height of right subtree
        if (rightHeight == -1) return -1; // Unbalanced subtree

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // If current node is unbalanced

        return Math.max(leftHeight, rightHeight) + 1; // Return height of current node
    }

    // 4. Check if Two Binary Trees are Identical
    public boolean areIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true; // Both trees are empty
        if (node1 == null || node2 == null) return false; // One tree is empty and the other is not

        return node1.data == node2.data && // Check if data matches
                areIdentical(node1.left, node2.left) && // Check if left subtrees are identical
                areIdentical(node1.right, node2.right); // Check if right subtrees are identical
    }

    // 5. Find Lowest Common Ancestor in a Binary Tree
    public Node findLCA(Node root, int n1, int n2) {
        if (root == null) return null;

        if (root.data == n1 || root.data == n2) return root; // If root is one of n1 or n2

        Node leftLCA = findLCA(root.left, n1, n2); // Search in left subtree
        Node rightLCA = findLCA(root.right, n1, n2); // Search in right subtree

        if (leftLCA != null && rightLCA != null) return root; // If n1 is in one subtree and n2 is in another, return root

        return leftLCA != null ? leftLCA : rightLCA; // Else return the non-null child (left or right)
    }

    // 6. Level-order Traversal of a Binary Tree
 /*   public void levelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root); // Add root to the queue

        while (!queue.isEmpty()) {
            Node current = queue.poll(); // Dequeue the front node
            System.out.print(current.data + " "); // Print the data

            if (current.left != null) queue.add(current.left); // Add left child to the queue
            if (current.right != null) queue.add(current.right); // Add right child to the queue
        }
    }*/

    // 7. Convert Binary Tree to Doubly Linked List (Inorder Traversal)
    Node prev = null; // Previous node in inorder traversal
    Node head = null; // Head of the doubly linked list

    public void convertToDLL(Node root) {
        if (root == null) return;

        convertToDLL(root.left); // Traverse the left subtree

        if (prev == null) {
            head = root; // The leftmost node becomes the head of the doubly linked list
        } else {
            root.left = prev; // Connect current node to the previous node
            prev.right = root;
        }
        prev = root; // Move the prev pointer to the current node

        convertToDLL(root.right); // Traverse the right subtree
    }

    // 8. Find the Diameter of a Binary Tree
    public int diameter(Node root) {
        int[] diameter = new int[1]; // Store the diameter
        findDiameter(root, diameter);
        return diameter[0];
    }

    private int findDiameter(Node node, int[] diameter) {
        if (node == null) return 0;

        int leftHeight = findDiameter(node.left, diameter); // Height of left subtree
        int rightHeight = findDiameter(node.right, diameter); // Height of right subtree

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight); // Update the diameter

        return Math.max(leftHeight, rightHeight) + 1; // Return the height of the current node
    }

    // 9. Check if a Binary Tree is Symmetric
    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(Node left, Node right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.data == right.data) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    // 10. Find the Kth Smallest/Largest Element in a Binary Search Tree (BST)
    int count = 0;

    public int findKthSmallest(Node root, int k) {
        if (root == null) return -1;

        int left = findKthSmallest(root.left, k);

        if (left != -1) return left; // If Kth smallest is found in left subtree, return it

        count++;
        if (count == k) return root.data; // If current node is the Kth smallest, return it

        return findKthSmallest(root.right, k); // Else continue to search in right subtree
    }

    // 11. Serialize and Deserialize a Binary Tree
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
        } else {
            sb.append(node.data).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

/*    public Node deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }*/

    private Node deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("null")) return null;

        Node node = new Node(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    // 12. Count the Number of Leaf Nodes in a Binary Tree
    public int countLeafNodes(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1; // Leaf node
        return countLeafNodes(node.left) + countLeafNodes(node.right); // Sum of leaf nodes in left and right subtrees
    }

    // 13. Find the Maximum Path Sum in a Binary Tree
    public int maxPathSum(Node root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        findMaxPathSum(root, maxSum);
        return maxSum[0];
    }

    private int findMaxPathSum(Node node, int[] maxSum) {
        if (node == null) return 0;

        int leftSum = Math.max(0, findMaxPathSum(node.left, maxSum)); // Ignore paths with negative sum
        int rightSum = Math.max(0, findMaxPathSum(node.right, maxSum)); // Ignore paths with negative sum

        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + node.data); // Update the global maximum path sum

        return node.data + Math.max(leftSum, rightSum); // Return the maximum path sum from the current node
    }

    // Helper function to build a sample binary tree
    public Node createSampleTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.createSampleTree();

        // 1. Traversals
        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal(tree.root);  // Output: 4 2 5 1 6 3 7
        System.out.println();

        System.out.print("Preorder Traversal: ");
        tree.preorderTraversal(tree.root);  // Output: 1 2 4 5 3 6 7
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postorderTraversal(tree.root);  // Output: 4 5 2 6 7 3 1
        System.out.println();

        // 2. Find Height
        System.out.println("Height of the Tree: " + tree.findHeight(tree.root));  // Output: 3

        // 3. Check if Tree is Balanced
        System.out.println("Is Balanced: " + tree.isBalanced(tree.root));  // Output: true

        // 4. Check if Two Trees are Identical
        BinaryTree tree2 = new BinaryTree();
        tree2.root = tree.createSampleTree();
        System.out.println("Are Identical: " + tree.areIdentical(tree.root, tree2.root));  // Output: true

        // 5. Find LCA
        System.out.println("Lowest Common Ancestor of 4 and 5: " + tree.findLCA(tree.root, 4, 5).data);  // Output: 2

        // 6. Level-order Traversal
       /* System.out.print("Level-order Traversal: ");
        tree.levelOrderTraversal(tree.root);  // Output: 1 2 3 4 5 6 7
        System.out.println();*/

        // 7. Convert Binary Tree to Doubly Linked List
        tree.convertToDLL(tree.root);
        System.out.print("Doubly Linked List: ");
        Node dllHead = tree.head;
        while (dllHead != null) {
            System.out.print(dllHead.data + " ");
            dllHead = dllHead.right;
        }
        System.out.println();  // Output: 4 2 5 1 6 3 7

        // 8. Find Diameter
        System.out.println("Diameter of the Tree: " + tree.diameter(tree.root));  // Output: 4

        // 9. Check if Tree is Symmetric
        System.out.println("Is Symmetric: " + tree.isSymmetric(tree.root));  // Output: false

        // 10. Find Kth Smallest Element in BST
        // (Assume the sample tree is a BST for testing purposes)
        System.out.println("2nd Smallest Element: " + tree.findKthSmallest(tree.root, 2));  // Output: 2

        // 11. Serialize and Deserialize
        String serializedTree = tree.serialize(tree.root);
     /*   System.out.println("Serialized Tree: " + serializedTree);
        Node deserializedTree = tree.deserialize(serializedTree);
        System.out.print("Deserialized Tree (Inorder Traversal): ");
        tree.inorderTraversal(deserializedTree);  // Output: 4 2 5 1 6 3 7*/
        System.out.println();

        // 12. Count Leaf Nodes
        System.out.println("Number of Leaf Nodes: " + tree.countLeafNodes(tree.root));  // Output: 4

        // 13. Maximum Path Sum
        System.out.println("Maximum Path Sum: " + tree.maxPathSum(tree.root));  // Output: 18
    }
}

