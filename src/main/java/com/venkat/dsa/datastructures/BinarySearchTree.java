package com.venkat.dsa.datastructures;

/*

Key Properties of a Binary Search Tree:
Left Subtree: Contains only nodes with values less than the node's value.
Right Subtree: Contains only nodes with values greater than the node's value.
No Duplicates: A typical BST does not allow duplicate values.
Recursive Structure: The left and right subtrees themselves are also binary search trees.


Common Operations on a Binary Search Tree:
Insertion: Adding a new node while maintaining the BST property.
Search: Finding a node with a given value.
Deletion: Removing a node and re-organizing the tree to maintain the BST property.
Traversal: Visiting nodes in a specific order (in-order, pre-order, post-order, level-order).

Time Complexity:
Insertion: O(log n) on average, O(n) in the worst case (unbalanced tree).
Search: O(log n) on average, O(n) in the worst case.
Deletion: O(log n) on average, O(n) in the worst case.
Key Takeaways:
A Binary Search Tree is efficient for search, insertion, and deletion operations.
It performs best when the tree is balanced, with an average time complexity of O(log n).
In a degenerate case (like a linked list), the time complexity can degrade to O(n).
For balancing the tree, advanced variations like AVL trees or Red-Black trees are often used.

 */
class BinarySearchTree {
    // Node class to represent each node in the tree
    class Node {
        int value;
        Node left, right;

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }

    // Root of the Binary Search Tree
    Node root;

    // Constructor to initialize an empty BST
    BinarySearchTree() {
        root = null;
    }

    // Insert a value into the BST
    void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive function to insert a new value in the BST
    Node insertRec(Node root, int value) {
        // Base case: If the tree is empty, create a new node
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // Recur down the tree to find the correct position
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        // Return the unchanged root node pointer
        return root;
    }

    // In-order traversal (Left -> Root -> Right)
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

    // Search a value in the BST
    boolean search(int value) {
        return searchRec(root, value);
    }

    // Recursive function to search a value
    boolean searchRec(Node root, int value) {
        // Base case: root is null or the value is present at root
        if (root == null || root.value == value) {
            return root != null;
        }

        // Value is greater than root's value
        if (value > root.value) {
            return searchRec(root.right, value);
        }

        // Value is smaller than root's value
        return searchRec(root.left, value);
    }

    // Delete a node with a given value
    void delete(int value) {
        root = deleteRec(root, value);
    }

    // Recursive function to delete a value
    Node deleteRec(Node root, int value) {
        // Base case: if the tree is empty
        if (root == null) {
            return root;
        }

        // Recur down the tree to find the node to delete
        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // Node to be deleted is found

            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    // Find the minimum value node in a subtree
    int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Print in-order traversal of the BST
        System.out.println("In-order traversal of the BST:");
        bst.inorder();  // Output: 20 30 40 50 60 70 80

        // Search for a node
        System.out.println("\n\nSearching for 40 in the BST: " + bst.search(40));  // Output: true
        System.out.println("Searching for 90 in the BST: " + bst.search(90));  // Output: false

        // Delete a node from the BST
        System.out.println("\nDeleting 20 from the BST:");
        bst.delete(20);
        bst.inorder();  // Output: 30 40 50 60 70 80
    }
}
