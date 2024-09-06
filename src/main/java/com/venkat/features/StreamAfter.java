package com.venkat.features;

import java.util.Arrays;
import java.util.List;

public class StreamAfter {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sequential Stream
        System.out.println("Sequential Stream:");
        numbers.stream()
                .forEach(System.out::println);

        // Parallel Stream
        System.out.println("Parallel Stream:");
        numbers.parallelStream()
                .forEach(System.out::println);
    }
}

