package com.venkat.challenges.apple;

import java.util.*;

public class StackQueueProblems {

    // 1. Implement Stack using Linked List
    static class StackLL {
        private static class Node {
            int val;
            Node next;
            Node(int val) { this.val = val; }
        }

        Node top;

        public void push(int val) {
            Node n = new Node(val);
            n.next = top;
            top = n;
        }

        public int pop() {
            if (top == null) throw new EmptyStackException();
            int val = top.val;
            top = top.next;
            return val;
        }

        public int peek() {
            if (top == null) throw new EmptyStackException();
            return top.val;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    // 2. Implement Queue using Linked List
    static class QueueLL {
        private static class Node {
            int val;
            Node next;
            Node(int val) { this.val = val; }
        }

        Node front = null, rear = null;

        public void enqueue(int val) {
            Node n = new Node(val);
            if (rear != null) rear.next = n;
            rear = n;
            if (front == null) front = rear;
        }

        public int dequeue() {
            if (front == null) throw new NoSuchElementException();
            int val = front.val;
            front = front.next;
            if (front == null) rear = null;
            return val;
        }

        public boolean isEmpty() {
            return front == null;
        }
    }

    // 3. Two stacks in one array
    static class TwoStacks {
        int[] arr;
        int top1, top2;

        TwoStacks(int size) {
            arr = new int[size];
            top1 = -1;
            top2 = size;
        }

        void push1(int x) {
            if (top1 + 1 == top2) throw new StackOverflowError();
            arr[++top1] = x;
        }

        void push2(int x) {
            if (top1 + 1 == top2) throw new StackOverflowError();
            arr[--top2] = x;
        }

        int pop1() {
            if (top1 == -1) throw new EmptyStackException();
            return arr[top1--];
        }

        int pop2() {
            if (top2 == arr.length) throw new EmptyStackException();
            return arr[top2++];
        }
    }

    // 4. Check for balanced parentheses
    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char c : expr.toCharArray()) {
            if ("({[".indexOf(c) != -1) stack.push(c);
            else if (")}]".indexOf(c) != -1) {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (!"(){}[]".contains("" + open + c)) return false;
            }
        }
        return stack.isEmpty();
    }

    // 5. Min Stack (O(1) min retrieval)
    static class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek())
                minStack.push(val);
        }

        public void pop() {
            if (stack.pop().equals(minStack.peek()))
                minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    // 6. Sort a stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            insertSorted(stack, x);
        }
    }

    private static void insertSorted(Stack<Integer> stack, int val) {
        if (stack.isEmpty() || val > stack.peek()) {
            stack.push(val);
        } else {
            int x = stack.pop();
            insertSorted(stack, val);
            stack.push(x);
        }
    }

    // 7. Next Greater Element using Stack
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }

    // 8. LRU Cache
    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private final int capacity;

        LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    // 9. Largest Rectangle in Histogram
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()])
                stack.push(i++);
            else {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
        }
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }

    // 10. Sliding Window Maximum using Deque
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        // Sample check: Balanced Parentheses
        System.out.println("Balanced: " + isBalanced("{[()]}")); // true

        // Min Stack Demo
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.pop();
        System.out.println("Min: " + ms.getMin()); // 3

        // Next Greater Element
        System.out.println("NGE: " + Arrays.toString(nextGreaterElement(new int[]{2,1,2,4,3})));

        // LRU Cache
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3); // evicts key 2
        System.out.println("LRU Get 2: " + cache.get(2)); // -1

        // Largest Rectangle
        System.out.println("Max Rectangle Area: " + largestRectangleArea(new int[]{2,1,5,6,2,3}));

        // Sliding Window
        System.out.println("Sliding Max: " + Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
}
