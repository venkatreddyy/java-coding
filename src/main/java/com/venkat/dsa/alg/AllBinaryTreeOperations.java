package com.venkat.dsa.alg;

import java.util.*;
/*
Level Difference: Calculate the difference between the sum of odd-level and even-level nodes.
Binary Search Tree: Insert, delete, and perform in-order traversal.
Convert to BST: Convert a binary tree to a binary search tree.
Leaf Level Check: Determine if all leaves are at the same level.
Identical Trees: Check if two binary trees are identical.
Maximum Width: Find the maximum width of the tree.
Largest Element: Find the largest element in the binary tree.
Maximum Depth: Calculate the height/depth of the tree.
Max Distance: Find the diameter (maximum distance between nodes).
Smallest Element: Find the smallest element in the binary tree.
Sum of Nodes: Sum all the nodes' values.
Count BSTs: Find the number of unique BSTs with N keys.
Binary Tree with Linked List: A binary tree using linked lists is included as a class.
Search Node: Search for a specific node in the binary tree.
You can copy this code into your favorite IDE, run, and test the functionalities.
 */
class AllBinaryTreeOperations {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    // 1) Difference between sum of odd level and even level nodes
    int getLevelDifference(Node node) {
        if (node == null)
            return 0;
        return node.data - getLevelDifference(node.left) - getLevelDifference(node.right);
    }

    // 2) Construct a Binary Search Tree and perform deletion and In-order traversal
    Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);
        if (data < node.data)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);
        return node;
    }

    Node deleteNode(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.data = minValue(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // 3) Convert Binary Tree to Binary Search Tree
    void storeInorder(Node node, ArrayList<Integer> nodes) {
        if (node == null)
            return;
        storeInorder(node.left, nodes);
        nodes.add(node.data);
        storeInorder(node.right, nodes);
    }

    void arrayToBST(ArrayList<Integer> nodes, Node root) {
        if (root == null)
            return;
        arrayToBST(nodes, root.left);
        root.data = nodes.remove(0);
        arrayToBST(nodes, root.right);
    }

    Node binaryTreeToBST(Node root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        storeInorder(root, nodes);
        Collections.sort(nodes);
        arrayToBST(nodes, root);
        return root;
    }

    // 4) Determine whether all leaves are at the same level
    boolean checkLeafLevel(Node node, int level, int[] leafLevel) {
        if (node == null)
            return true;
        if (node.left == null && node.right == null) {
            if (leafLevel[0] == 0) {
                leafLevel[0] = level;
                return true;
            }
            return (level == leafLevel[0]);
        }
        return checkLeafLevel(node.left, level + 1, leafLevel) && checkLeafLevel(node.right, level + 1, leafLevel);
    }

    boolean areLeavesAtSameLevel(Node node) {
        return checkLeafLevel(node, 0, new int[1]);
    }

    // 5) Determine whether two trees are identical
    boolean areIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 != null)
            return (root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
        return false;
    }

    // 6) Find the maximum width of a binary tree
    int maxWidth(Node root) {
        if (root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            maxWidth = Math.max(maxWidth, count);
            while (count-- > 0) {
                Node temp = queue.poll();
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return maxWidth;
    }

    // 7) Find the largest element in a Binary Tree
    int findLargest(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int result = node.data;
        int left = findLargest(node.left);
        int right = findLargest(node.right);
        return Math.max(result, Math.max(left, right));
    }

    // 8) Find the maximum depth or height of a tree
    int maxDepth(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    // 9) Find the nodes which are at the maximum distance in a Binary Tree
    int diameter(Node root) {
        if (root == null)
            return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    // 10) Find the smallest element in a tree
    int findSmallest(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;
        int result = node.data;
        int left = findSmallest(node.left);
        int right = findSmallest(node.right);
        return Math.min(result, Math.min(left, right));
    }

    // 11) Find the sum of all the nodes of a binary tree
    int sumOfNodes(Node node) {
        if (node == null)
            return 0;
        return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
    }

    // 12) Find the total number of possible Binary Search Trees with N keys
    int countBST(int N) {
        int[] count = new int[N + 1];
        count[0] = count[1] = 1;
        for (int i = 2; i <= N; i++) {
            count[i] = 0;
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[N];
    }

    // 13) Implement Binary Tree using Linked List
    class LinkedBinaryTree {
        Node root;
    }

    // 14) Search a node in a Binary Tree
    boolean searchNode(Node node, int key) {
        if (node == null)
            return false;
        if (node.data == key)
            return true;
        return searchNode(node.left, key) || searchNode(node.right, key);
    }

    // Driver code
    public static void main(String[] args) {
        AllBinaryTreeOperations tree = new AllBinaryTreeOperations();

        // Inserting nodes to create a binary tree
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(7);
        tree.root.right.right = new Node(20);

        System.out.println("1) Level Difference: " + tree.getLevelDifference(tree.root));
        System.out.println("2) Inorder Traversal of Binary Search Tree:");
        tree.inorder(tree.root);
        System.out.println("\n3) Convert Binary Tree to BST and print Inorder:");
        tree.binaryTreeToBST(tree.root);
        tree.inorder(tree.root);
        System.out.println("\n4) Are all leaves at the same level: " + tree.areLeavesAtSameLevel(tree.root));
        System.out.println("5) Are two trees identical: " + tree.areIdentical(tree.root, tree.root));
        System.out.println("6) Maximum width: " + tree.maxWidth(tree.root));
        System.out.println("7) Largest element: " + tree.findLargest(tree.root));
        System.out.println("8) Maximum depth: " + tree.maxDepth(tree.root));
        System.out.println("9) Diameter (max distance between nodes): " + tree.diameter(tree.root));
        System.out.println("10) Smallest element: " + tree.findSmallest(tree.root));
        System.out.println("11) Sum of all nodes: " + tree.sumOfNodes(tree.root));
        System.out.println("12) Total possible BSTs with 3 keys: " + tree.countBST(3));
        System.out.println("14) Is 7 present in the tree: " + tree.searchNode(tree.root, 7));
    }
}

