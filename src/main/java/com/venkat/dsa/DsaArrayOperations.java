package com.venkat.dsa;

public class DsaArrayOperations {

    // Bubble Sort
    /*

     */
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
    }

    // Selection Sort
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIdx]) minIdx = j;
            swap(arr, i, minIdx);
        }
    }

    // Insertion Sort
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) arr[j + 1] = arr[j--];
            arr[j + 1] = key;
        }
    }

    // Quick Sort
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Merge Sort
    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    // Counting Sort
    public void countingSort(int[] arr, int max) {
        int[] count = new int[max + 1];
        for (int i : arr) count[i]++;
        for (int i = 1; i <= max; i++) count[i] += count[i - 1];
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) output[--count[arr[i]]] = arr[i];
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    // Radix Sort
    public void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) countSortByDigit(arr, exp);
    }

    // Linear Search
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return i;
        return -1;
    }

    // Binary Search
    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Helper functions for sorting
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++)
            if (arr[j] < pivot) swap(arr, ++i, j);
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1], R = new int[n2];
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    private void countSortByDigit(int[] arr, int exp) {
        int[] output = new int[arr.length], count = new int[10];
        for (int i : arr) count[(i / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; i--) output[--count[(arr[i] / exp) % 10]] = arr[i];
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) if (i > max) max = i;
        return max;
    }

    // Main method to test sorting and searching algorithms
    public static void main(String[] args) {
        DsaArrayOperations ops = new DsaArrayOperations();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        ops.bubbleSort(arr);
        ops.selectionSort(arr);
        ops.insertionSort(arr);
        ops.quickSort(arr, 0, arr.length - 1);
        ops.mergeSort(arr, 0, arr.length - 1);
        ops.countingSort(arr, 90);
        ops.radixSort(arr);
        System.out.println(ops.linearSearch(arr, 25));
        System.out.println(ops.binarySearch(arr, 25));
    }
}

