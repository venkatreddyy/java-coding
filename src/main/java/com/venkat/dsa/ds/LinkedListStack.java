package com.venkat.dsa.ds;

/*
Stacks can also be implemented using linked lists. Here,
there's no fixed size, and the stack can grow dynamically as elements are added.

Advantages of Linked List Stack:
Dynamic Size: Unlike the array-based stack, this stack can grow and shrink as needed.
Memory Efficient: Uses memory efficiently as nodes are created dynamically.
Stack Applications:
Expression Evaluation: Stacks are used to evaluate arithmetic expressions in postfix notation.
Recursive Function Calls: The system call stack tracks active function calls in recursive programming.
Backtracking Algorithms: Problems like maze-solving use stacks to explore paths and backtrack when necessary.
Would you like further examples or explanations of more advanced stack operations, like balanced parentheses or
postfix expression evaluation?.
 */
public class LinkedListStack {
    Node top;

    // Node class for the linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Push operation
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top; // Link the new node to the previous top
        top = newNode; // Set the new node as the top
        System.out.println("Pushed " + value + " onto the stack.");
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to pop.");
            return -1;
        } else {
            int poppedValue = top.data;
            top = top.next; // Move the top pointer to the next node
            return poppedValue;
        }
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return -1;
        } else {
            return top.data;
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == null);
    }

    // Main method to test the stack
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek()); // Output: 30

        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 20

        stack.push(40); // Add a new element
        System.out.println("Top element is: " + stack.peek()); // Output: 40
    }
}

