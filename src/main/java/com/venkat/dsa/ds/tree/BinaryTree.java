package com.venkat.dsa.ds.tree;

class BinaryTree {
    // Node class to represent each node in the tree
    class Node {
        int value;
        Node left, right;

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }

    // Root of the binary tree
    Node root;

    // Constructor to initialize an empty binary tree
    BinaryTree() {
        root = null;
    }

    // Insert a new node into the binary tree (level-order insertion)
    void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive function to insert a new value in the tree
    Node insertRec(Node root, int value) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // Insert in the left subtree if the value is smaller
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else {
            // Insert in the right subtree if the value is greater
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // In-order traversal: Left, Root, Right
    void inorder() {
        inorderRec(root);
    }

    // Recursive function for in-order traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Pre-order traversal: Root, Left, Right
    void preorder() {
        preorderRec(root);
    }

    // Recursive function for pre-order traversal
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal: Left, Right, Root
    void postorder() {
        postorderRec(root);
    }

    // Recursive function for post-order traversal
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Level-order traversal (Breadth-first traversal using a queue)
    void levelOrder() {
        if (root == null) {
            return;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.value + " ");

            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    // Main method to test the BinaryTree implementation
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print different types of traversals
        System.out.println("In-order traversal:");
        tree.inorder();  // Output: 20 30 40 50 60 70 80

        System.out.println("\n\nPre-order traversal:");
        tree.preorder();  // Output: 50 30 20 40 70 60 80

        System.out.println("\n\nPost-order traversal:");
        tree.postorder();  // Output: 20 40 30 60 80 70 50

        System.out.println("\n\nLevel-order traversal:");
        tree.levelOrder();  // Output: 50 30 70 20 40 60 80
    }
}

