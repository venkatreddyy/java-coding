package com.venkat.designpatterns.behavioral;

/*
Explanation:
Strategy Interface (DiscountStrategy):

The interface defines the contract for applying discounts.
Concrete Strategies:
NoDiscountStrategy: No discount is applied.
PercentageDiscountStrategy: A percentage-based discount is applied.
FlatDiscountStrategy: A flat amount is deducted from the total.
Context Class (Order):

The Order class contains the logic for setting and applying a discount strategy at runtime. I
t allows you to dynamically switch strategies based on the requirements.
Usage (StrategyPatternExample):

Demonstrates how to create an Order object and apply different discount strategies dynamically.
 */

// Strategy Interface
interface DiscountStrategy {
    double applyDiscount(double price);
}

// Concrete Strategy: No Discount
class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price; // No discount applied
    }
}

// Concrete Strategy: Percentage Discount
class PercentageDiscountStrategy implements DiscountStrategy {
    private double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * percentage / 100);
    }
}

// Concrete Strategy: Flat Discount
class FlatDiscountStrategy implements DiscountStrategy {
    private double discountAmount;

    public FlatDiscountStrategy(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - discountAmount;
    }
}

// Context class that applies the discount strategy
class Order1 {
    private double price;
    private DiscountStrategy discountStrategy;

    public Order1(double price) {
        this.price = price;
    }

    // Set the discount strategy at runtime
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    // Calculate the final price after applying the discount
    public double calculateFinalPrice() {
        return discountStrategy.applyDiscount(price);
    }
}

// Usage Example: StrategyPatternExample.java
public class StrategyPatternExample {
    public static void main(String[] args) {
        // Create an order with a base price
        Order1 order = new Order1(1000.0);

        // Apply No Discount strategy
        DiscountStrategy noDiscount = new NoDiscountStrategy();
        order.setDiscountStrategy(noDiscount);
        System.out.println("Final price with no discount: $" + order.calculateFinalPrice());

        // Apply Percentage Discount strategy (10%)
        DiscountStrategy percentageDiscount = new PercentageDiscountStrategy(10);
        order.setDiscountStrategy(percentageDiscount);
        System.out.println("Final price with 10% discount: $" + order.calculateFinalPrice());

        // Apply Flat Discount strategy ($100 off)
        DiscountStrategy flatDiscount = new FlatDiscountStrategy(200);
        order.setDiscountStrategy(flatDiscount);
        System.out.println("Final price with $100 discount: $" + order.calculateFinalPrice());
    }
}
