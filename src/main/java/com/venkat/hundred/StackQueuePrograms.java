
package com.venkat.hundred;

import java.util.Stack;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class StackQueuePrograms {

    // 1. Implement Stack using an Array
    static class StackUsingArray {
        int[] stack;
        int top;
        int maxSize;

        // Constructor to initialize stack
        StackUsingArray(int size) {
            maxSize = size;
            stack = new int[maxSize];
            top = -1;  // Top starts at -1, indicating an empty stack
        }

        // Push element onto stack
        public void push(int data) {
            if (top == maxSize - 1) {
                System.out.println("Stack Overflow");
            } else {
                stack[++top] = data;  // Increment top and insert data
            }
        }

        // Pop element from stack
        public int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return stack[top--];  // Return top element and decrement top
        }

        // Peek the top element of the stack
        public int peek() {
            if (top == -1) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return stack[top];
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return top == -1;
        }
    }

    // 2. Implement Queue using a Linked List
    static class QueueUsingLinkedList {
        Node front, rear;

        // Node class
        class Node {
            int data;
            Node next;

            // Constructor for the node
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        // Constructor to initialize an empty queue
        QueueUsingLinkedList() {
            front = rear = null;
        }

        // Enqueue an element to the queue
        public void enqueue(int data) {
            Node newNode = new Node(data);
            if (rear == null) {  // If queue is empty
                front = rear = newNode;
            } else {
                rear.next = newNode;  // Link the new node at the end
                rear = newNode;  // Update the rear pointer
            }
        }

        // Dequeue an element from the queue
        public int dequeue() {
            if (front == null) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int data = front.data;  // Get the front data
            front = front.next;  // Move the front pointer
            if (front == null) rear = null;  // If the queue is empty after dequeue
            return data;
        }

        // Peek the front element of the queue
        public int peek() {
            if (front == null) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return front.data;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return front == null;
        }
    }

    // 3. Implement Two Stacks using a Single Array
    static class TwoStacksInArray {
        int[] arr;
        int top1, top2, size;

        // Constructor to initialize two stacks in an array
        TwoStacksInArray(int n) {
            size = n;
            arr = new int[n];
            top1 = -1;  // Top of the first stack
            top2 = size;  // Top of the second stack
        }

        // Push in the first stack
        public void push1(int data) {
            if (top1 < top2 - 1) {
                arr[++top1] = data;  // Push in stack 1
            } else {
                System.out.println("Stack Overflow");
            }
        }

        // Push in the second stack
        public void push2(int data) {
            if (top1 < top2 - 1) {
                arr[--top2] = data;  // Push in stack 2
            } else {
                System.out.println("Stack Overflow");
            }
        }

        // Pop from the first stack
        public int pop1() {
            if (top1 >= 0) {
                return arr[top1--];  // Pop from stack 1
            } else {
                System.out.println("Stack Underflow");
                return -1;
            }
        }

        // Pop from the second stack
        public int pop2() {
            if (top2 < size) {
                return arr[top2++];  // Pop from stack 2
            } else {
                System.out.println("Stack Underflow");
                return -1;
            }
        }
    }

    // 4. Find the Minimum Element in a Stack in O(1) Time using an Auxiliary Stack
    static class MinStack {
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        // Push element onto stack
        public void push(int data) {
            mainStack.push(data);  // Push onto the main stack
            if (minStack.isEmpty() || data <= minStack.peek()) {
                minStack.push(data);  // Push onto the min stack if it's the smallest element
            }
        }

        // Pop element from stack
        public int pop() {
            if (mainStack.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            int popped = mainStack.pop();
            if (popped == minStack.peek()) {
                minStack.pop();  // Pop from minStack if it's the minimum element
            }
            return popped;
        }

        // Get the minimum element from the stack in O(1) time
        public int getMin() {
            if (minStack.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return minStack.peek();  // Top of minStack is the minimum element
        }
    }

    // 5. Implement a Queue using Two Stacks
    static class QueueUsingTwoStacks {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Enqueue an element
        public void enqueue(int data) {
            stack1.push(data);  // Push onto stack 1
        }

        // Dequeue an element
        public int dequeue() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) {
                    System.out.println("Queue Underflow");
                    return -1;
                }
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());  // Transfer elements from stack 1 to stack 2
                }
            }
            return stack2.pop();  // Pop from stack 2
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    // 6. Evaluate a Postfix Expression using Stack
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        // Traverse through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is a number, push it to the stack
            if (Character.isDigit(c)) {
                stack.push(c - '0');  // Convert char to int and push
            } else {
                // If the character is an operator, pop two numbers from the stack and apply the operator
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);  // Add
                        break;
                    case '-':
                        stack.push(val2 - val1);  // Subtract
                        break;
                    case '*':
                        stack.push(val2 * val1);  // Multiply
                        break;
                    case '/':
                        stack.push(val2 / val1);  // Divide
                        break;
                }
            }
        }

        return stack.pop();  // The final result will be at the top of the stack
    }

    // 7. Sort a Stack using Another Stack
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();

        // Transfer elements from the original stack to sortedStack in sorted order
        while (!stack.isEmpty()) {
            int temp = stack.pop();  // Pop element from stack
            while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                stack.push(sortedStack.pop());  // Move elements back to original stack
            }
            sortedStack.push(temp);  // Push the element onto sortedStack
        }

        return sortedStack;  // Return the sorted stack
    }

    // 8. Next Greater Element using Stack
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // Remove elements from the stack that are smaller or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element exists; otherwise, the top of the stack is the next greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);  // Push the current element onto the stack
        }

        return result;  // Return the result array containing next greater elements
    }

    // 9. Design and Implement a Circular Queue
    static class CircularQueue {
        int[] queue;
        int front, rear, size, capacity;

        // Constructor to initialize the circular queue
        CircularQueue(int capacity) {
            this.capacity = capacity;
            queue = new int[capacity];
            front = -1;
            rear = -1;
            size = 0;
        }

        // Enqueue an element to the queue
        public boolean enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return false;
            }
            if (isEmpty()) {
                front = rear = 0;  // First element is added
            } else {
                rear = (rear + 1) % capacity;  // Circularly increment the rear index
            }
            queue[rear] = data;
            size++;
            return true;
        }

        // Dequeue an element from the queue
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int data = queue[front];
            if (front == rear) {  // Only one element left in the queue
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;  // Circularly increment the front index
            }
            size--;
            return data;
        }

        // Check if the queue is full
        public boolean isFull() {
            return size == capacity;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Get the front element of the queue
        public int peekFront() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return queue[front];
        }
    }

    // 10. Implement a LRU Cache
    static class LRUCache {
        int capacity;
        HashMap<Integer, Integer> map;  // To store the key-value pairs
        LinkedList<Integer> accessOrder;  // To keep track of the access order

        // Constructor to initialize the LRU cache
        LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            accessOrder = new LinkedList<>();
        }

        // Get a value from the cache
        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;  // Key not found
            }
            accessOrder.remove(Integer.valueOf(key));  // Remove the key from its current position
            accessOrder.addFirst(key);  // Move the key to the front (most recently accessed)
            return map.get(key);  // Return the corresponding value
        }

        // Put a value in the cache
        public void put(int key, int value) {
            if (map.containsKey(key)) {
                accessOrder.remove(Integer.valueOf(key));  // Remove the old position
            } else if (map.size() == capacity) {
                int leastUsedKey = accessOrder.removeLast();  // Remove the least recently used key
                map.remove(leastUsedKey);
            }
            accessOrder.addFirst(key);  // Add the key to the front (most recently accessed)
            map.put(key, value);  // Add the key-value pair to the map
        }
    }

    public static void main(String[] args) {
        // Example usages of each program:

        // 1. Stack using Array
        StackUsingArray stackArray = new StackUsingArray(5);
        stackArray.push(1);
        stackArray.push(2);
        System.out.println("Stack Peek: " + stackArray.peek());  // Output: 2

        // 2. Queue using Linked List
        QueueUsingLinkedList queueLinkedList = new QueueUsingLinkedList();
        queueLinkedList.enqueue(1);
        queueLinkedList.enqueue(2);
        System.out.println("Queue Dequeue: " + queueLinkedList.dequeue());  // Output: 1

        // 3. Two Stacks in One Array
        TwoStacksInArray twoStacks = new TwoStacksInArray(5);
        twoStacks.push1(10);
        twoStacks.push2(20);
        System.out.println("Two Stack Pop1: " + twoStacks.pop1());  // Output: 10

        // 4. Min Stack (O(1) getMin)
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(20);
        minStack.push(5);
        System.out.println("Min Element: " + minStack.getMin());  // Output: 5

        // 5. Queue using Two Stacks
        QueueUsingTwoStacks queueStacks = new QueueUsingTwoStacks();
        queueStacks.enqueue(1);
        queueStacks.enqueue(2);
        System.out.println("Queue Dequeue: " + queueStacks.dequeue());  // Output: 1

        // 6. Evaluate Postfix Expression
        System.out.println("Postfix Evaluation: " + evaluatePostfix("231*+9-"));  // Output: -4

        // 7. Sort Stack using Another Stack
        Stack<Integer> unsortedStack = new Stack<>();
        unsortedStack.push(34);
        unsortedStack.push(3);
        unsortedStack.push(31);
        Stack<Integer> sortedStack = sortStack(unsortedStack);
        System.out.println("Sorted Stack: " + sortedStack);  // Output: [3, 31, 34]

        // 8. Next Greater Element
        int[] arr = {4, 5, 2, 25};
        int[] nge = nextGreaterElement(arr);
        System.out.print("Next Greater Elements: ");
        for (int num : nge) {
            System.out.print(num + " ");  // Output: 5 25 25 -1
        }
        System.out.println();

        // 9. Circular Queue
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        System.out.println("Circular Queue Dequeue: " + circularQueue.dequeue());  // Output: 1

        // 10. LRU Cache
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        System.out.println("LRU Cache Get 1: " + lruCache.get(1));  // Output: 10
        lruCache.put(3, 30);  // Evicts key 2
        System.out.println("LRU Cache Get 2: " + lruCache.get(2));  // Output: -1
    }
}

