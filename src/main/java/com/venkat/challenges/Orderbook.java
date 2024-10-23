package com.venkat.challenges;

import java.util.*;

class Order {
    String orderId;  // Order ID to uniquely identify the order
    double price;    // Price of the order
    int qty;         // Quantity of the order
    long timestamp;  // Timestamp to track when the order was inserted

    // Constructor to initialize the Order object with provided parameters
    public Order(String orderId, double price, int qty, long timestamp) {
        this.orderId = orderId; // Assign order ID
        this.price = price;     // Assign price
        this.qty = qty;         // Assign quantity
        this.timestamp = timestamp; // Assign timestamp
    }

    // Override toString method to display the order in a readable format
    @Override
    public String toString() {
        return "(" + orderId + ", " + price + ", " + qty + ")";
    }
}

class Orderbook {
    // PriorityQueue to store orders, automatically sorted based on price and timestamp
    private final PriorityQueue<Order> orderQueue;

    // HashMap to store orders for quick access and deletion by order ID
    private final Map<String, Order> orderMap;

    // Counter to generate unique timestamps for each order insertion (acts like an internal clock)
    private long timestampCounter;

    // Constructor to initialize the Orderbook
    public Orderbook() {
        // Custom comparator to prioritize orders by price (higher first) and then timestamp (earlier first if prices are equal)
        this.orderQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.price == o2.price) {
                // If prices are the same, compare by timestamp (earlier orders come first)
                return Long.compare(o1.timestamp, o2.timestamp);
            }
            // Otherwise, compare by price (higher price comes first)
            return Double.compare(o2.price, o1.price);
        });

        // Initialize HashMap to store orders by their ID for fast lookup
        this.orderMap = new HashMap<>();

        // Initialize timestamp counter to 0 (increments with each order insertion)
        this.timestampCounter = 0;
    }

    // Method to insert a new order into the orderbook
    public void insertOrder(String orderId, double price, int qty) {
        // Create a new order with a unique timestamp (using the current timestampCounter value)
        Order order = new Order(orderId, price, qty, timestampCounter++);
        // Add the order to the priority queue
        orderQueue.add(order);
        // Store the order in the HashMap for quick lookup by its ID
        orderMap.put(orderId, order);
    }

    // Method to remove an order by its ID
    public void removeOrder(String orderId) {
        // Remove the order from the HashMap (if it exists)
        Order order = orderMap.remove(orderId);
        if (order != null) {
            // If the order was found, remove it from the priority queue
            orderQueue.remove(order);
        }
    }

    // Method to retrieve all orders sorted by priority (price and timestamp)
    public List<Order> retrieveAllOrdersByPriority() {
        // Create a new list containing all elements in the priority queue
        List<Order> orders = new ArrayList<>(orderQueue);
        // Sort the orders based on the priority (by price and timestamp)
        orders.sort(orderQueue.comparator());
        // Return the sorted list of orders
        return orders;
    }

    // Main method to demonstrate the functionality of the Orderbook class
    public static void main(String[] args) {
        // Create a new Orderbook instance
        Orderbook orderbook = new Orderbook();

        // Insert three orders with different prices and quantities
        orderbook.insertOrder("o1", 3.4, 100);
        orderbook.insertOrder("o2", 3.5, 110);
        orderbook.insertOrder("o3", 3.4, 200);

        // Retrieve and print all orders sorted by priority
        System.out.println("All Orders by Priority: " + orderbook.retrieveAllOrdersByPriority());

        // Remove the order with ID "o1"
        orderbook.removeOrder("o1");

        // Retrieve and print the orders again to verify "o1" was removed
        System.out.println("All Orders by Priority after removing o1: " + orderbook.retrieveAllOrdersByPriority());
    }
}

