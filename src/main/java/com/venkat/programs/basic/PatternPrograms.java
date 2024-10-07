package com.venkat.programs.basic;
/*
Explanation of each pattern:
Half Pyramid: Simple left-aligned triangle of stars.
Inverted Half Pyramid: Reverse of the half pyramid.
Full Pyramid: Center-aligned pyramid with stars.
Inverted Full Pyramid: Inverted version of the full pyramid.
Hollow Pyramid: Full pyramid with hollow spaces inside.
Diamond Pattern: Full diamond made by combining two triangles.
Right Pascal's Triangle: Right-aligned triangle followed by an inverted right triangle.
Left Pascal's Triangle: Left-aligned version of Pascal's triangle.
Floyd's Triangle: Triangle of numbers incrementing from 1.
Number Pyramid: Pyramid made of increasing numbers.
Butterfly Pattern: Upper and lower parts of the butterfly made from stars.
Sandglass Pattern: Inverted and normal triangle.
Zigzag Pattern: Zigzagging pattern of stars.
Hollow Diamond: Diamond with hollow inside.
Solid Rectangle: Simple rectangle of stars.
Example Output:
For a given input, the patterns will be displayed accordingly as rows and columns of stars, numbers, and spaces.






You said:
print output
ChatGPT said:
ChatGPT
Here is the output for the 15 pattern programs when called with a parameter of n = 5 (or similar for patterns with multiple dimensions):

1. Half Pyramid:
markdown
Copy code
*
* *
* * *
* * * *
* * * * *
2. Inverted Half Pyramid:
markdown
Copy code
* * * * *
* * * *
* * *
* *
*
3. Full Pyramid:
markdown
Copy code
    *
   ***
  *****
 *******
*********
4. Inverted Full Pyramid:
markdown
Copy code
*********
 *******
  *****
   ***
    *
5. Hollow Pyramid:
markdown
Copy code
    *
   * *
  *   *
 *     *
*********
6. Diamond Pattern:
markdown
Copy code
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
7. Right Pascal's Triangle:
markdown
Copy code
*
* *
* * *
* * * *
* * * * *
* * * *
* * *
* *
*
8. Left Pascal's Triangle:
markdown
Copy code
        *
      * *
    * * *
  * * * *
* * * * *
  * * * *
    * * *
      * *
        *
9. Floyd's Triangle:
Copy code
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
10. Number Pyramid:
markdown
Copy code
    1
   1 2
  1 2 3
 1 2 3 4
1 2 3 4 5
11. Butterfly Pattern:
markdown
Copy code
*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *
12. Sandglass Pattern:
markdown
Copy code
*********
 *******
  *****
   ***
    *
    *
   ***
  *****
 *******
*********
13. Zigzag Pattern:
markdown
Copy code
  *   *   *
*   *   *   *
  *   *   *
14. Hollow Diamond Pattern:
markdown
Copy code
    *
   * *
  *   *
 *     *
*       *
 *     *
  *   *
   * *
    *
15. Solid Rectangle:
markdown
Copy code
* * * * *
* * * * *
* * * * *
 */
public class PatternPrograms {

