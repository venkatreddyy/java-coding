package com.venkat.dsa.ds.tree;

import java.util.ArrayList;
import java.util.List;

// Class representing a node in an N-ary tree
class NaryTreeNode {
    int data;  // Data stored in the node
    List<NaryTreeNode> children;  // List of child nodes

    // Constructor to initialize the node
    public NaryTreeNode(int data) {
        this.data = data;  // Set the node's data
        this.children = new ArrayList<>();  // Initialize an empty list of children
    }

    // Method to add a child to this node
    public void addChild(NaryTreeNode child) {
        children.add(child);  // Add the child to the children list
    }
}

// Class representing the N-ary tree
class NaryTree {
    NaryTreeNode root;  // The root of the tree

    // Constructor to create a tree with a specified root node
    public NaryTree(NaryTreeNode root) {
        this.root = root;  // Set the root node
    }

    // Pre-order traversal: Visit root, then recursively visit each child
    public void preOrderTraversal(NaryTreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");  // Visit the node (print its data)

        // Recursively visit each child in the children list
        for (NaryTreeNode child : node.children) {
            preOrderTraversal(child);
        }
    }

    // Post-order traversal: Recursively visit each child, then visit root
    public void postOrderTraversal(NaryTreeNode node) {
        if (node == null) return;

        // Recursively visit each child in the children list
        for (NaryTreeNode child : node.children) {
            postOrderTraversal(child);
        }
        System.out.print(node.data + " ");  // Visit the node (print its data)
    }

    // Level-order traversal (Breadth-First Search)
    public void levelOrderTraversal(NaryTreeNode root) {
        if (root == null) return;

        List<NaryTreeNode> queue = new ArrayList<>();  // Initialize a queue for BFS
        queue.add(root);  // Start from the root node

        while (!queue.isEmpty()) {
            NaryTreeNode current = queue.remove(0);  // Dequeue a node
            System.out.print(current.data + " ");  // Visit the node (print its data)

            // Enqueue all children of the current node
            queue.addAll(current.children);
        }
    }

    public static void main(String[] args) {
        // Create the root node
        NaryTreeNode root = new NaryTreeNode(1);

        // Create child nodes
        NaryTreeNode child2 = new NaryTreeNode(2);
        NaryTreeNode child3 = new NaryTreeNode(3);
        NaryTreeNode child4 = new NaryTreeNode(4);

        // Add children to the root node
        root.addChild(child2);
        root.addChild(child3);
        root.addChild(child4);

        // Add children to child2 node
        NaryTreeNode child5 = new NaryTreeNode(5);
        NaryTreeNode child6 = new NaryTreeNode(6);
        child2.addChild(child5);
        child2.addChild(child6);

        // Create the N-ary tree with the root node
        NaryTree tree = new NaryTree(root);

        // Perform tree traversals
        System.out.print("Pre-order Traversal: ");
        tree.preOrderTraversal(tree.root);  // Expected Output: 1 2 5 6 3 4
        System.out.println();

        System.out.print("Post-order Traversal: ");
        tree.postOrderTraversal(tree.root);  // Expected Output: 5 6 2 3 4 1
        System.out.println();

        System.out.print("Level-order Traversal: ");
        tree.levelOrderTraversal(tree.root);  // Expected Output: 1 2 3 4 5 6
        System.out.println();
    }
}

