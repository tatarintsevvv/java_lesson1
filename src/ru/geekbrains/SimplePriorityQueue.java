package ru.geekbrains;

import java.util.Comparator;

// исключение при отсутсвии метода compare в классе T
class SimplePriorityQueueEmptyCompareNotFound extends RuntimeException {}

// исключение для операций когда массив пуст
class SimplePriorityQueueEmptyException extends RuntimeException {}

// класс приоритетной очереди на основе массива целых чисел, поэтому исключение для операции push
// когда массив заполнен полностью
class SimplePriorityQueueFullException extends RuntimeException {}

public class SimplePriorityQueue<T> {
    private T[] arr;
    private int front; // номер первого элемента в очереди
    private int rear; // номер последнего элемента в очереди
    private int count; // количество элементов
    // максимальный размер == arr.ength


    public SimplePriorityQueue(int maxSize) {
            arr = (T[]) new Object[maxSize];
            front = 0;
//            rear = -1;
            count = 0;
    }

    void push(T elem) {
        if((elem instanceof Comparable) || (elem instanceof Comparator)) {
            if(count < arr.length) {
                int pos = front;
                int i = count;
                for (; i > 0; i--) {
                    if(elem instanceof Comparator) {
                        if(((Comparator)elem).compare(elem, arr[pos]) < 0)
                            break;
                    }
                    else if(elem instanceof Comparable) {
                        if(((Comparable)elem).compareTo(arr[pos]) < 0)
                            break;
                    }
                    pos++;
                    if(pos >= arr.length)
                        pos = 0;
                }
                T value = elem;
                for (; i > 0 ; i--) {
                    T temp = arr[pos];
                    arr[pos++] = value;
                    value = temp;
                    if(pos >= arr.length)
                        pos = 0;
                }
                arr[pos] = value;
                count++;
            } else {
                throw new SimpleQueueFullException();
            }
        } else
            throw new SimplePriorityQueueEmptyCompareNotFound();
    }

    T peek() {
        if(count > 0)
            return arr[front];
        else
            throw new SimpleQueueEmptyException();
    }

    T pop() {
        if(count > 0) {
            T res = arr[front++];
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
