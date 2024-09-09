package com.venkat.designpatterns.behavioral;

/*
The State Pattern allows an object to change its behavior based on its current state.
In our example, the OrderState interface defines the common behavior for all order states.
Concrete states like "New", "Processed", "Shipped", and "Delivered" implement this interface,
each with their own specific behavior. The Order class (context) holds a reference to the current state
and uses setState() to switch states at runtime. When processOrder() is called, it delegates to the
current state’s handleOrder() method, making state transitions seamless without complex conditional logic.
 */
// State Interface
interface OrderState {
    void handleOrder();
}


// Concrete State: Processed Order
class ProcessedOrderState implements OrderState {
    @Override
    public void handleOrder() {
        System.out.println("Order is now in PROCESSED state.");
    }
}


// Concrete State: New Order
class NewOrderState implements OrderState {
    @Override
    public void handleOrder() {
        System.out.println("Order is now in NEW state.");
    }
}



// Concrete State: Shipped Order
class ShippedOrderState implements OrderState {
    @Override
    public void handleOrder() {
        System.out.println("Order is now in SHIPPED state.");
    }
}


// Concrete State: Delivered Order
class DeliveredOrderState implements OrderState {
    @Override
    public void handleOrder() {
        System.out.println("Order is now in DELIVERED state.");
    }
}


// Context Class
class Order2 {
    private OrderState currentState;

    public Order2() {
        // Initial state is "New Order"
        this.currentState = new NewOrderState();
    }

    // Set the state dynamically at runtime
    public void setState(OrderState state) {
        this.currentState = state;
    }

    // Trigger the current state's behavior
    public void processOrder() {
        currentState.handleOrder();
    }
}

public class StatePatternExample {
    public static void main(String[] args) {
        // Create an order, initially in the "New" state
        Order2 order = new Order2();

        // Process the order in the "New" state
        order.processOrder(); // Output: Order is now in NEW state.

        // Change state to "Processed"
        order.setState(new ProcessedOrderState());
        order.processOrder(); // Output: Order is now in PROCESSED state.

        // Change state to "Shipped"
        order.setState(new ShippedOrderState());
        order.processOrder(); // Output: Order is now in SHIPPED state.

        // Change state to "Delivered"
        order.setState(new DeliveredOrderState());
        order.processOrder(); // Output: Order is now in DELIVERED state.
    }
}
/*
Order is now in NEW state.
Order is now in PROCESSED state.
Order is now in SHIPPED state.
Order is now in DELIVERED state.
 */
