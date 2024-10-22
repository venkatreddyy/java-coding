package com.venkat.design.solid;

// Abstract Bird class defines move method instead of fly (follows LSP)
abstract class Bird1 {
    abstract void move(); // General movement (not all birds fly)
}

// Flying birds subclass
class Sparrow1 extends Bird1 {
    public void move() {
        System.out.println("Flying...");
    }
}

// Penguins don't fly, but walk
class Penguin1 extends Bird1 {
    public void move() {
        System.out.println("Walking...");
    }
}

public class LSPAfter {
    public static void main(String[] args) {
        Bird1 sparrow = new Sparrow1();   // Flying bird
        Bird1 penguin = new Penguin1();   // Non-flying bird

        sparrow.move();                 // Output: Flying...
        penguin.move();                 // Output: Walking...
    }
}

