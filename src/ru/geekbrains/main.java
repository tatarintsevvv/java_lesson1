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

    public static void main(String args[]) {

        long startTime, endTime;

        // 6.2
        Person person1 = new Person("Robot1", 1, 25);
        Person person2 = new Person("Robot2", 2, 35);
        Person person3 = new Person("Robot3", 3, 45);
        Person person4 = new Person("Robot4", 4, 55);

        Tree tree = new Tree();
        //6.3
        tree.insert(person1);
        tree.insert(person2);
        tree.insert(person3);
        tree.insert(person4);

        startTime = System.nanoTime();
        Node found = tree.find(2);
        endTime = System.nanoTime();
        System.out.println("Удаление прошло за " + (endTime - startTime));

        // 6.4
        startTime = System.nanoTime();
        tree.directOrder(tree.getRoot());
        endTime = System.nanoTime();
        System.out.println("Прямой метод обхода прошел за " + (endTime - startTime));
        startTime = System.nanoTime();
        tree.backOrder(tree.getRoot());
        endTime = System.nanoTime();
        System.out.println("Обратный метод обхода прошел за " + (endTime - startTime));
        startTime = System.nanoTime();
        tree.inOrder(tree.getRoot());
        endTime = System.nanoTime();
        System.out.println("Симметричный метод обхода прошел за " + (endTime - startTime));

        startTime = System.nanoTime();
        Node minNode = tree.min();
        endTime = System.nanoTime();
        System.out.println("Поиск минимального значения прошел за " + (endTime - startTime));
        startTime = System.nanoTime();
        Node maxNode = tree.max();
        endTime = System.nanoTime();
        System.out.println("Поиск максимального значения прошел за " + (endTime - startTime));

        // 6.5
        startTime = System.nanoTime();
        tree.delete(2);
        endTime = System.nanoTime();
        System.out.println("Удаление прошло за " + (endTime - startTime));


        method_6_6();

    }

    public static void method_6_6() {
        long startTime, endTime;
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(25);
        }
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        startTime = System.nanoTime();
        Arrays.sort(arr1);
        endTime = System.nanoTime();
        System.out.println("Штатная сортировка прошла за " + (endTime - startTime));
        MyHeap myHeap = new MyHeap();
        startTime = System.nanoTime();
        myHeap.sort(arr);
        endTime = System.nanoTime();
        System.out.println("Пирамидальная сортировка прошла за " + (endTime - startTime));
    }

}
