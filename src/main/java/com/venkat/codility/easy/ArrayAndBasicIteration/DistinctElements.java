package com.venkat.codility.easy.ArrayAndBasicIteration;

public class DistinctElements {
    public static int countDistinct(int[] A) {
        // Use a Set to collect unique elements
        java.util.Set<Integer> distinctSet = new java.util.HashSet<>();
        for (int num : A) {
            distinctSet.add(num);
        }
        return distinctSet.size();
    }

    public static void main(String[] args) {
        int result = countDistinct(new int[]{2, 1, 1, 2, 3, 1});
        System.out.println("Distinct Count: " + result); // Output: 3
    }
}

