package com.venkat.codility.hard.PrefixSumsCountingElements;

public class GenomicRangeQuery {
    public static int[] genomicRangeQuery(String S, int[] P, int[] Q) {
        int N = S.length();
        int[][] prefixSums = new int[3][N + 1]; // A, C, G; T is implied

        for (int i = 0; i < N; i++) {
            char nucleotide = S.charAt(i);
            prefixSums[0][i + 1] = prefixSums[0][i] + (nucleotide == 'A' ? 1 : 0);
            prefixSums[1][i + 1] = prefixSums[1][i] + (nucleotide == 'C' ? 1 : 0);
            prefixSums[2][i + 1] = prefixSums[2][i] + (nucleotide == 'G' ? 1 : 0);
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i] + 1;

            if (prefixSums[0][end] - prefixSums[0][start] > 0) result[i] = 1; // A
            else if (prefixSums[1][end] - prefixSums[1][start] > 0) result[i] = 2; // C
            else if (prefixSums[2][end] - prefixSums[2][start] > 0) result[i] = 3; // G
            else result[i] = 4; // T
        }

        return result;
    }

    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] result = genomicRangeQuery(S, P, Q);

        System.out.println("Genomic Range Query Results: " + java.util.Arrays.toString(result)); // Output: [2, 4, 1]
    }
}

