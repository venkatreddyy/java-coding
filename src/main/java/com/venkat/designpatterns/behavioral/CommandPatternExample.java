package com.venkat.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

// Command Interface
interface OrderCommand {
    void execute();
}

// Concrete Command for Payment
class PaymentCommand implements OrderCommand {
    private OrderCMD order;

    public PaymentCommand(OrderCMD order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.processPayment();
    }
}

// Concrete Command for Shipping
class ShippingCommand implements OrderCommand {
    private OrderCMD order;

    public ShippingCommand(OrderCMD order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.shipOrder();
    }
}

// Order Class
class OrderCMD {
    public void processPayment() {
        System.out.println("Processing payment.");
    }

    public void shipOrder() {
        System.out.println("Shipping order.");
    }
}

// Invoker Class
class OrderInvoker {
    private List<OrderCommand> commandList = new ArrayList<>();

    public void addCommand(OrderCommand command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for (OrderCommand command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}

// Usage
public class CommandPatternExample {
    public static void main(String[] args) {
        OrderCMD order = new OrderCMD();

        OrderCommand paymentCommand = new PaymentCommand(order);
        OrderCommand shippingCommand = new ShippingCommand(order);

        OrderInvoker invoker = new OrderInvoker();
        invoker.addCommand(paymentCommand);
        invoker.addCommand(shippingCommand);

        invoker.executeCommands();
    }
}

