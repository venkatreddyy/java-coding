package com.venkat.design.solid;

// A PaymentService class that directly handles payment types, violating OCP
class PaymentService {
    // Method handles all payment types (needs modification for new types)
    public void processPayment(String type) {
        if (type.equals("creditCard")) {
            System.out.println("Processing credit card payment.");
        } else if (type.equals("paypal")) {
            System.out.println("Processing PayPal payment.");
        }
    }
}

public class OCPBefore {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("creditCard");
        paymentService.processPayment("paypal");
    }
}

