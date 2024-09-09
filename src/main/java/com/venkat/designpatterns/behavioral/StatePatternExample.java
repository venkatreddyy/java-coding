package com.venkat.designpatterns.behavioral;

// State Interface
interface State {
    void handleRequest();
}

// Concrete State A
class ConcreteStateA implements State {
    @Override
    public void handleRequest() {
        System.out.println("Handling request in ConcreteStateA.");
    }
}

// Concrete State B
class ConcreteStateB implements State {
    @Override
    public void handleRequest() {
        System.out.println("Handling request in ConcreteStateB.");
    }
}

// Context Class
class ContextState {
    private State state;

    public ContextState(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest();
    }
}

// Usage
public class StatePatternExample {
    public static void main(String[] args) {
        ContextState context = new ContextState(new ConcreteStateA());
        context.request(); // ConcreteStateA handling the request

        context.setState(new ConcreteStateB());
        context.request(); // ConcreteStateB handling the request
    }
}

