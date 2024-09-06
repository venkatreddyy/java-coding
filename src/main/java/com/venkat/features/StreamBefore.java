package com.venkat.features;

import java.util.Arrays;
import java.util.List;

public class StreamBefore {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sequential processing using a for loop
        System.out.println("Sequential For Loop:");
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}

