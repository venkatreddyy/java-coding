package com.venkat.codility.easy.ArrayAndBasicIteration;

public class FrogJmp {
    public static int frogJump(int X, int Y, int D) {
        // Calculate the minimal number of jumps needed
        return (int) Math.ceil((double)(Y - X) / D);

        /*
        Explanation of the Code:
Distance Calculation: Y - X

This gives the total distance that the frog needs to jump.
Divide by Jump Distance and Round Up:

(double)(Y - X) / D gives the exact (decimal) number of jumps needed.
Math.ceil rounds up to ensure any remaining distance counts as an extra jump if needed.
Casting to Integer:

Casting to (int) returns the minimal number of jumps as an integer.
Example:
Given:

𝑋
=
10
X=10
𝑌
=
85
Y=85
𝐷
=
30
D=30
The calculation would go as follows:

java
Copy code
minimalJumps(10, 85, 30)
= (int) Math.ceil((double)(85 - 10) / 30)
= (int) Math.ceil(75 / 30)
= (int) Math.ceil(2.5)
= 3
Thus, the frog requires 3 jumps to reach or exceed the target position
𝑌
Y.
         */
    }

    public static void main(String[] args) {
        int result = frogJump(10, 85, 30);
        System.out.println("Minimal Jumps: " + result); // Output: 3
    }
}

