package com.venkat.codereview;

import java.util.*;

/**
 * A comprehensive Java class showcasing good coding practices.
 */
public class CodeChecklist {

    // [ ] Enums are used instead of int constants where applicable
    public enum Status {
        ACTIVE, INACTIVE, PENDING
    }

    // [ ] Variables are immutable where possible
    private final String name;

    // [ ] All variables are in the smallest scope possible
    private final int age;

    // Constructor
    // [ ] Constructors do not accept null/none values
    public CodeChecklist(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
    }

    // [ ] Methods return early without compromising code readability
    public String getStatusMessage(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        switch (status) {
            case ACTIVE:
                return "User is active.";
            case INACTIVE:
                return "User is inactive.";
            case PENDING:
                return "User status is pending.";
            default:
                return "Unknown status.";
        }
    }

    // [ ] Required logs are present, and frivolous logs are absent
    public void logUserAction(String action) {
        if (action == null || action.isEmpty()) {
            System.err.println("Action cannot be null or empty"); // Use logging frameworks in real-world cases
        } else {
            System.out.println("User action logged: " + action);
        }
    }

    // [ ] Ideal data structures are used
    public Map<String, Integer> countOccurrences(List<String> items) {
        Map<String, Integer> occurrences = new HashMap<>(Math.max(16, items.size())); // [ ] Collections initialized with specific estimated capacity
        for (String item : items) {
            occurrences.put(item, occurrences.getOrDefault(item, 0) + 1);
        }
        return occurrences;
    }

    // [ ] Loops have a set length and correct termination conditions
    public List<String> filterStrings(List<String> strings, int minLength) {
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            if (s.length() >= minLength) {
                result.add(s);
            }
        }
        return result;
    }

    // [ ] Exceptions are not eaten if caught, unless explicitly documented otherwise
    public void processFile(String filePath) {
        try {
            // Simulated file processing
            if (filePath == null) {
                throw new NullPointerException("File path cannot be null");
            }
        } catch (Exception e) {
            System.err.println("Error processing file: " + e.getMessage());
            throw e; // Re-throwing the exception
        }
    }

    // [ ] Files/Sockets/Cursors and other resources are properly closed even when an exception occurs
    public void readFile(String filePath) {
        try (Scanner scanner = new Scanner(new java.io.File(filePath))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // [ ] No negatively named boolean variables
    public boolean isValidUser(String username) {
        return username != null && !username.isEmpty();
    }

    // [ ] No empty blocks of code
    public void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
    }

    // [ ] No use of Object class, use generics instead
    public <T> void printList(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

    // [ ] Design patterns if used are correctly applied (e.g., Singleton pattern)
    private static class SingletonExample {
        private static final SingletonExample INSTANCE = new SingletonExample();

        private SingletonExample() {}

        public static SingletonExample getInstance() {
            return INSTANCE;
        }
    }

    // [ ] No memory leaks
    // [ ] Law of Demeter is not violated
    public void processUser(User user) {
        if (user != null) {
            Address address = user.getAddress(); // Direct access to related objects, not violating Law of Demeter
            System.out.println("Processing user at address: " + address.getStreet());
        }
    }

    // [ ] Uses final modifier to prevent mistaken assignments
    public final void finalizeAction() {
        System.out.println("Final action completed.");
    }

    // Example User class to demonstrate Law of Demeter
    static class User {
        private Address address;

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }

    // Example Address class
    static class Address {
        private String street;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CodeChecklist checklist = new CodeChecklist("John Doe", 30);
        checklist.logUserAction("Login");

        List<String> items = Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println(checklist.countOccurrences(items));

        List<String> strings = Arrays.asList("short", "longer", "adequate", "tiny");
        System.out.println(checklist.filterStrings(strings, 5));

        checklist.readFile("test.txt");

        User user = new User();
        Address address = new Address();
        address.setStreet("123 Main St");
        user.setAddress(address);
        checklist.processUser(user);
    }
}

