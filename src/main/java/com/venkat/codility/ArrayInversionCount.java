package com.venkat.codility;

public class ArrayInversionCount {
    public int solution(int[] A) {
        return mergeSort(A, new int[A.length], 0, A.length - 1);
    }

    private int mergeSort(int[] A, int[] temp, int left, int right) {
        int mid, invCount = 0;
        if (left < right) {
            mid = (left + right) / 2;

            invCount += mergeSort(A, temp, left, mid);
            invCount += mergeSort(A, temp, mid + 1, right);

            invCount += merge(A, temp, left, mid + 1, right);
        }
        return invCount;
    }

    private int merge(int[] A, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;
        int invCount = 0;

        while (i <= mid - 1 && j <= right) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
                invCount += (mid - i);
            }
        }

        while (i <= mid - 1) temp[k++] = A[i++];
        while (j <= right) temp[k++] = A[j++];

        for (i = left; i <= right; i++) A[i] = temp[i];

        return invCount;
    }

    public static void main(String[] args) {
        ArrayInversionCount obj = new ArrayInversionCount();
        int[] A = {2, 4, 1, 3, 5};
        System.out.println(obj.solution(A));  // Output: 3
    }
}

