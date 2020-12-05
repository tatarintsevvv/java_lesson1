package ru.geekbrains;

import java.util.LinkedList;

public class CustomQueue<T> {
    private LinkedList<T> list;

    public CustomQueue() {
        list = new LinkedList<>();
    }

    void push(T elem) {
        list.addLast(elem);
    }

    T peek() {
        return list.getLast();
    }

    T pop() {
        return list.removeFirst();
    }

    boolean isEmpty() {
        return (list.size() == 0);
    }
}
