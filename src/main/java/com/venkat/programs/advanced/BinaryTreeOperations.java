package com.venkat.programs.advanced;

public class BinaryTreeOperations {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    // 1) Calculate the Difference between the Sum of Odd Level and Even Level Nodes
    public int calculateLevelDifference(Node node, int level) {
        if (node == null) return 0;
        if (level % 2 == 1) return node.data - calculateLevelDifference(node.left, level + 1) - calculateLevelDifference(node.right, level + 1);
        return -node.data + calculateLevelDifference(node.left, level + 1) + calculateLevelDifference(node.right, level + 1);
    }

    // 2) Construct BST and Perform Deletion and In-order Traversal
    public Node insertBST(Node node, int data) {
        if (node == null) return new Node(data);
        if (data < node.data)
            node.left = insertBST(node.left, data);
        else
            node.right = insertBST(node.right, data);
        return node;
    }

    public Node deleteNode(Node root, int key) {
        if (root == null) return null;
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.data = findMin(root.right).data;
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // 3) Convert Binary Tree to Binary Search Tree
    public void convertToBST(Node node) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        storeInorder(node, list);
        java.util.Collections.sort(list);
        convertToBSTUtil(node, list.iterator());
    }

    private void storeInorder(Node node, java.util.List<Integer> list) {
        if (node == null) return;
        storeInorder(node.left, list);
        list.add(node.data);
        storeInorder(node.right, list);
    }

    private void convertToBSTUtil(Node node, java.util.Iterator<Integer> iter) {
        if (node == null) return;
        convertToBSTUtil(node.left, iter);
        node.data = iter.next();
        convertToBSTUtil(node.right, iter);
    }

    // 4) Determine whether all leaves are at the same level
    public boolean areLeavesAtSameLevel(Node node) {
        return checkLevel(node, 0, -1);
    }

    private boolean checkLevel(Node node, int level, int leafLevel) {
        if (node == null) return true;
        if (node.left == null && node.right == null) {
            if (leafLevel == -1) return true;
            return leafLevel == level;
        }
        return checkLevel(node.left, level + 1, leafLevel) && checkLevel(node.right, level + 1, leafLevel);
    }

    // 5) Determine whether two trees are identical
    public boolean areIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.data == root2.data) && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
    }

    // 6) Find the maximum width of a binary tree
    public int findMaxWidth(Node root) {
        if (root == null) return 0;
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            maxWidth = Math.max(maxWidth, count);
            for (int i = 0; i < count; i++) {
                Node temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
        return maxWidth;
    }

    // 7) Find the largest element in a binary tree
    public int findLargestElement(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        return Math.max(node.data, Math.max(findLargestElement(node.left), findLargestElement(node.right)));
    }

    // 8) Find the maximum depth or height of a binary tree
    public int findMaxDepth(Node node) {
        if (node == null) return 0;
        return Math.max(findMaxDepth(node.left), findMaxDepth(node.right)) + 1;
    }

    // 9) Find the nodes which are at the maximum distance in a binary tree
    public int findMaxDistance(Node root) {
        return findMaxDepth(root.left) + findMaxDepth(root.right);
    }

    // 10) Find the smallest element in a binary tree
    public int findSmallestElement(Node node) {
        if (node == null) return Integer.MAX_VALUE;
        return Math.min(node.data, Math.min(findSmallestElement(node.left), findSmallestElement(node.right)));
    }

    // 11) Find the sum of all the nodes of a binary tree
    public int sumOfNodes(Node node) {
        if (node == null) return 0;
        return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
    }

    // 12) Find the total number of possible Binary Search Trees with N keys (Catalan number)
    public int findNumOfBSTs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    // 13) Implement Binary Tree using Linked List (already done in this class)

    // 14) Search a node in a Binary Tree
    public boolean searchNode(Node node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        return searchNode(node.left, key) || searchNode(node.right, key);
    }

    // Example main method for testing the methods
    public static void main(String[] args) {
        var treeOps = new BinaryTreeOperations();
        treeOps.root = treeOps.insertBST(null, 10);
        treeOps.insertBST(treeOps.root, 5);
        treeOps.insertBST(treeOps.root, 15);

        System.out.println("Inorder traversal of BST:");
        treeOps.inorderTraversal(treeOps.root);

        System.out.println("\n\nMax width of tree: " + treeOps.findMaxWidth(treeOps.root));

        System.out.println("\nSum of all nodes: " + treeOps.sumOfNodes(treeOps.root));

        System.out.println("\nSearching for node with value 15: " + treeOps.searchNode(treeOps.root, 15));
    }
}

