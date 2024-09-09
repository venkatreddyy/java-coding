package com.venkat.designpatterns.sturctural;

// Payment abstraction
abstract class PaymentBridge {
    protected PaymentGatewayBridge paymentGateway;

    public PaymentBridge(PaymentGatewayBridge paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public abstract void makePayment(double amount);
}

// Payment Gateway implementation
interface PaymentGatewayBridge {
    void processPayment(double amount);
}

// Concrete Payment Gateway implementations
class PayPalBridge implements PaymentGatewayBridge {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment through PayPal Bridge: $" + amount);
    }
}

class StripeBridge implements PaymentGatewayBridge {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment through Stripe Bridge: $" + amount);
    }
}

// Concrete abstraction
class OnlinePayment extends PaymentBridge {
    public OnlinePayment(PaymentGatewayBridge paymentGateway) {
        super(paymentGateway);
    }

    @Override
    public void makePayment(double amount) {
        paymentGateway.processPayment(amount);
    }
}

// Usage
public class BridgePatternExample {
    public static void main(String[] args) {
        PaymentBridge payment = new OnlinePayment(new PayPalBridge());
        payment.makePayment(200.0);
    }
}
