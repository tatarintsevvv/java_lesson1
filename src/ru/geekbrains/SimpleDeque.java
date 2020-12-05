package ru.geekbrains;

// исключение для операций когда массив пуст
class SimpleDequeEmptyException extends RuntimeException {}

// класс простой очереди на основе массива целых чисел, поэтому исключение для операции push
// когда массив заполнен полностью
class SimpleDequeFullException extends RuntimeException {}

public class SimpleDeque {
    int[] arr;
    int front; // номер первого элемента в очереди
    // номер последнего элемента в очереди не нужен, рассчитывается из первого и количества
    int count; // количество элементов
    // максимальный размер == arr.ength

    public SimpleDeque(int maxSize) {
        arr = new int[maxSize];
        count = 0;
        front = 0;
    }

    void pushFront(int elem) {
        if(count < arr.length) {
            front--;
            if(front < 0)
                front = arr.length - 1;
            arr[front] = elem;
            count++;
        } else
            throw new SimpleQueueFullException();
    }

    void pushLast(int elem) {
        if(count < arr.length) {
            int pos = front + count;
            if(pos >= arr.length)
                pos -= arr.length;
            arr[pos] = elem;
            count++;
        } else
            throw new SimpleQueueFullException();
    }

    int popFront() {
        if(count > 0) {
            int res = arr[front++];
            if(front >= (arr.length - 1))
                front = 0;
            count--;
            return res;
        } else
            throw new SimpleQueueEmptyException();
    }

    int popLast() {
        if(count > 0) {
            int pos = front + count;
            if(pos >= arr.length)
                pos -= arr.length;
            count--;
            return arr[pos];
        } else
            throw new SimpleQueueEmptyException();
    }

    int peekFront() {
        if(count > 0)
            return arr[front];
        else
            throw new SimpleQueueEmptyException();
    }

    int peekLast() {
        if(count > 0) {
            int pos = front + count;
            if(pos >= arr.length)
                pos -= arr.length;
            return arr[pos];
        }
        else
            throw new SimpleQueueEmptyException();
    }

    boolean isFull() {
        return (count == arr.length);
    }

    boolean isEmpty() {
        return (count == 0);
    }
}
