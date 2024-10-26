package com.venkat.codility.easy.searchsort;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        // Loop to place the correct minimum in each position
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found minimum with the current element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));
    }
}

