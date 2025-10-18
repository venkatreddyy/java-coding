package com.venkat.challenges.apple;

import java.util.*;

public class PatternProblems {

    public static void main(String[] args) {
        int n = 5;

        solidRectangle(4, 5);
        hollowRectangle(4, 5);
        rightAngledTriangle(n);
        invertedRightAngledTriangle(n);
        rightAlignedTriangle(n);
        numberTriangle(n);
        floydsTriangle(n);
        butterflyPattern(4);
        diamondPattern(n);
        pascalTriangle(n);
    }

    // 1. Solid Rectangle
    static void solidRectangle(int rows, int cols) {
        System.out.println("\nSolid Rectangle:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 2. Hollow Rectangle
    static void hollowRectangle(int rows, int cols) {
        System.out.println("\nHollow Rectangle:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    // 3. Right-Angled Triangle (Left-Aligned)
    static void rightAngledTriangle(int n) {
        System.out.println("\nRight-Angled Triangle:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 4. Inverted Right-Angled Triangle
    static void invertedRightAngledTriangle(int n) {
        System.out.println("\nInverted Right-Angled Triangle:");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 5. Right-Aligned Triangle
    static void rightAlignedTriangle(int n) {
        System.out.println("\nRight-Aligned Triangle:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 6. Number Triangle
    static void numberTriangle(int n) {
        System.out.println("\nNumber Triangle:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print(j);
            System.out.println();
        }
    }

    // 7. Floyd's Triangle
    static void floydsTriangle(int n) {
        System.out.println("\nFloyd's Triangle:");
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print(num++ + " ");
            System.out.println();
        }
    }

    // 8. Butterfly Pattern
    static void butterflyPattern(int n) {
        System.out.println("\nButterfly Pattern:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            for (int j = 1; j <= 2 * (n - i); j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            for (int j = 1; j <= 2 * (n - i); j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 9. Diamond Pattern
    static void diamondPattern(int n) {
        System.out.println("\nDiamond Pattern:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 10. Pascal's Triangle
    static void pascalTriangle(int n) {
        System.out.println("\nPascal's Triangle:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) System.out.print(" ");
            int num = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}

