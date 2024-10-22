package com.venkat.hundred.concurrency;
/*
To cover the essential Java Virtual Machine (JVM) concepts in a single Java class, we need to touch on a few critical areas, such as:

Class Loading: How the JVM loads classes into memory.
Memory Management:
Heap Memory: Where objects are allocated.
Stack Memory: Where local variables, method calls, and references are stored.
Garbage Collection: Unused objects in heap memory are cleared.
Multithreading: How the JVM handles thread management and execution.
Execution Engine: The bytecode execution, optimizations like JIT (Just-In-Time compilation).
JVM Instructions and Bytecode: Demonstrating how the JVM interprets bytecode for execution.
Exception Handling: JVM's role in exception propagation and stack unwinding.


Memory Area Allocation Explanation:
Class Loading:
Memory Area: Method Area.
Static block: When the JVMConceptsExample class is loaded, the static block is executed.
 The class and its methods are loaded into the method area, which stores class metadata, static variables, and method information.

Heap Memory:
Object Allocation: Objects obj1, obj2, and obj3 are instances of SampleObject and are allocated in the heap.
Instance Variables: The name field inside each SampleObject is also stored in the heap along with the object.
Garbage Collection: Once references like obj1, obj2, and obj3 are set to null, these objects become eligible for garbage collection.
The JVM's garbage collector runs and reclaims memory from the heap.

Stack Memory:
Method Calls: Each method call (like main(), factorial(), etc.) creates a new stack frame in the stack memory, which holds local variables, method parameters, and the return address of the method.
Recursion: The factorial() method calls itself recursively, and each recursive call adds a new stack frame to the stack. Once the base case is reached, the stack frames are popped off as the recursion unwinds.
Local Variables: Variables like result, n, and thread-specific variables such as loop counters i are stored in stack memory.

Multithreading:
Thread 1 and Thread 2: When threads are created and started (thread1 and thread2), the JVM's thread scheduler manages their execution.
 Each thread has its own stack for managing local variables and method calls.
Thread Sleep: When Thread.sleep() is called, the thread state is preserved, and the thread temporarily releases CPU control. The thread state is managed by the JVM.

Garbage Collection:
Heap Memory: After setting obj1, obj2, and obj3 to null, these objects are eligible for garbage collection.
The System.gc() method triggers a request for garbage collection, though it is not guaranteed to run immediately.
When the objects are collected, the finalize() method is called before the memory is reclaimed.
Exception Handling:

Stack Unwinding: When the division by zero occurs (10 / 0), an ArithmeticException is thrown. The JVM creates a new stack frame for the exception, and it "unwinds" the stack to look for a matching catch block. Once the exception is caught, the stack frames related to the exception are removed.

Summary of Memory Areas:
Method Area:
Stores class data, static variables, and method bytecode. This includes the static block executed when the class is loaded.

Heap Memory:
Used for dynamic memory allocation, i.e., objects (obj1, obj2, obj3) and their instance variables. Garbage collection clears heap memory.

Stack Memory:
Stores local variables, method call information, and recursion depth (each method call gets its own stack frame). Each thread has its own stack memory.


This class showcases most of the key JVM concepts related to memory management and execution. Let me know if you need further clarification on any specific part!
This single class encapsulates fundamental JVM concepts and gives a broad overview of how the JVM operates under the hood.
 Would you like more detail on any of these specific topics?
 */
public class JVMConceptsExample {

    // Static block - Demonstrates class loading in JVM
    static {
        System.out.println("Class is loaded into JVM memory.");  // Output is shown when class is loaded into the method area
    }

    // Inner static class to demonstrate object allocation in heap memory
    private static class SampleObject {
        private String name;  // The 'name' instance variable is stored in the heap as part of the object

        // Constructor - Allocates memory for the object in the heap
        public SampleObject(String name) {
            this.name = name;  // 'name' is assigned and stored in the heap
        }

        // Finalize method is called by the garbage collector before reclaiming the object memory from the heap
        @Override
        protected void finalize() throws Throwable {
            super.finalize();  // Calls the superclass finalize method
            System.out.println("Garbage Collected: " + name);  // Prints the name of the object being garbage collected
        }
    }

    // A recursive method to demonstrate the stack memory allocation (each recursive call adds a new stack frame)
    public static int factorial(int n) {
        if (n == 1) {  // Base case for recursion
            return 1;  // This return value is stored in the stack frame for the current method call
        }
        return n * factorial(n - 1);  // Recursive call, each call adds a new stack frame to the JVM stack
    }

    public static void main(String[] args) throws InterruptedException {

        // Heap Memory Allocation
        // Objects 'obj1', 'obj2', and 'obj3' are created in the heap, and their references are stored in the stack
        SampleObject obj1 = new SampleObject("Object 1");  // Object allocated in heap, obj1 reference stored in stack
        SampleObject obj2 = new SampleObject("Object 2");  // Object allocated in heap, obj2 reference stored in stack
        SampleObject obj3 = new SampleObject("Object 3");  // Object allocated in heap, obj3 reference stored in stack

        // Stack Memory Usage
        System.out.println("Factorial of 5 is: " + factorial(5));  // Factorial calculation uses recursion, adds stack frames for each call

        // Multithreading Example (JVM thread management)
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {  // Loop counter 'i' is stored in the stack for this thread
                System.out.println("Thread 1 running.");
                try {
                    Thread.sleep(100);  // The thread sleeps, state stored in thread stack, temporarily releases CPU control
                } catch (InterruptedException e) {
                    e.printStackTrace();  // Exception handling (stack trace is stored in the stack memory)
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {  // Loop counter 'i' is stored in the stack for this thread
                System.out.println("Thread 2 running.");
                try {
                    Thread.sleep(100);  // The thread sleeps, state stored in thread stack, temporarily releases CPU control
                } catch (InterruptedException e) {
                    e.printStackTrace();  // Exception handling (stack trace is stored in the stack memory)
                }
            }
        });

        // Start both threads
        thread1.start();  // Thread 1 is scheduled by the JVM thread scheduler
        thread2.start();  // Thread 2 is scheduled by the JVM thread scheduler

        // Wait for both threads to finish (join adds synchronization to ensure they complete before the main thread continues)
        thread1.join();  // Waits for thread1 to finish, state stored in stack for synchronization
        thread2.join();  // Waits for thread2 to finish, state stored in stack for synchronization

        // Garbage Collection Example
        obj1 = null;  // Object 1 reference is cleared from stack, now eligible for garbage collection
        obj2 = null;  // Object 2 reference is cleared from stack, now eligible for garbage collection
        obj3 = null;  // Object 3 reference is cleared from stack, now eligible for garbage collection
        System.gc();  // Requests garbage collection (GC reclaims memory from heap, calling finalize on eligible objects)
        Thread.sleep(500);  // Sleep to allow time for garbage collection to complete

        // Exception Handling - Stack unwinding
        try {
            int result = 10 / 0;  // This will throw an ArithmeticException (stack frame for exception is created)
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());  // Exception handling, stack unwinding after catching
        }

        System.out.println("Program has completed execution.");  // Final output
    }
}

