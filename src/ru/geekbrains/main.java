package ru.geekbrains;

import java.util.*;

class Main {
    public static void main(String args[]) {
        long nanoStartTime, nanoEndTime;

        // задача 3.1
        List<Integer> list = task1();

        // задача 3.2
        task2(list);

        // задача 3.3
        task3();

        // задача 3.4
        task4();

        // задача 3.5
        task5();


    }

    // метод выполняетзадачу 3.4
    public static void task4() {
        // создаю массиву из задачи 2.1
        Integer[] arr;
        arr = new Integer[10];

        // инициализация массива
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }

        long nanoStartTime, nanoEndTime;

        nanoStartTime = System.nanoTime();
        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;
        for(Integer val: arr) {
            list.add(index, val);
            ++index;
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Преобразование массива в двусвязный список прошло за " + (nanoEndTime - nanoStartTime));

        // операции с двусвязным списком
        // добавление элемента в список
        nanoStartTime = System.nanoTime();
        list.add(20);
        nanoEndTime = System.nanoTime();
        System.out.println("Integer добавлен в двусвязный список за " + (nanoEndTime - nanoStartTime));
        System.out.println("Двуосвязный список после добавления элемента: " + list.toString());

        // установка элемента в списке на позиции 5
        nanoStartTime = System.nanoTime();
        list.set(5, 30);
        nanoEndTime = System.nanoTime();
        System.out.println("Integer установлен в двусвязном списке за " + (nanoEndTime - nanoStartTime));
        System.out.println("Двусвязный список после изменения элемента: " + list.toString());


        // получение элемента списка на позиции 5
        nanoStartTime = System.nanoTime();
        list.get(5);
        nanoEndTime = System.nanoTime();
        System.out.println("Integer получен из двусвязного списка за " + (nanoEndTime - nanoStartTime));

        // удаление из списка элемента с позиции 5
        nanoStartTime = System.nanoTime();
        list.remove(5);
        nanoEndTime = System.nanoTime();
        System.out.println("Integer получен из двусвязного списка за " + (nanoEndTime - nanoStartTime));
        System.out.println("Двусвязный список после удаления элемента: " + list.toString());
    }

    // метод выполняет задачу 3.1
    public static List<Integer> task1() {
        // создаю массиву из задачи 2.1
        Integer[] arr;
        arr = new Integer[10];

        // инициализация массива
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }

        long nanoStartTime, nanoEndTime;

        nanoStartTime = System.nanoTime();
        List<Integer> list = Arrays.asList(arr);
        nanoEndTime = System.nanoTime();
        System.out.println("Преобразование массива в список прошло за " + (nanoEndTime - nanoStartTime));

        nanoStartTime = System.nanoTime();
        Collection<Integer> collection = Arrays.asList(arr);
        nanoEndTime = System.nanoTime();
        System.out.println("Преобразование массива в коллекцию прошло за " + (nanoEndTime - nanoStartTime));

