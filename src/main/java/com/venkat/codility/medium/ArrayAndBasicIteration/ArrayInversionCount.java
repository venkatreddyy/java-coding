package com.venkat.codility.medium.ArrayAndBasicIteration;

public class ArrayInversionCount {
    public static int countInversions(int[] A) {
        return mergeSortAndCount(A, 0, A.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int count = mergeSortAndCount(arr, left, mid);
        count += mergeSortAndCount(arr, mid + 1, right);
        count += mergeAndCount(arr, left, mid, right);
        return count;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = java.util.Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = java.util.Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left, swaps = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (mid + 1) - (left + i); // Count inversions
            }
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        int result = countInversions(arr);
        System.out.println("Inversion Count: " + result); // Output: 5
    }
}