    // 1) Half Pyramid of Stars
    // Time Complexity: O(n^2) because of the nested loops
    // Space Complexity: O(1), no extra space is used
    public static void halfPyramid(int n) {
        // Outer loop for the number of rows
        for (int i = 1; i <= n; i++) {
            // Inner loop to print stars equal to the current row number
            for (int j = 1; j <= i; j++) {
                System.out.print("* "); // Print star followed by space
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 2) Inverted Half Pyramid of Stars
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void invertedHalfPyramid(int n) {
        // Outer loop for the number of rows
        for (int i = n; i >= 1; i--) {
            // Inner loop to print stars equal to the current row number
            for (int j = 1; j <= i; j++) {
                System.out.print("* "); // Print star followed by space
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 3) Full Pyramid of Stars
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void fullPyramid(int n) {
        // Outer loop for the number of rows
        for (int i = 1; i <= n; i++) {
            // Print spaces before stars (for left alignment)
            for (int j = i; j < n; j++) {
                System.out.print(" "); // Print leading spaces
            }
            // Print stars in the current row
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*"); // Print stars
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 4) Inverted Full Pyramid of Stars
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void invertedFullPyramid(int n) {
        // Outer loop for the number of rows
        for (int i = n; i >= 1; i--) {
            // Print spaces before stars (for left alignment)
            for (int j = i; j < n; j++) {
                System.out.print(" "); // Print leading spaces
            }
            // Print stars in the current row
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*"); // Print stars
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 5) Hollow Pyramid of Stars
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void hollowPyramid(int n) {
        // Outer loop for the number of rows
        for (int i = 1; i <= n; i++) {
            // Print spaces before stars (for left alignment)
            for (int j = i; j < n; j++) {
                System.out.print(" "); // Print leading spaces
            }
            // Inner loop to print hollow pattern stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1) || i == n) {
                    System.out.print("*"); // Print stars at the border
                } else {
                    System.out.print(" "); // Print spaces inside the pyramid
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 6) Diamond of Stars
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void diamondPattern(int n) {
        // First part: upper triangle (full pyramid)
        for (int i = 1; i <= n; i++) {
            // Print spaces before stars (for left alignment)
            for (int j = i; j < n; j++) {
                System.out.print(" "); // Print leading spaces
            }
            // Print stars in the current row
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*"); // Print stars
            }
            System.out.println(); // Move to the next line after each row
        }
        // Second part: lower triangle (inverted pyramid)
        for (int i = n - 1; i >= 1; i--) {
            // Print spaces before stars (for left alignment)
            for (int j = i; j < n; j++) {
                System.out.print(" "); // Print leading spaces
            }
            // Print stars in the current row
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*"); // Print stars
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 7) Right Pascal's Triangle
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void rightPascalsTriangle(int n) {
        // First part: upper triangle
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* "); // Print stars
            }
            System.out.println(); // Move to the next line after each row
        }
        // Second part: lower triangle
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* "); // Print stars
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 8) Left Pascal's Triangle
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void leftPascalsTriangle(int n) {
        // First part: upper triangle
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = i; j < n; j++) {
                System.out.print("  "); // Print spaces for alignment
            }
            // Print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* "); // Print stars
            }
            System.out.println(); // Move to the next line after each row
        }
        // Second part: lower triangle
        for (int i = n - 1; i >= 1; i--) {
            // Print spaces
            for (int j = i; j < n; j++) {
                System.out.print("  "); // Print spaces for alignment
            }
            // Print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* "); // Print stars
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 9) Floyd's Triangle
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void floydsTriangle(int n) {
        int num = 1; // Initialize the number to print
        // Outer loop for rows
        for (int i = 1; i <= n; i++) {
            // Inner loop for columns
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " "); // Print current number
                num++; // Increment the number
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 10) Number Pyramid
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void numberPyramid(int n) {
        // Outer loop for rows
        for (int i = 1; i <= n; i++) {
            // Print spaces for left alignment
            for (int j = i; j < n; j++) {
                System.out.print(" "); // Print leading spaces
            }
            // Print numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " "); // Print numbers
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 11) Butterfly Pattern
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void butterflyPattern(int n) {
        // First part: upper half
        for (int i = 1; i <= n; i++) {
            // Print stars on the left side
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Print spaces in the middle
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // Print stars on the right side
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line
        }
        // Second part: lower half
        for (int i = n; i >= 1; i--) {
            // Print stars on the left side
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Print spaces in the middle
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // Print stars on the right side
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line
        }
    }

    // 12) Sandglass Pattern
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void sandglassPattern(int n) {
        // First part: inverted triangle
        for (int i = n; i >= 1; i--) {
            // Print spaces before stars
            for (int j = i; j < n; j++) {
                System.out.print(" "); // Print leading spaces
            }
            // Print stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*"); // Print stars
            }
            System.out.println(); // Move to the next line
        }
        // Second part: normal triangle
        for (int i = 1; i <= n; i++) {
            // Print spaces before stars
            for (int j = i; j < n; j++) {
                System.out.print(" "); // Print leading spaces
            }
            // Print stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*"); // Print stars
            }
            System.out.println(); // Move to the next line
        }
    }

    // 13) Zigzag Pattern
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void zigzagPattern(int n) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= n; j++) {
                if (((i + j) % 4 == 0) || (i == 2 && j % 4 == 0)) {
                    System.out.print("*"); // Print star at calculated positions
                } else {
                    System.out.print(" "); // Print space otherwise
                }
            }
            System.out.println(); // Move to the next line
        }
    }

    // 14) Hollow Diamond Pattern
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void hollowDiamond(int n) {
        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" "); // Print leading spaces
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1)) {
                    System.out.print("*"); // Print stars at edges
                } else {
                    System.out.print(" "); // Print hollow spaces
                }
            }
            System.out.println(); // Move to the next line
        }
        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i; j < n; j++) {
                System.out.print(" "); // Print leading spaces
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1)) {
                    System.out.print("*"); // Print stars at edges
                } else {
                    System.out.print(" "); // Print hollow spaces
                }
            }
            System.out.println(); // Move to the next line
        }
    }

    // 15) Solid Rectangle
    // Time Complexity: O(n * m), where n is the number of rows and m is the number of columns
    // Space Complexity: O(1)
    public static void solidRectangle(int rows, int cols) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print("* "); // Print stars
            }
            System.out.println(); // Move to the next line
        }
    }

    // Main method to test all pattern programs
    public static void main(String[] args) {
        System.out.println("Half Pyramid:");
        halfPyramid(5);
        System.out.println("Inverted Half Pyramid:");
        invertedHalfPyramid(5);
        System.out.println("Full Pyramid:");
        fullPyramid(5);
        System.out.println("Inverted Full Pyramid:");
        invertedFullPyramid(5);
        System.out.println("Hollow Pyramid:");
        hollowPyramid(5);
        System.out.println("Diamond Pattern:");
        diamondPattern(5);
        System.out.println("Right Pascal's Triangle:");
        rightPascalsTriangle(5);
        System.out.println("Left Pascal's Triangle:");
        leftPascalsTriangle(5);
        System.out.println("Floyd's Triangle:");
        floydsTriangle(5);
        System.out.println("Number Pyramid:");
        numberPyramid(5);
        System.out.println("Butterfly Pattern:");
        butterflyPattern(5);
        System.out.println("Sandglass Pattern:");
        sandglassPattern(5);
        System.out.println("Zigzag Pattern:");
        zigzagPattern(9);
        System.out.println("Hollow Diamond Pattern:");
        hollowDiamond(5);
        System.out.println("Solid Rectangle:");
        solidRectangle(3, 5);
    }
}

