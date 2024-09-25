package com.venkat;

import java.util.*;

import java.util.*;

class Order {
    String orderId;
    double price;
    int qty;

    // Constructor for the Order class
    public Order(String orderId, double price, int qty) {
        this.orderId = orderId;
        this.price = price;
        this.qty = qty;
    }
}

public class OrderBook {
    // Use an ArrayList to store the orders
    private List<Order> ordersList = new ArrayList<>();

    // Insert order
    public void insertOrder(String orderId, double price, int qty) {
        Order order = new Order(orderId, price, qty);
        ordersList.add(order); // Add the new order to the list
    }

    // Remove order
    public void removeOrder(String orderId) {
        // Use Iterator to safely remove orders while iterating
        Iterator<Order> iterator = ordersList.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.orderId.equals(orderId)) {
                iterator.remove(); // Remove the matching order by orderId
                break;
            }
        }
    }

    // Retrieve all orders sorted by price (highest price first)
    public List<Order> retrieveAllOrdersByPriority() {
        // Sort orders based on price (highest price first)
        ordersList.sort((o1, o2) -> Double.compare(o2.price, o1.price));
        return ordersList;
    }

    // Utility method to print orders
    public void printOrders() {
        List<Order> orders = retrieveAllOrdersByPriority();
        for (Order order : orders) {
            System.out.println("(" + order.orderId + ", " + order.price + ", " + order.qty + ")");
        }
    }

    public static void main(String[] args) {
        OrderBook orderbook = new OrderBook();

        // Insert some orders
        orderbook.insertOrder("o1", 3.4, 100);
        orderbook.insertOrder("o2", 3.5, 110);
        orderbook.insertOrder("o3", 3.4, 200);

        System.out.println("Orders after insertion:");
        orderbook.printOrders(); // Should print: [(o2, 3.5, 110), (o1, 3.4, 100), (o3, 3.4, 200)]

        // Remove an order
        orderbook.removeOrder("o1");

        System.out.println("Orders after removing o1:");
        orderbook.printOrders(); // Should print: [(o2, 3.5, 110), (o3, 3.4, 200)]
    }
}

