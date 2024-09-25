package com.venkat.dsa.ds.tree;

class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        int value;
        Node left, right, parent;
        boolean color;

        public Node(int value) {
            this.value = value;
            this.color = RED;  // New nodes are always red initially
        }
    }

    private Node root;

    // Left rotate the subtree rooted with x
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Right rotate the subtree rooted with y
    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        x.right = y;
        y.parent = x;
    }

    // Insert a node into the Red-Black Tree
    public void insert(int value) {
        Node newNode = new Node(value);
        root = bstInsert(root, newNode);
        fixInsert(newNode);  // Fix the Red-Black properties after insertion
    }

    // Standard BST insertion
    private Node bstInsert(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }
        if (newNode.value < root.value) {
            root.left = bstInsert(root.left, newNode);
            root.left.parent = root;
        } else if (newNode.value > root.value) {
            root.right = bstInsert(root.right, newNode);
            root.right.parent = root;
        }
        return root;
    }

    // Fix Red-Black Tree properties after insertion
    private void fixInsert(Node z) {
        while (z.parent != null && z.parent.color == RED) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;  // Uncle of z
                if (y != null && y.color == RED) {  // Case 1: Uncle is red
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {  // Case 2: z is right child
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = BLACK;  // Case 3: z is left child
                    z.parent.parent.color = RED;
                    rightRotate(z.parent.parent);
                }
            } else {  // Mirror case: z.parent is right child
                Node y = z.parent.parent.left;
                if (y != null && y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = BLACK;  // The root must always be black
    }

    // In-order traversal of the Red-Black Tree
    public void inOrder() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    // Main method to test the Red-Black Tree
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        // Inserting elements into the Red-Black Tree
        int[] elements = {20, 15, 25, 10, 5, 1, 30, 35};
        for (int element : elements) {
            tree.insert(element);
        }

        // In-order traversal
        System.out.println("In-order traversal of the Red-Black Tree:");
        tree.inOrder();  // Output should be in sorted order: 1 5 10 15 20 25 30 35
    }
}

