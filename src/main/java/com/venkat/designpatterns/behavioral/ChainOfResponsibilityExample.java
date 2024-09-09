package com.venkat.designpatterns.behavioral;

// Handler Interface
abstract class DiscountHandler {
    protected DiscountHandler next;

    public void setNext(DiscountHandler next) {
        this.next = next;
    }

    public abstract void applyDiscount(OrderCOR order);
}

// Concrete Handler for Small Discount
class SmallDiscountHandler extends DiscountHandler {
    @Override
    public void applyDiscount(OrderCOR order) {
        if (order.getAmount() <= 100) {
            order.setDiscount("Small Discount Applied");
        } else if (next != null) {
            next.applyDiscount(order);
        }
    }
}

// Concrete Handler for Large Discount
class LargeDiscountHandler extends DiscountHandler {
    @Override
    public void applyDiscount(OrderCOR order) {
        if (order.getAmount() > 100) {
            order.setDiscount("Large Discount Applied");
        }
    }
}

// Order Class
class OrderCOR {
    private double amount;
    private String discount;

    public OrderCOR(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Order Amount: $" + amount + ", Discount: " + discount;
    }
}

// Usage
public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        OrderCOR order = new OrderCOR(120);

        DiscountHandler smallHandler = new SmallDiscountHandler();
        DiscountHandler largeHandler = new LargeDiscountHandler();

        smallHandler.setNext(largeHandler);
        smallHandler.applyDiscount(order);

        System.out.println(order);
    }
}

