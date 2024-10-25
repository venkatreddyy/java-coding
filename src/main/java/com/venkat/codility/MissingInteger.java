package com.venkat.codility;

import java.util.*;

public class MissingInteger {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (num > 0) set.add(num);
        }
        int i = 1;
        while (set.contains(i)) i++;
        return i;
    }

    public static void main(String[] args) {
        MissingInteger obj = new MissingInteger();
        int[] arr = {1, 3, 6, 4, 1, 2};
        System.out.println(obj.solution(arr));  // Output: 5
    }
}

