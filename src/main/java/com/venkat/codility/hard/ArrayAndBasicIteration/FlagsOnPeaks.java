package com.venkat.codility.hard.ArrayAndBasicIteration;

import java.util.ArrayList;
import java.util.List;

public class FlagsOnPeaks {

    public static int maxFlags(int[] A) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i); // Record peak positions
            }
        }
        if (peaks.size() < 2) return peaks.size(); // No flags if 0 or 1 peak

        int left = 1;
        int right = peaks.size();
        int result = 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int usedFlags = 1;
            int lastPosition = peaks.get(0);

            for (int j = 1; j < peaks.size(); j++) {
                if (peaks.get(j) >= lastPosition + mid) {
                    usedFlags++;
                    lastPosition = peaks.get(j);
                    if (usedFlags == mid) break;
                }
            }

            if (usedFlags >= mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        int result = maxFlags(A);
        System.out.println("Maximum Number of Flags: " + result); // Output: 3
    }
}

