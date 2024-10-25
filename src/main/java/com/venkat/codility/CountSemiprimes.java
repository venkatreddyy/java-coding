package com.venkat.codility;

import java.util.Arrays;

public class CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
        boolean[] sieve = new boolean[N + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= N; j += i) {
                    sieve[j] = false;
                }
            }
        }

        int[] semiprimes = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            for (int j = i; i * j <= N; j++) {
                if (sieve[i] && sieve[j]) {
                    semiprimes[i * j] = 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            semiprimes[i] += semiprimes[i - 1];
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            result[i] = semiprimes[Q[i]] - semiprimes[P[i] - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        CountSemiprimes obj = new CountSemiprimes();
        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};
        int[] result = obj.solution(26, P, Q);
        for (int r : result) {
            System.out.print(r + " ");  // Output: 10 4 0
        }
    }
}

