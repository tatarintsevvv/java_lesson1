package ru.geekbrains;

// исключение для операций когда массив пуст
class SimpleStackEmptyException extends RuntimeException {}

// класс простого стека на основе массива целых чисел, поэтому исключение для операции push
// когда массив заполнен полностью
class SimpleStackFullException extends RuntimeException {}

public class SimpleStack {
    int[] arr;
    int count;

    public SimpleStack(int maxSize) {
        arr = new int[maxSize];
        count = 0;
    }

    void push(int elem) {
        if(count < arr.length) {
            arr[count++] = elem;
        } else {
            throw new SimpleStackFullException();
        }
    }

    int pop() {
        if(count > 0) {
            return arr[--count];
        } else {
            throw new SimpleStackEmptyException();
        }
    }

    int peek() {
        if(count > 0) {
            return arr[count];
        } else {
            throw new SimpleStackEmptyException();
        }
    }

    boolean isEmpty() {
        return (this.count == 0);
    }

    boolean isFull() {
        return (count == arr.length);
    }
}
