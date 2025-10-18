package com.venkat.challenges.apple;

import java.util.*;

public class HeapProblems {

    // 1. Kth Largest
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.peek();
    }

    // 2. Merge K Sorted Arrays
    static class Pair {
        int val, row, col;
        Pair(int v, int r, int c) { val = v; row = r; col = c; }
    }

    public static List<Integer> mergeKSortedArrays(List<List<Integer>> arrays) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.val));
        for (int i = 0; i < arrays.size(); i++) {
            if (!arrays.get(i).isEmpty()) {
                pq.offer(new Pair(arrays.get(i).get(0), i, 0));
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            result.add(curr.val);
            if (curr.col + 1 < arrays.get(curr.row).size()) {
                pq.offer(new Pair(arrays.get(curr.row).get(curr.col + 1), curr.row, curr.col + 1));
            }
        }
        return result;
    }

    // 3. Median in Data Stream
    static class MedianFinder {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size())
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            return maxHeap.peek();
        }
    }

    // 4. Heap Sort using Min Heap
    public static List<Integer> heapSortAscending(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) minHeap.offer(num);
        List<Integer> sorted = new ArrayList<>();
        while (!minHeap.isEmpty()) sorted.add(minHeap.poll());
        return sorted;
    }

    // 5. Top K Frequent Elements
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = pq.poll().getKey();
        return res;
    }

    // 6. Top K Frequent Words
    public static List<String> topKFrequentWords(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) freq.put(word, freq.getOrDefault(word, 0) + 1);

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) ->
                freq.get(a).equals(freq.get(b)) ? b.compareTo(a) : freq.get(a) - freq.get(b));

        for (String word : freq.keySet()) {
            pq.offer(word);
            if (pq.size() > k) pq.poll();
        }

        LinkedList<String> res = new LinkedList<>();
        while (!pq.isEmpty()) res.addFirst(pq.poll());
        return res;
    }

    // 7. K Closest Points to Origin
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
                Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        int[][] res = new int[k][2];
        int i = 0;
        for (int[] p : maxHeap) res[i++] = p;
        return res;
    }

    // MAIN method
    public static void main(String[] args) {
        // 1. Kth Largest
        int[] arr1 = {3, 2, 1, 5, 6, 4};
        System.out.println("1. Kth Largest: " + findKthLargest(arr1, 2)); // 5

        // 2. Merge K Sorted Arrays
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1, 4, 5),
                Arrays.asList(1, 3, 4),
                Arrays.asList(2, 6)
        );
        System.out.println("2. Merge K Sorted Arrays: " + mergeKSortedArrays(lists)); // [1,1,2,3,4,4,5,6]

        // 3. Median in Data Stream
        MedianFinder mf = new MedianFinder();
        mf.addNum(1); mf.addNum(2); mf.addNum(3);
        System.out.println("3. Median: " + mf.findMedian()); // 2.0

        // 4. Heap Sort
        System.out.println("4. Heap Sort: " + heapSortAscending(new int[]{4, 6, 1, 9})); // [1, 4, 6, 9]

        // 5. Top K Frequent Elements
        System.out.println("5. Top K Frequent: " + Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))); // [1, 2]

        // 6. Top K Frequent Words
        System.out.println("6. Top K Words: " + topKFrequentWords(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2)); // [i, love]

        // 7. K Closest Points
        int[][] closest = kClosest(new int[][]{{1, 3}, {-2, 2}, {2, -2}}, 2);
        System.out.print("7. K Closest Points: ");
        for (int[] point : closest) System.out.print(Arrays.toString(point) + " ");
        System.out.println(); // [[-2, 2], [2, -2]] or similar
    }
}
