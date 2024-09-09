package com.venkat.designpatterns.creational;

// Payment Interface
interface PaymentGatewayFM {
    void processPayment(double amount);
}

// Concrete Implementations
class PayPalPaymentFM implements PaymentGatewayFM {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal (Factory Method).");
    }
}

class StripePaymentFM implements PaymentGatewayFM {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe (Factory Method).");
    }
}

// Factory Method
abstract class PaymentGatewayFactoryFM {
    public abstract PaymentGatewayFM createPaymentGateway();
}

// Concrete Factories
class PayPalFactoryFM extends PaymentGatewayFactoryFM {
    @Override
    public PaymentGatewayFM createPaymentGateway() {
        return new PayPalPaymentFM();
    }
}

class StripeFactoryFM extends PaymentGatewayFactoryFM {
    @Override
    public PaymentGatewayFM createPaymentGateway() {
        return new StripePaymentFM();
    }
}

// Usage
public class FactoryMethodExample {
    public static void main(String[] args) {
        PaymentGatewayFactoryFM factory = new PayPalFactoryFM();
        PaymentGatewayFM paymentGateway = factory.createPaymentGateway();
        paymentGateway.processPayment(100.0);
    }
}
