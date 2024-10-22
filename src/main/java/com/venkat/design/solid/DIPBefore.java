package com.venkat.design.solid;

// PaymentService depends directly on MySQLDatabase (violates DIP)
class MySQLDatabase {
    public void connect() {
        System.out.println("Connected to MySQL database.");
    }
}

class PaymentService2 {
    private MySQLDatabase database = new MySQLDatabase(); // Tight coupling (violates DIP)

    public void processPayment() {
        database.connect();  // Direct dependency on MySQL
        System.out.println("Processing payment.");
    }
}

public class DIPBefore {
    public static void main(String[] args) {
        PaymentService2 paymentService = new PaymentService2();
        paymentService.processPayment(); // PaymentService tightly coupled to MySQL
    }
}

