package ru.geekbrains;


// 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся). Найти и вывести
// список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое
// слово.
// 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот
// телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по
// фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
// запросе такой фамилии должны выводиться все телефоны.

import java.util.Arrays;
import java.util.Random;

class Main {
    public static void main(String args[]) {

        // задача 5.4
        long startTime , endTime;

        startTime = System.nanoTime();
        RecursiveMethod(0);
        endTime = System.nanoTime();
        System.out.println("Рекурсия сработала за " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i <100; i++) {

        }
        endTime = System.nanoTime();
        System.out.println("Цикл сработал за " + (endTime - startTime));

        // задача 5.5
        Random random = new Random();
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(15);
        }
        Arrays.sort(arr);

        // рекурсивный поиск
        int index = arr.length;
        startTime = System.nanoTime();
        index = RecursiveBinarySearch(arr, 4, 0, arr.length - 1);
        endTime = System.nanoTime();
        System.out.println("Рекурсия сработала за " + (endTime - startTime));

        index = arr.length;
        startTime = System.nanoTime();
        index = Arrays.binarySearch(arr, 4);
        endTime = System.nanoTime();
        System.out.println("Стандартный поиск сработал за " + (endTime - startTime));

        // задача 5.6
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(15);
        }

        // рекурсивная сортировка методом замещения
        index = arr.length;
        startTime = System.nanoTime();
        sortMerge(Arrays.copyOf(arr, arr.length));
        endTime = System.nanoTime();
        System.out.println("Рекурсивнкая сортировка методом замещения сработала за " + (endTime - startTime));

        // стандартная сортировка
        index = arr.length;
        startTime = System.nanoTime();
        Arrays.sort(Arrays.copyOf(arr, arr.length));
        endTime = System.nanoTime();
        System.out.println("Стандартная сортировка сработалв за " + (endTime - startTime));


    }

    public static int[] sortMerge(int[] arr) {
        int len = arr.length;
        if(len < 2)
            return arr;
        int middle = len/2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;


        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if(aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
            }
            if(bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
            }
        }
        return result;
    }

    public static int RecursiveMethod(int num) {
        if(num < 100)
            return RecursiveMethod(num + 1);
        else
            return num;
    }

    public static int RecursiveBinarySearch(int[] arr, int searchValue, int low, int high) {
        if(low > high)
            return arr.length;
        if(arr[low] == searchValue)
            return low;
        int index = (low + high)/2;
        if(arr[index] > searchValue)
            return RecursiveBinarySearch(arr, searchValue, index + 1, high);
        else
            return RecursiveBinarySearch(arr, searchValue, low, index);
    }
}
