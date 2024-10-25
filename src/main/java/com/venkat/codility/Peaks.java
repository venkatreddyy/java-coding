package com.venkat.codility;

import java.util.ArrayList;

public class Peaks {
    public int solution(int[] A) {
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        int N = A.length;
        for (int size = 1; size <= N; size++) {
            if (N % size == 0) {
                int blockCount = N / size;
                boolean valid = true;
                int peakIndex = 0;

                for (int block = 0; block < blockCount; block++) {
                    boolean foundPeak = false;

                    while (peakIndex < peaks.size() && peaks.get(peakIndex) < (block + 1) * size) {
                        foundPeak = true;
                        peakIndex++;
                    }

                    if (!foundPeak) {
                        valid = false;
                        break;
                    }
                }

                if (valid) return blockCount;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Peaks obj = new Peaks();
        int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        System.out.println(obj.solution(A));  // Output: 3
    }
}

