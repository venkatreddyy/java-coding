package com.venkat.designpatterns.behavioral;

// Abstract Class with Template Method
abstract class OrderProcessTemplate {
    public final void processOrder() {
        selectProduct();
        doPayment();
        deliver();
    }

    protected abstract void selectProduct();

    protected abstract void doPayment();

    protected abstract void deliver();
}

// Concrete Implementation A
class OnlineOrder extends OrderProcessTemplate {
    @Override
    protected void selectProduct() {
        System.out.println("Product selected for online order.");
    }

    @Override
    protected void doPayment() {
        System.out.println("Payment made for online order.");
    }

    @Override
    protected void deliver() {
        System.out.println("Online order delivered.");
    }
}

// Concrete Implementation B
class StoreOrder extends OrderProcessTemplate {
    @Override
    protected void selectProduct() {
        System.out.println("Product selected in store.");
    }

    @Override
    protected void doPayment() {
        System.out.println("Payment made in store.");
    }

    @Override
    protected void deliver() {
        System.out.println("In-store order handed over.");
    }
}

// Usage
public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        OrderProcessTemplate onlineOrder = new OnlineOrder();
        onlineOrder.processOrder();

        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder();
    }
}

