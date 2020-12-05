package ru.geekbrains;

// исключение для операций когда массив пуст
class SimpleQueueEmptyException extends RuntimeException {}

// класс простого стека на основе массива целых чисел, поэтому исключение для операции push
// когда массив заполнен полностью
class SimpleQueueFullException extends RuntimeException {}


public class SimpleQueue {
    int[] arr;
    int front; // номер первого элемента в очереди
    int rear; // номер последнего элемента в очереди
    int count; // количество элементов
    // максимальный размер == arr.ength

    public SimpleQueue(int maxSize) {
        arr = new int[maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }

    void push(int elem) {
        if(count < arr.length) {
            arr[++rear] = elem;
            if(rear >= arr.length)
                rear = -1;
            count++;
        } else {
            throw new SimpleQueueFullException();
        }
    }
    
    int peek() {
        if(count > 0)
            return arr[front];
        else
            throw new SimpleQueueEmptyException();
    }
    
    int pop() {
        if(count > 0) {
            int res = arr[front++];
            if(front >= (arr.length - 1))
                front = 0;
            count--;
            return res;
        } else
            throw new SimpleQueueEmptyException();
    }
    
    boolean isFull() {
        return (count == arr.length);
    }

    boolean isEmpty() {
        return (count == 0);
    }
}
