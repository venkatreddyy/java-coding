package com.venkat.design.solid;

// Define an abstract class for different payment types (follows OCP)
abstract class Payment {
    abstract void process(); // Common interface for processing payment
}

// Concrete class for credit card payment
class CreditCardPayment extends Payment {
    public void process() {
        System.out.println("Processing credit card payment.");
    }
}

// Concrete class for PayPal payment
class PayPalPayment extends Payment {
    public void process() {
        System.out.println("Processing PayPal payment.");
    }
}

// The service now processes any payment without modification (follows OCP)
class PaymentService1 {
    public void processPayment(Payment payment) {
        payment.process(); // Calls process on the specific payment type
    }
}

public class OCPAfter {
    public static void main(String[] args) {
        PaymentService1 paymentService = new PaymentService1();
        Payment creditCard = new CreditCardPayment();  // Create credit card payment
        Payment paypal = new PayPalPayment();          // Create PayPal payment

        paymentService.processPayment(creditCard);     // Processes credit card
        paymentService.processPayment(paypal);         // Processes PayPal
    }
}

