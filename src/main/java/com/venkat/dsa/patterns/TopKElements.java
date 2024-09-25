package com.venkat.dsa.patterns;

import java.util.PriorityQueue;

public class TopKElements {

    public int[] findTopKLargest(int[] nums, int k) {
        // Min-heap to keep track of the top K largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through the array
        for (int num : nums) {
            // Add the current number to the heap
            minHeap.add(num);

            // If the size of the heap exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the root (smallest element)
            }
        }

        // The heap now contains the top K largest elements, but unordered
        int[] result = new int[k];
        int index = 0;

        // Extract elements from the heap
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKElements topK = new TopKElements();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 3;

        // Find top K largest elements
        int[] result = topK.findTopKLargest(nums, k);

        // Print result
        System.out.print("Top " + k + " largest elements are: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Example output (may vary depending on heap order): Top 3 largest elements are: 4 5 6
    }
}
