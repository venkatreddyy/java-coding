package com.venkat.challenges;

import java.util.Stack;

class Node1 {
    int data;
    Node1 left, right;

    public Node1(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class PostorderTraversal {

    // Method for postorder traversal using iteration and stack
    public static void postorderIterative(Node1 root) {
        if (root == null) {
            return; // Base case: if the tree is empty, do nothing
        }

        Stack<Node1> stack = new Stack<>();
        Stack<Node1> output = new Stack<>(); // To store the postorder sequence

        // Push the root node to the first stack
        stack.push(root);

        // Traverse the tree
        while (!stack.isEmpty()) {
            Node1 current = stack.pop();
            output.push(current); // Push the current node to the output stack

            // Push left and right children to the stack
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        // Print the nodes in postorder by popping from the output stack
        while (!output.isEmpty()) {
            System.out.print(output.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        // Create a binary tree
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);
        root.right.left = new Node1(6);
        root.right.right = new Node1(7);

        // Perform postorder traversal
        System.out.println("Postorder traversal (iterative):");
        postorderIterative(root);
    }
}

