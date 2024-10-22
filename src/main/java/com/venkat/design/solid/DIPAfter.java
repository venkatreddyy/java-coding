package com.venkat.design.solid;

// Define an abstraction (Database interface) (follows DIP)
interface Database {
    void connect(); // Abstract method for connecting to any database
}

// MySQLDatabase implements the Database interface
class MySQLDatabase1 implements Database {
    public void connect() {
        System.out.println("Connected to MySQL database.");
    }
}

// PostgreSQLDatabase can be swapped in without changes to PaymentService
class PostgreSQLDatabase implements Database {
    public void connect() {
        System.out.println("Connected to PostgreSQL database.");
    }
}

// PaymentService now depends on the abstraction (Database interface) (follows DIP)
class PaymentService3 {
    private Database database;

    // Constructor injection for flexibility (Dependency Inversion)
    public PaymentService3(Database database) {
        this.database = database; // Dependency is injected, not hardcoded
    }

    public void processPayment() {
        database.connect();  // Call to the abstracted connect method
        System.out.println("Processing payment.");
    }
}

public class DIPAfter {
    public static void main(String[] args) {
        Database mySQL = new MySQLDatabase1();
        PaymentService3 paymentService = new PaymentService3(mySQL); // Inject MySQL dependency
        paymentService.processPayment(); // Works with MySQL

        Database postgreSQL = new PostgreSQLDatabase();
        paymentService = new PaymentService3(postgreSQL);  // Inject PostgreSQL dependency
        paymentService.processPayment(); // Now works with PostgreSQL
    }
}

