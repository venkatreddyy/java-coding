package com.venkat.design.solid;

// Parent class Bird with fly method, but some birds can't fly (violates LSP)
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

// Penguin cannot fly, but inherits fly method (violates LSP)
class Penguin extends Bird {
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}

public class LSPBefore {
    public static void main(String[] args) {
        Bird penguin = new Penguin();  // LSP violation: Penguin can't fly
        penguin.fly();                 // Throws exception
    }
}

