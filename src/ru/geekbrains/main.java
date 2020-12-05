package ru.geekbrains;

import java.util.*;

class Main {
    public static void main(String args[]) {
        long nanoStartTime, nanoEndTime;

        // задача 4.1
        task4_1();

        // задача 4.2
        task4_2();

        // задача 4.3
        task4_3();

        // задача 4.4
        task4_4();

        // задача 4.5
        task4_5();
    }

    // метод выполняетзадачу 4.1
    public static void task4_1() {
        // создаю массив из задачи 2.1
        int[] arr = new int[15];

        // инициализация массива
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }

        long nanoStartTime, nanoEndTime;
        SimpleStack stack = new SimpleStack(arr.length);
        // провожу заполнение стека согласно сформированного массива
        nanoStartTime = System.nanoTime();
        for (int num: arr) {
            if(!stack.isFull())
                stack.push(num);
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Простой стек заполнен из массива 15 целых за " + (nanoEndTime - nanoStartTime));

        // провожу поэлементное очищение стека
        nanoStartTime = System.nanoTime();
        while(!stack.isEmpty()) {
            int elem = stack.pop();
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Простой стек очищен за " + (nanoEndTime - nanoStartTime));
    }

    // метод выполняетзадачу 4.2
    public static void task4_2() {
        // создаю массив из задачи 2.1
        int[] arr = new int[15];

        // инициализация массива
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }

        long nanoStartTime, nanoEndTime;
        SimpleQueue queue = new SimpleQueue(arr.length);
        // провожу заполнение очереди согласно сформированного массива
        nanoStartTime = System.nanoTime();
        for (int num: arr) {
            if(!queue.isFull())
                queue.push(num);
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Простая очередь заполнена из массива 15 целых за " + (nanoEndTime - nanoStartTime));

        // провожу поэлементное очищение очереди
        nanoStartTime = System.nanoTime();
        while(!queue.isEmpty()) {
            int elem = queue.pop();
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Простая очередь очищена за " + (nanoEndTime - nanoStartTime));
    }

    // метод выполняетзадачу 4.3
    public static void task4_3() {
        // создаю массив из задачи 2.1
        int[] arr = new int[15];

        // инициализация массива
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }

        long nanoStartTime, nanoEndTime;
        SimpleDeque deque = new SimpleDeque(arr.length);
        // провожу заполнение очереди согласно сформированного массива
        nanoStartTime = System.nanoTime();
        for (int num: arr) {
            if(!deque.isFull())
                deque.pushLast(num);
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Дек заполнен вставкой в конце из массива 15 целых за " + (nanoEndTime - nanoStartTime));

        // провожу поэлементное очищение очереди
        nanoStartTime = System.nanoTime();
        while(!deque.isEmpty()) {
            int elem = deque.popLast();
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Дек очищен выборкой сзади за " + (nanoEndTime - nanoStartTime));

        nanoStartTime = System.nanoTime();
        for (int num: arr) {
            if(!deque.isFull())
                deque.pushFront(num);
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Дек заполнен вставкой спереди из массива 15 целых за " + (nanoEndTime - nanoStartTime));

        // провожу поэлементное очищение очереди
        nanoStartTime = System.nanoTime();
        while(!deque.isEmpty()) {
            int elem = deque.popFront();
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Дек очищен выборкой спереди за " + (nanoEndTime - nanoStartTime));
    }

    // метод выполняетзадачу 4.4
    public static void task4_4() {
        // создаю массив из задачи 2.1
        Integer[] arr = new Integer[15];

        // инициализация массива
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }

        long nanoStartTime, nanoEndTime;
        SimplePriorityQueue<Integer> queue = new SimplePriorityQueue<>(arr.length);
        // провожу заполнение очереди согласно сформированного массива
        nanoStartTime = System.nanoTime();
        for (Integer num: arr) {
            if(!queue.isFull())
                queue.push(num);
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Приоритетная очередь заполнена вставкой в конце из массива 15 Integer за " + (nanoEndTime - nanoStartTime));

        // провожу поэлементное очищение очереди
        nanoStartTime = System.nanoTime();
        while(!queue.isEmpty()) {
            Integer elem = queue.pop();
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Приоритетная очередь очищена выборкой сзади за " + (nanoEndTime - nanoStartTime));
    }

    // метод выполняетзадачу 4.5
    public static void task4_5() {
        // создаю массив из задачи 2.1
        Integer[] arr = new Integer[15];

        // инициализация массива
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }

        long nanoStartTime, nanoEndTime;
        CustomQueue<Integer> queue = new CustomQueue<>();
        CustomStack<Integer> stack = new CustomStack<>();

        // провожу заполнение стека согласно сформированного массива
        nanoStartTime = System.nanoTime();
        for (Integer num: arr) {
            stack.push(num);
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Стэк заполнен из массива 15 Integer за " + (nanoEndTime - nanoStartTime));

        // провожу поэлементное очищение очереди
        nanoStartTime = System.nanoTime();
        while(!stack.isEmpty()) {
            Integer elem = stack.pop();
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Стэк очищен за " + (nanoEndTime - nanoStartTime));

        // провожу заполнение очереди согласно сформированного массива
        nanoStartTime = System.nanoTime();
        for (Integer num: arr) {
            queue.push(num);
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Очередь заполнена из массива 15 Integer за " + (nanoEndTime - nanoStartTime));

        // провожу поэлементное очищение очереди
        nanoStartTime = System.nanoTime();
        while(!queue.isEmpty()) {
            Integer elem = queue.pop();
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Очередь очищена сзади за " + (nanoEndTime - nanoStartTime));

    }

}
