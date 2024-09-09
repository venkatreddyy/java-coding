package com.venkat.designpatterns.behavioral;

// Mediator Interface
interface OrderMediator {
    void notify(Component component, String event);
}

// Abstract Component
abstract class Component {
    protected OrderMediator mediator;

    public Component(OrderMediator mediator) {
        this.mediator = mediator;
    }
}

// Concrete Components
class PaymentComponent extends Component {
    public PaymentComponent(OrderMediator mediator) {
        super(mediator);
    }

    public void processPayment() {
        System.out.println("Processing payment...");
        mediator.notify(this, "payment");
    }
}

class ShippingComponent extends Component {
    public ShippingComponent(OrderMediator mediator) {
        super(mediator);
    }

    public void shipOrder() {
        System.out.println("Shipping order...");
        mediator.notify(this, "shipping");
    }
}

// Concrete Mediator
class OrderMediatorImpl implements OrderMediator {
    private PaymentComponent payment;
    private ShippingComponent shipping;

    public void setPayment(PaymentComponent payment) {
        this.payment = payment;
    }

    public void setShipping(ShippingComponent shipping) {
        this.shipping = shipping;
    }

    @Override
    public void notify(Component component, String event) {
        if (event.equals("payment")) {
            System.out.println("Payment completed. Proceeding to shipping.");
            shipping.shipOrder();
        }
    }
}

// Usage
public class MediatorPatternExample {
    public static void main(String[] args) {
        OrderMediatorImpl mediator = new OrderMediatorImpl();

        PaymentComponent payment = new PaymentComponent(mediator);
        ShippingComponent shipping = new ShippingComponent(mediator);

        mediator.setPayment(payment);
        mediator.setShipping(shipping);

        payment.processPayment();
    }
}

