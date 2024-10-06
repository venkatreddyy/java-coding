package com.venkat.challenges;

import java.util.ArrayList;
import java.util.List;

class Order {
    String orderId;
    double price;
    int qty;


    public Order(String orderId, double price, int qty) {
        this.orderId = orderId;
        this.price = price;
        this.qty = qty;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

public class OrderBook {
    // Use an ArrayList to store the orders
    private final List<Order> ordersList = new ArrayList<>();


    public void insertOrder(String orderId, double price, int qty) {
        Order order = new Order(orderId, price, qty);
        ordersList.add(order); // Add the new order to the list
    }


    public void removeOrder(String orderId) {
        // Use removeIf to safely remove orders based on a condition
        ordersList.removeIf(order -> order.getOrderId().equals(orderId));
    }

    public List<Order> retrieveAllOrdersByPriority() {
        // Sort orders based on price (highest price first)
        ordersList.sort((o1, o2) -> Double.compare(o2.price, o1.price));
        return ordersList;
    }

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

