package com.venkat.codility;

public class TieRopes {
    public int solution(int K, int[] A) {
        int count = 0, currentLength = 0;

        for (int rope : A) {
            currentLength += rope;

            if (currentLength >= K) {
                count++;
                currentLength = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TieRopes obj = new TieRopes();
        int[] A = {1, 2, 3, 4, 1, 1, 3};
        System.out.println(obj.solution(4, A));  // Output: 3
    }
}

