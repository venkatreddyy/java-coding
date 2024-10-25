package com.venkat.codility;

import java.util.ArrayList;

public class Flags {
    public int solution(int[] A) {
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        if (peaks.size() == 0) return 0;

        int maxFlags = 0;
        for (int flags = 1; flags * flags <= A.length; flags++) {
            int usedFlags = 1;
            int lastFlag = peaks.get(0);

            for (int j = 1; j < peaks.size(); j++) {
                if (peaks.get(j) - lastFlag >= flags) {
                    usedFlags++;
                    lastFlag = peaks.get(j);
                    if (usedFlags == flags) break;
                }
            }

            maxFlags = Math.max(maxFlags, usedFlags);
        }

        return maxFlags;
    }

    public static void main(String[] args) {
        Flags obj = new Flags();
        int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        System.out.println(obj.solution(A));  // Output: 3
    }
}

