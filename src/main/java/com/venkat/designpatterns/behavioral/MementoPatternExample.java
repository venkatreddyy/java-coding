package com.venkat.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

// Memento Class
class OrderMemento {
    private String state;

    public OrderMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator Class
class OrderOriginator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public OrderMemento saveStateToMemento() {
        return new OrderMemento(state);
    }

    public void getStateFromMemento(OrderMemento memento) {
        state = memento.getState();
    }

    public String getState() {
        return state;
    }
}

// Caretaker Class
class OrderCaretaker {
    private List<OrderMemento> mementoList = new ArrayList<>();

    public void add(OrderMemento state) {
        mementoList.add(state);
    }

    public OrderMemento get(int index) {
        return mementoList.get(index);
    }
}

// Usage
public class MementoPatternExample {
    public static void main(String[] args) {
        OrderOriginator order = new OrderOriginator();
        OrderCaretaker caretaker = new OrderCaretaker();

        order.setState("Order Created");
        caretaker.add(order.saveStateToMemento());

        order.setState("Order Processed");
        caretaker.add(order.saveStateToMemento());

        order.setState("Order Shipped");
        caretaker.add(order.saveStateToMemento());

        System.out.println("Current State: " + order.getState());
        order.getStateFromMemento(caretaker.get(0));
        System.out.println("Restored State: " + order.getState());
    }
}

