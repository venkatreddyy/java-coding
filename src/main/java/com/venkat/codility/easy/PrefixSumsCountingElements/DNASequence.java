package com.venkat.codility.easy.PrefixSumsCountingElements;

public class DNASequence {
    public static int[] minimumNucleotide(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            String segment = S.substring(P[i], Q[i] + 1);
            if (segment.contains("A")) result[i] = 1;
            else if (segment.contains("C")) result[i] = 2;
            else if (segment.contains("G")) result[i] = 3;
            else result[i] = 4;
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] result = minimumNucleotide(S, P, Q);
        System.out.println("Minimum Nucleotides: " + java.util.Arrays.toString(result));
    }
}
//Output: Minimum Nucleotides: [2, 4, 1]
