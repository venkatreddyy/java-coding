package com.venkat.design.solid;

// A class that handles both order processing and email notifications (violating SRP)
class Order {
    // Process the order
    public void processOrder() {
        System.out.println("Order is being processed.");
        // logic for processing the order
    }

    // Send email notification (additional responsibility, violating SRP)
    public void sendEmailNotification() {
        System.out.println("Email notification sent.");
        // logic for sending email
    }
}

public class SRPBefore {
    public static void main(String[] args) {
        Order order = new Order();
        order.processOrder();           // Processes order
        order.sendEmailNotification();  // Sends email (violates SRP)
    }
}

