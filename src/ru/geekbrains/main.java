package ru.geekbrains;


// 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся). Найти и вывести
// список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое
// слово.
// 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот
// телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по
// фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
// запросе такой фамилии должны выводиться все телефоны.

import java.util.*;

class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String args[]) {

        methodWithoutThreads();

        methodWithThreads();
    }

    public static void methodWithoutThreads() {
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1.f);
        long startTimeMills = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) *
                    Math.cos(0.4f + i/2));
        }
        System.out.println("Время работы метода без потоков " + (System.currentTimeMillis() - startTimeMills));

    }

    public static void methodWithThreads() {
        float[] arr = new float[SIZE];
        float[] arr1, arr2;
        arr1 = new float[HALF];
        arr2 = new float[HALF];
        Arrays.fill(arr, 1.f);
        long startTimeMills = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        Thread1 thread1 = new Thread1(arr1);
        Thread1 thread2 = new Thread1(arr2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch(InterruptedException e) {}
        // делаем обратную склейку
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        System.out.println("Время работы метода с потоками " + (System.currentTimeMillis() - startTimeMills));

    }

}
