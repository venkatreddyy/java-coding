package com.venkat.codility;

public class BinaryGap {
    public int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        int maxGap = 0, currentGap = 0;
        boolean inGap = false;

        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                if (inGap) {
                    maxGap = Math.max(maxGap, currentGap);
                }
                inGap = true;
                currentGap = 0;
            } else if (inGap) {
                currentGap++;
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        BinaryGap obj = new BinaryGap();
        System.out.println(obj.solution(1041));  // Output: 5
    }
}

