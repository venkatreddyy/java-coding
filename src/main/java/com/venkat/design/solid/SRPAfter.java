package com.venkat.design.solid;

// Class dedicated to order processing only (follows SRP)
class Order1 {
    public void processOrder() {
        System.out.println("Order is being processed.");
        // logic for processing the order
    }
}

// Separate class for handling email notifications (follows SRP)
class EmailService {
    public void sendEmailNotification() {
        System.out.println("Email notification sent.");
        // logic for sending email
    }
}

public class SRPAfter {
    public static void main(String[] args) {
        Order1 order = new Order1();
        EmailService emailService = new EmailService();

        order.processOrder();              // Processes order (order class responsibility)
        emailService.sendEmailNotification(); // Sends email (handled by a different class)
    }
}

