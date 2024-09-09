package com.venkat.designpatterns.sturctural;

// Subsystems
class Inventory {
    public void updateInventory() {
        System.out.println("Inventory updated.");
    }
}

class Payment {
    public void processPayment(double amount) {
        System.out.println("Payment of $" + amount + " processed.");
    }
}

class Shipping {
    public void shipOrder() {
        System.out.println("Order shipped.");
    }
}

// Facade
class OrderFacade {
    private Inventory inventory = new Inventory();
    private Payment payment = new Payment();
    private Shipping shipping = new Shipping();

    public void processOrder(double amount) {
        payment.processPayment(amount);
        inventory.updateInventory();
        shipping.shipOrder();
    }
}

// Usage
public class FacadePatternExample {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.processOrder(150.0);
    }
}

