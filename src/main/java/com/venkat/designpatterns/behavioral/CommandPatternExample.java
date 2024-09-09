package com.venkat.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
The Command Pattern is used to encapsulate requests as objects, allowing you to parameterize clients with operations.
In this example, the OrderCommand interface defines  execute() method.
We have two concrete commands: PaymentCommand and ShippingCommand, which perform specific tasks on the OrderCMD object,
such as processing payments or shipping orders. The OrderInvoker class collects these commands and executes them
when needed. This pattern decouples the object that invokes the operation (invoker) from the object that knows
how to perform it, making the system more flexible and maintainable.
 */

// Command Interface
// This interface defines the common method 'execute' that all concrete commands must implement.
interface OrderCommand {
    void execute();
}

// Concrete Command for Payment
// This class encapsulates the payment action as a command.
class PaymentCommand implements OrderCommand {
    private OrderCMD order;

    public PaymentCommand(OrderCMD order) {
        this.order = order;
    }

    @Override
    public void execute() {
        // Calls the 'processPayment' method of the OrderCMD object
        order.processPayment();
    }
}

// Concrete Command for Shipping
// This class encapsulates the shipping action as a command.
class ShippingCommand implements OrderCommand {
    private OrderCMD order;

    public ShippingCommand(OrderCMD order) {
        this.order = order;
    }

    @Override
    public void execute() {
        // Calls the 'shipOrder' method of the OrderCMD object
        order.shipOrder();
    }
}

// Receiver Class
// The 'OrderCMD' class contains the actual business logic for payment processing and shipping.
class OrderCMD {
    public void processPayment() {
        System.out.println("Processing payment.");
    }

    public void shipOrder() {
        System.out.println("Shipping order.");
    }
}

// Invoker Class
// The 'OrderInvoker' class collects commands and triggers them when needed.
class OrderInvoker {
    private List<OrderCommand> commandList = new ArrayList<>();

    // Add a command to the list
    public void addCommand(OrderCommand command) {
        commandList.add(command);
    }

    // Execute all the commands in the list and then clear it
    public void executeCommands() {
        for (OrderCommand command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}

// Client Code (Usage)
// This class demonstrates the use of the Command Pattern by creating commands and invoking them.
public class CommandPatternExample {
    public static void main(String[] args) {
        // Create an order (Receiver)
        OrderCMD order = new OrderCMD();

        // Create commands for payment and shipping
        OrderCommand paymentCommand = new PaymentCommand(order);
        OrderCommand shippingCommand = new ShippingCommand(order);

        // Create an invoker to hold and execute the commands
        OrderInvoker invoker = new OrderInvoker();
        invoker.addCommand(paymentCommand);
        invoker.addCommand(shippingCommand);

        // Execute all the commands added to the invoker
        invoker.executeCommands();
    }
}
