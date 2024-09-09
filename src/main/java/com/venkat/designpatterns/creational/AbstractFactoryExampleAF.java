package com.venkat.designpatterns.creational;

// PaymentGateway and Discount interfaces
interface PaymentGatewayAF {
    void processPayment(double amount);
}

interface DiscountStrategyAF {
    double applyDiscount(double amount);
}

// Concrete Implementations for PayPal and Stripe
class PayPalPaymentAF implements PaymentGatewayAF {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " (Abstract Factory).");
    }
}

class StripePaymentAF implements PaymentGatewayAF {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Stripe payment of $" + amount + " (Abstract Factory).");
    }
}

// Discount strategies
class BlackFridayDiscountAF implements DiscountStrategyAF {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.75; // 25% off
    }
}

class NoDiscountAF implements DiscountStrategyAF {
    @Override
    public double applyDiscount(double amount) {
        return amount;
    }
}

// Abstract Factory
interface ECommerceFactoryAF {
    PaymentGatewayAF createPaymentGateway();
    DiscountStrategyAF createDiscountStrategy();
}

// Concrete Factories
class PayPalECommerceFactoryAF implements ECommerceFactoryAF {
    @Override
    public PaymentGatewayAF createPaymentGateway() {
        return new PayPalPaymentAF();
    }
    @Override
    public DiscountStrategyAF createDiscountStrategy() {
        return new BlackFridayDiscountAF();
    }
}

class StripeECommerceFactoryAF implements ECommerceFactoryAF {
    @Override
    public PaymentGatewayAF createPaymentGateway() {
        return new StripePaymentAF();
    }
    @Override
    public DiscountStrategyAF createDiscountStrategy() {
        return new NoDiscountAF();
    }
}

// Usage
public class AbstractFactoryExampleAF {
    public static void main(String[] args) {
        ECommerceFactoryAF factory = new PayPalECommerceFactoryAF();
        PaymentGatewayAF paymentGateway = factory.createPaymentGateway();
        DiscountStrategyAF discountStrategy = factory.createDiscountStrategy();

        double amount = 200.0;
        amount = discountStrategy.applyDiscount(amount);
        paymentGateway.processPayment(amount);
    }
}

