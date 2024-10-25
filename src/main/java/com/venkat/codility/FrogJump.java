package com.venkat.codility;

public class FrogJump {
    public int solution(int X, int Y, int D) {
        return (int) Math.ceil((double)(Y - X) / D);
    }

    public static void main(String[] args) {
        FrogJump obj = new FrogJump();
        System.out.println(obj.solution(10, 85, 30));  // Output: 3
    }
}

