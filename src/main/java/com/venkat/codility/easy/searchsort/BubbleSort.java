package com.venkat.codility.easy.searchsort;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Loop to perform passes over the array
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if elements are in the wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));
    }
}

