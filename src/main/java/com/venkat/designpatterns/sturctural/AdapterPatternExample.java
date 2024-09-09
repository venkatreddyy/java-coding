package com.venkat.designpatterns.sturctural;

// Existing Payment Gateway Interface
/*
The Adapter Pattern allows incompatible interfaces to work together. In this example,
OldPayPal implements the legacy OldPaymentGateway interface, while the system now uses the NewPaymentGateway interface.
The PaymentAdapter acts as a bridge, adapting the old payment interface to the new one.
When processPayment() is called on the adapter, it internally uses the pay() method of the old gateway,
making them compatible without changing the existing code. This pattern is useful for integrating old systems into new ones.
 */
interface OldPaymentGateway {
    void pay(String cardDetails, double amount);
}

// New Payment Gateway Interface
interface NewPaymentGateway {
    void processPayment(double amount);
}

// Concrete Implementation of Old Gateway
class OldPayPal implements OldPaymentGateway {
    @Override
    public void pay(String cardDetails, double amount) {
        System.out.println("Processing payment of $" + amount + " using Old PayPal.");
    }
}

// Adapter class to adapt OldPaymentGateway to NewPaymentGateway
class PaymentAdapter implements NewPaymentGateway {
    private OldPaymentGateway oldPaymentGateway;

    public PaymentAdapter(OldPaymentGateway oldPaymentGateway) {
        this.oldPaymentGateway = oldPaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Using a dummy card detail to adapt to the old interface
        oldPaymentGateway.pay("DummyCardDetails", amount);
    }
}

// Usage
public class AdapterPatternExample {
    public static void main(String[] args) {
        OldPaymentGateway oldPayPal = new OldPayPal();
        NewPaymentGateway adapter = new PaymentAdapter(oldPayPal);
        adapter.processPayment(100.0);
    }
}

