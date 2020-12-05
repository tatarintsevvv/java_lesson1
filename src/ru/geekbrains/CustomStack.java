package ru.geekbrains;

import java.util.LinkedList;

public class CustomStack<T> {
    private LinkedList<T> list;
    public CustomStack() {
        list = new LinkedList<>();
    }

    void push(T elem) {
        list.addLast(elem);
    }

    T pop() {
        return list.removeLast();
    }

    T peek() {
        return list.getLast();
    }

    boolean isEmpty() {
        return (list.size() == 0);
    }

}
