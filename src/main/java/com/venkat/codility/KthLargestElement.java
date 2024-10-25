package com.venkat.codility;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int solution(int[] A, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : A) {
            minHeap.add(num);
            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElement obj = new KthLargestElement();
        int[] A = {3, 2, 1, 5, 6, 4};
        System.out.println(obj.solution(A, 2));  // Output: 5
    }
}

