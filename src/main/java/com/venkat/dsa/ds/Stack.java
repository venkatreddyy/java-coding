package com.venkat.dsa.ds;

/*
Basic Operations on a Stack:
Push: Add an element to the top of the stack.
Pop: Remove the element from the top of the stack.
Peek (or Top): View the element at the top of the stack without removing it.
isEmpty: Check if the stack is empty.
isFull: (for fixed-size stacks) Check if the stack is full.

Key Points:
A stack can be implemented using arrays or linked lists.
The most recent item pushed onto the stack is the one that will be popped first.
 */
public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Empty stack indicator
    }

    // Push method to add an element to the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
        } else {
            stackArray[++top] = value; // Increment top and add the value
            System.out.println("Pushed " + value + " onto the stack.");
        }
    }

    // Pop method to remove and return the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to pop.");
            return -1;
        } else {
            return stackArray[top--]; // Return the top element and decrement top
        }
    }

    // Peek method to return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Main method to test the stack
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack of size 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Top element is: " + stack.peek()); // Output: 50

        System.out.println("Popped element: " + stack.pop()); // Output: 50
        System.out.println("Popped element: " + stack.pop()); // Output: 40

        stack.push(60); // Add a new element
        System.out.println("Top element is: " + stack.peek()); // Output: 60
    }
}

