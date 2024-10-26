package com.venkat.codility.medium.PrefixSumsCountingElements;

import java.util.Arrays;

public class CountSemiPrimes {
    public static int[] countSemiPrimes(int N, int[] P, int[] Q) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int k = i * i; k <= N; k += i) {
                    isPrime[k] = false;
                }
            }
        }

        int[] semiPrimes = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= N / i; j++) {
                    if (isPrime[j]) semiPrimes[i * j] = 1;
                }
            }
        }

        // Create a prefix sum array to count semiprimes up to each index
        for (int i = 1; i <= N; i++) {
            semiPrimes[i] += semiPrimes[i - 1];
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            result[i] = semiPrimes[Q[i]] - semiPrimes[P[i] - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};
        int[] result = countSemiPrimes(26, P, Q);
        System.out.println("SemiPrimes Count in Ranges: " + Arrays.toString(result));
        // Output: [10, 4, 0]
    }
}

