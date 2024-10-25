package com.venkat.codility;

import java.util.Stack;

public class Fish {
    public int solution(int[] A, int[] B) {
        Stack<Integer> downstream = new Stack<>();
        int survivors = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                downstream.push(A[i]);
            } else {
                while (!downstream.isEmpty()) {
                    if (downstream.peek() > A[i]) break;
                    downstream.pop();
                }
                if (downstream.isEmpty()) {
                    survivors++;
                }
            }
        }

        return survivors + downstream.size();
    }

    public static void main(String[] args) {
        Fish obj = new Fish();
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};
        System.out.println(obj.solution(A, B));  // Output: 2
    }
}

