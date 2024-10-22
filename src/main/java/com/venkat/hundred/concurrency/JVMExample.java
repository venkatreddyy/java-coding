package com.venkat.hundred.concurrency;

// Main class to demonstrate JVM operations
public class JVMExample {

    // Static block: Class loading demonstration
    static {
        System.out.println("Static block executed. Class loaded into Method Area.");
    }

    // Static variable in Method Area
    private static String staticMessage = "Static Variable in Method Area";

    // Instance variables in Heap memory
    private String instanceMessage;
    private int number;

    // Constructor: Demonstrates object creation in Heap
    public JVMExample(String message, int number) {
        this.instanceMessage = message;
        this.number = number;
        System.out.println("Object created in Heap. Instance variables allocated.");
    }

    // Method demonstrating local variables on the Stack
    public void displayMessages() {
        // Local variables stored in the Stack frame
        String localMessage = "Local Variable in Stack";
        System.out.println(localMessage);
        System.out.println("Instance Variable from Heap: " + instanceMessage);
        System.out.println("Static Variable from Method Area: " + staticMessage);
    }

    // Static method to demonstrate method invocation and recursion (stack frames)
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1); // Recursion creates new stack frames
        }
    }

    // Method to demonstrate Garbage Collection
    public static void demonstrateGC() {
        // Creating objects to fill heap space
        for (int i = 0; i < 1000; i++) {
            new JVMExample("Garbage Collection Demo", i); // These objects will be eligible for GC
        }

        // Requesting Garbage Collection
        System.gc(); // Calls the Garbage Collector
        System.out.println("Garbage Collection triggered.");
    }

    // Finalizer method (Deprecated in Java 9+ but still useful for demo purposes)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize called. Object eligible for garbage collection.");
    }

    // Exception Handling Demonstration
    public static void handleException() {
        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed. Used for resource cleanup.");
        }
    }

    // Main method: Entry point of the Java program
    public static void main(String[] args) {
        // Object creation: Allocates memory on the heap
        JVMExample example = new JVMExample("Hello from JVM", 42);

        // Method invocation: Stack frame creation
        example.displayMessages();

        // Factorial calculation using recursion: Demonstrates stack frames
        int fact = factorial(5);
        System.out.println("Factorial of 5 is: " + fact);

        // Demonstrate exception handling
        handleException();

        // Demonstrating Garbage Collection
        demonstrateGC();

        // Printing heap dump size with Runtime class (Memory Monitoring)
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Max memory (heap): " + runtime.maxMemory());
        System.out.println("Total memory (heap): " + runtime.totalMemory());
        System.out.println("Free memory (heap): " + runtime.freeMemory());
    }
}

