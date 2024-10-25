package com.venkat.codility;

public class OddOccurrences {
    public int solution(int[] A) {
        int result = 0;
        for (int num : A) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        OddOccurrences obj = new OddOccurrences();
        int[] arr = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(obj.solution(arr));  // Output: 7
    }
}