        return list;
    }

    // метод выполняет задачу 3.2
    public static void task2(List<Integer> l) {
        List<Integer> list = l;
        int searchValue = 5;
        long nanoStartTime, nanoEndTime;
        System.out.println("Список до  добавления элемента: " + list.toString());

        /*
        здесь вываливается исключение
        // добавление элемента в список
        nanoStartTime = System.nanoTime();
        Integer valueAdd = 20;
        list.add(0,valueAdd);
        nanoEndTime = System.nanoTime();
        System.out.println("Integer добавлен в список за " + (nanoEndTime - nanoStartTime));
        System.out.println("Список после добавления элемента: " + list.toString());
        */

        // установка элемента в списке на позиции 5
        nanoStartTime = System.nanoTime();
        list.set(5, 30);
        nanoEndTime = System.nanoTime();
        System.out.println("Integer установлен в списке за " + (nanoEndTime - nanoStartTime));
        System.out.println("Список после изменения элемента: " + list.toString());


        // получение элемента списка на позиции 5
        nanoStartTime = System.nanoTime();
        list.get(5);
        nanoEndTime = System.nanoTime();
        System.out.println("Integer получен из списка за " + (nanoEndTime - nanoStartTime));

        // удаление из списка элемента с позиции 5
        /*
        здесь вываливается исключение
        nanoStartTime = System.nanoTime();
        Integer value = 30;
        list.remove((Object)value);
        nanoEndTime = System.nanoTime();
        System.out.println("Список после удаления элемента: " + list.toString());
         */
    }

    // метод выполняет задачу 3.3
    public static void task3() {
        // создаю массив из задачи 2.1
        Integer[] arr;
        arr = new Integer[10];

        // инициализация массива
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }

        long nanoStartTime, nanoEndTime;

        nanoStartTime = System.nanoTime();
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        int index = 0;
        for(Integer val: arr) {
            list.add(val, index);
            ++index;
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Преобразование массива в односвязный список прошло за " + (nanoEndTime - nanoStartTime));

        // операции с односвязным списком
        // добавление элемента в список
        nanoStartTime = System.nanoTime();
        list.add(20, 7);
        nanoEndTime = System.nanoTime();
        System.out.println("Integer добавлен в односвязный список за " + (nanoEndTime - nanoStartTime));
        System.out.println("Односвязный список после добавления элемента: " + list.toString());

        // установка элемента в списке на позиции 5
        nanoStartTime = System.nanoTime();
        list.set(5, 30);
        nanoEndTime = System.nanoTime();
        System.out.println("Integer установлен в односвязном списке за " + (nanoEndTime - nanoStartTime));
        System.out.println("Односвязный список после изменения элемента: " + list.toString());


        // получение элемента списка на позиции 5
        nanoStartTime = System.nanoTime();
        list.get(5);
        nanoEndTime = System.nanoTime();
        System.out.println("Integer получен из односвязного списка за " + (nanoEndTime - nanoStartTime));

        // удаление из списка элемента с позиции 5
        nanoStartTime = System.nanoTime();
        list.remove(5);
        nanoEndTime = System.nanoTime();
        System.out.println("Integer получен из односвязного списка за " + (nanoEndTime - nanoStartTime));
        System.out.println("Односвязный список после удаления элемента: " + list.toString());

        // создаю коллекцию из задания 1.3
        LinkedList<MyWindow> listCustom = new LinkedList<>();
        listCustom.add(new MyWindow("Robo1", 20));
        listCustom.add(new MyWindow("Robo2", 21));
        listCustom.add(new MyWindow("Robo3", 22));
        listCustom.add(new MyWindow("Robo4", 23));
        listCustom.add(new MyWindow("Robo5", 24));

        nanoStartTime = System.nanoTime();
        listCustom.set(1,new MyWindow("Set", 25));
        nanoEndTime = System.nanoTime();
        System.out.println("Односвязный список после изменения элемента: " + list.toString());

        nanoStartTime = System.nanoTime();
        list.get(2);
        nanoEndTime = System.nanoTime();
        System.out.println("Обьект получен из односвязного списка за " + (nanoEndTime - nanoStartTime));


    }


    // заджание 3.5, сортировка методом выбора
    public static void task5() {
        // создаю массив из задачи 2.1
        Integer[] arr;
        arr = new Integer[10];

        // инициализация массива
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }

        // создаю и инициализирую двухсвязный список из созданного массива
        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;
        for(Integer val: arr) {
            list.add(index, val);
            ++index;
        }

        long nanoStartTime, nanoEndTime;

        nanoStartTime = System.nanoTime();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Создание итератора, проход по нему и вывод элементов прошло за " + (nanoEndTime - nanoStartTime));

        // создаю коллекцию из задания 1.3
        LinkedList<MyWindow> listCustom = new LinkedList<>();
        listCustom.add(new MyWindow("Robo1", 20));
        listCustom.add(new MyWindow("Robo2", 21));
        listCustom.add(new MyWindow("Robo3", 22));
        listCustom.add(new MyWindow("Robo4", 23));
        listCustom.add(new MyWindow("Robo5", 24));

        nanoStartTime = System.nanoTime();
        iterator = listCustom.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        nanoEndTime = System.nanoTime();
        System.out.println("Создание итератора, проход по нему и вывод элементов прошло за " + (nanoEndTime - nanoStartTime));


    }
}
