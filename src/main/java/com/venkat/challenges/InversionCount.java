package com.venkat.challenges;
/*
    Merge Sort with Inversion Counting (O(n log n)):
 */
public class InversionCount {

    // Merge function to count inversions while merging two halves
    private static int mergeAndCount(int[] X, int[] temp, int left, int mid, int right) {
        int i = left;    // Initial index for left subarray
        int j = mid + 1; // Initial index for right subarray
        int k = left;    // Initial index to be sorted
        int invCount = 0; // Initialize inversion count

        // Merge the two subarrays while counting inversions
        while (i <= mid && j <= right) {
            if (X[i] <= X[j]) {
                temp[k++] = X[i++];
            } else {
                temp[k++] = X[j++];
                invCount += (mid + 1) - i; // All elements left of i are greater than X[j]
            }
        }

        // Copy the remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k++] = X[i++];
        }

        // Copy the remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = X[j++];
        }

        // Copy the sorted subarray into the original array
        for (i = left; i <= right; i++) {
            X[i] = temp[i];
        }

        return invCount;
    }

    // Recursive function to divide the array and count inversions
    private static int mergeSortAndCount(int[] X, int[] temp, int left, int right) {
        int invCount = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in the left half
            invCount += mergeSortAndCount(X, temp, left, mid);

            // Count inversions in the right half
            invCount += mergeSortAndCount(X, temp, mid + 1, right);

            // Count inversions during the merge step
            invCount += mergeAndCount(X, temp, left, mid, right);
        }

        return invCount;
    }

    // Function to count inversions in the array using modified Merge Sort
    public static int getInversionCount(int[] X) {
        int[] temp = new int[X.length]; // Temporary array for merge step
        return mergeSortAndCount(X, temp, 0, X.length - 1);
    }

    public static void main(String[] args) {
        // Example array
        int[] X = {8, 4, 2, 1};

        // Get and print the inversion count
        System.out.println("Inversion count: " + getInversionCount(X)); // Output: 6
    }
}

