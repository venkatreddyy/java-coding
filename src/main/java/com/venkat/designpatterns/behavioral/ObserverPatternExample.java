package com.venkat.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

// Subject (Observable)
class Order {
    private List<Observer> observers = new ArrayList<>();
    private String status;

    // Method to register an observer
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // Method to remove an observer
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Method to notify all observers about the order status change
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }

    // Method to update the order status
    public void setStatus(String status) {
        this.status = status;
        System.out.println("Order Status changed to: " + status);
        notifyObservers();  // Notify all registered observers
    }
}

// Observer interface
interface Observer {
    void update(String status);
}

// Concrete Observer: CustomerNotification
class CustomerNotification implements Observer {
    @Override
    public void update(String status) {
        System.out.println("Customer Notification: Your order status is now " + status);
    }
}

// Concrete Observer: Inventory
class Inventory implements Observer {
    @Override
    public void update(String status) {
        System.out.println("Inventory System: Order status changed to " + status + ". Updating inventory records.");
    }
}

// Usage Example
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create the subject (order)
        Order order = new Order();

        // Create observers (CustomerNotification and Inventory)
        CustomerNotification customerNotification = new CustomerNotification();
        Inventory inventory = new Inventory();

        // Register observers with the subject (order)
        order.registerObserver(customerNotification);
        order.registerObserver(inventory);

        // Change order status, which automatically notifies the observers
        order.setStatus("Processing");
        order.setStatus("Shipped");
    }
}
