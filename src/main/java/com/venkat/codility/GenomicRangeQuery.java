package com.venkat.codility;

public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int[][] genoms = new int[3][S.length() + 1];
        int A, C, G;

        for (int i = 0; i < S.length(); i++) {
            A = C = G = 0;
            if (S.charAt(i) == 'A') A = 1;
            if (S.charAt(i) == 'C') C = 1;
            if (S.charAt(i) == 'G') G = 1;
            genoms[0][i + 1] = genoms[0][i] + A;
            genoms[1][i + 1] = genoms[1][i] + C;
            genoms[2][i + 1] = genoms[2][i] + G;
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int from = P[i] + 1;
            int to = Q[i] + 1;

            if (genoms[0][to] - genoms[0][from - 1] > 0) {
                result[i] = 1;
            } else if (genoms[1][to] - genoms[1][from - 1] > 0) {
                result[i] = 2;
            } else if (genoms[2][to] - genoms[2][from - 1] > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GenomicRangeQuery obj = new GenomicRangeQuery();
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] result = obj.solution(S, P, Q);
        for (int r : result) {
            System.out.print(r + " ");  // Output: 2 4 1
        }
    }
}
