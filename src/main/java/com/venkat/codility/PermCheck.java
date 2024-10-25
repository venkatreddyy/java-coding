package com.venkat.codility;

public class PermCheck {
    public int solution(int[] A) {
        boolean[] seen = new boolean[A.length + 1];
        for (int num : A) {
            if (num < 1 || num > A.length || seen[num]) return 0;
            seen[num] = true;
        }
        return 1;
    }

    public static void main(String[] args) {
        PermCheck obj = new PermCheck();
        int[] arr = {4, 1, 3, 2};
        System.out.println(obj.solution(arr));  // Output: 1
    }
}

