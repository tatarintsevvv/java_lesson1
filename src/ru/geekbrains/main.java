package ru.geekbrains;

import java.util.Random;
import java.util.Arrays;

class Sorts {
    public static void main(String args[]) {
        long nanoStartTime, nanoEndTime;

        nanoStartTime = System.nanoTime();
        task1();
        nanoEndTime = System.nanoTime();
        long diff = nanoEndTime - nanoStartTime;
        System.out.println("Первая задача прошла за " + diff);

        task2();
        // задача 2.3

        Random rand = new Random();
        int[] arr = new int[400];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(400);
        }
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        nanoStartTime = System.nanoTime();
        Arrays.sort(arr);
        nanoEndTime = System.nanoTime();
        long standartDiff = nanoEndTime - nanoStartTime;
        System.out.println("Стандартная сортировка прошла за " + standartDiff);

        arr = Arrays.copyOf(arrCopy, arrCopy.length);
        nanoStartTime = System.nanoTime();
        task4(arr);
        nanoEndTime = System.nanoTime();
        diff = nanoEndTime - nanoStartTime;
        System.out.println("Сортировка пузырьком прошла за " + diff);

        arr = Arrays.copyOf(arrCopy, arrCopy.length);
        nanoStartTime = System.nanoTime();
        task5(arr);
        nanoEndTime = System.nanoTime();
        diff = nanoEndTime - nanoStartTime;
        System.out.println("Сортировка методом выбора прошла за " + diff);

        arr = Arrays.copyOf(arrCopy, arrCopy.length);
        nanoStartTime = System.nanoTime();
        task6(arr);
        nanoEndTime = System.nanoTime();
        diff = nanoEndTime - nanoStartTime;
        System.out.println("Сортировка методом вставки прошла за " + diff);

    }

    // метод выполняетзадачу 2.4, сортировка пузырьком
    public static void task4(int[] arr) {
        boolean sorting = false;
        int lastIndex = arr.length;
        while (!sorting) {

            sorting = true;
            for (int i = 1; i < lastIndex; i++) {
                if (arr[i] < arr[i - 1]) {
                    int buff = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = buff;
                    sorting = false;
                }
            }
            lastIndex--;
        }
    }

    // метод выполняет задачу 2.1
    public static void task1() {
        int[] arr;
        int[] arrCopy;
        arr = new int[10];

        // инициализация массива
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }

        // основные операции с массивами
        arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        System.out.println("Unsorted: " + Arrays.toString(arrCopy));
        System.out.println("Sorted: " + Arrays.toString(arr));
        if (Arrays.equals(arr, arrCopy)) {
            System.out.println("Arrays equals");
        }
    }

    // метод выполняет задачу 2.2 (реализация линейного и двоичного алгоритма сортировки)
    public static void task2() {
        int[] arr;
        int[] arrCopy;
        arr = new int[10];
        int searchValue = 5;
        long nanoStartTime, nanoEndTime, diff;

        // инициализация массива
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }
        arrCopy = Arrays.copyOf(arr, arr.length);
        System.out.println("Unsorted: " + Arrays.toString(arrCopy));
        System.out.println("Sorted: " + Arrays.toString(arr));

        // линейная сортировка
        nanoStartTime = System.nanoTime();
        int index = linearSearch(arr, searchValue);
        nanoEndTime = System.nanoTime();
        diff = nanoEndTime - nanoStartTime;
        System.out.println("Линейный поиск прошeл за " + diff);
        System.out.println("Линейный поиск: " + index);

        Arrays.sort(arr);
        nanoStartTime = System.nanoTime();
        index = binarySearch(arr, searchValue);
        nanoEndTime = System.nanoTime();
        diff = nanoEndTime - nanoStartTime;
        System.out.println("Двоичный поиск прошeл за " + diff);
        System.out.println("Двоичный поиск: " + index);
    }

    // линейная сортировка
    public static int linearSearch(int[] arr, int searchValue) {
        int index = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == searchValue) {
                index = i;
                break;
            }
        }
        return index;
    }

    // двоичный поиск
    public static int binarySearch(int[] arr, int searchValue) {
        int index = -1;
        int beginRange = 0;
        int endRange = arr.length - 1;
        int pos;
        while (beginRange <= endRange) {
            pos = (endRange + beginRange) / 2;
            if (arr[pos] == searchValue) {
                index = pos;
                break;
            }
            if (arr[pos] < searchValue) {
                beginRange = pos + 1;
            } else {
                endRange = pos - 1;
            }
        }
        return index;
    }

    // заджание 2.5, сортировка методом выбора
    public static void task5(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (minIndex != i) {
                int buff = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = buff;
            }
        }
    }

    // заджание 2.6, сортировка методом вставки
    public static void task6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int in = i;
            int buff = arr[i];
            while (in > 0 && arr[in - 1] >= buff) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = buff;
        }
    }
}
