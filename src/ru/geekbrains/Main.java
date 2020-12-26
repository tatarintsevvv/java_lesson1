package ru.geekbrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 2, 3, 4, 5, 6};

        /*
         задача 1.1 Написать метод, который меняет два элемента массива местами
         (массив может быть любого ссылочного типа)
        */
        System.out.println("До перестановки " + Arrays.toString(arr));
        mySwap(arr, 1, 2);
        System.out.println("После перестановки " + Arrays.toString(arr));

        // 2. Написать метод, который преобразует массив в ArrayList
        ArrayList<Integer> list = convertToArrayList(arr);
        System.out.println("После преобразования " + list.toString());

        // 3. Большая задача
        // метод compare совпадает по названию с методом интерфейса Comparator
        // поэтому я унаследовал клсаа Box от Comparator и compare сделал в
        // канонической форме(меньше 1, 0 или единица). Попутно, в этом методе
        // сделал умножение на десять, чтобы избавиться от ошибок округления, раз вес
        // апельсин одинаков с точностью до десятых
        // Для метода пересыпки нескольких фруктов из одной коробки в другую создал
        // исключение, вызываемое когда в коробке меньше фруктов, чем требуется из
        // нее отсыпать

        Random random = new Random();
        Apple[] apples1 = new Apple[15];
        for (int i = 0; i < apples1.length; i++) {
            apples1[i] = new Apple();
        }
        Apple[] apples2 = new Apple[random.nextInt(30)];
        for (int i = 0; i < apples2.length; i++) {
            apples2[i] = new Apple();
        }
        Orange[] oranges1 = new Orange[10];
        for (int i = 0; i < oranges1.length; i++) {
            oranges1[i] = new Orange();
        }
        Box<Apple> box1 = new Box<>(apples1);
        Box<Apple> box2 = new Box<>(apples2);
        Box<Orange> box3 = new Box(oranges1);
        box1.display();
        box2.display();
        box3.display();

        /*
            // только с ромбическими скобками
        Fruit[] fruits = new Fruit[] { new Apple(), new Orange()};
        Box<Apple> box4 = new Box<>(fruits);
        */

        int res = box1.compare(box1, box3);
        if(res == 0) {
            System.out.println("Первая и третья коробки весят одинаково");
        } else if(res < 0) {
            System.out.println("Третья коробка тяжелее первой");
        } else {
            System.out.println("Первая теяжелее третьей");
        }
        res = box2.compare(box2, box3);
        if(res == 0) {
            System.out.println("Вторая и третья коробки весят одинаково");
        } else if(res < 0) {
            System.out.println("Третья коробка тяжелее второй");
        } else {
            System.out.println("Вторая тяжелее третьей");
        }

        Apple apple = new Apple();
        box2.addFruit(apple);
        System.out.println("Во вторую коробку добавлено яблоко");

        try {
            box2.replace(box1, 1);
            System.out.println("Из второй корзины в первую переложили 1 яблоко");
            box2.replace(box1, 500);

        } catch(NotEnoughFruitsInBoxToReplace e) {
            System.err.println("Во второй коробке нет столько яблок, сколько затребовано переложить");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // соблюдено, чтобы ранзные фрукты не находились в одной коробке, дает ошибку
        ///box2.replace(box3, 1);
    }

    public static  <T> void mySwap(T[] arr, int first, int second) {
        T temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static <T> ArrayList<T> convertToArrayList(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }
}

class Fruit {
    private double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}

abstract interface Fruitable {
    public String getNameOfFruit();
    public double getWeight();
}

class Apple extends Fruit implements Fruitable{
    public Apple() {
        super(1.0);
    }

    @Override
    public String getNameOfFruit() {
        return "яблоки";
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }
}

class Orange extends Fruit implements Fruitable{
    public Orange() {
        super(1.5);
    }

    @Override
    public String getNameOfFruit() {
        return "апельсины";
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }
}

class NotEnoughFruitsInBoxToReplace extends Exception {};

class Box<T extends Fruit & Fruitable> implements Comparator {
    private ArrayList<T> fruitsInBox;
    // в предположении, что у фруктов одинаковый вес создаем count фркутов в коробке
    public <T1 extends Fruit & Fruitable>Box(T1[] arr) {
        this.fruitsInBox = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            T t = (T)arr[i];
            fruitsInBox.add(t);
        }
    }

    public double getWeight() {
        double totalWeight = 0.0;
        for ( T fruit : fruitsInBox) {
            totalWeight += ((Fruitable)fruit).getWeight();
        }
        return totalWeight;
    }

    @Override
    public int compare(Object o1, Object o2) {
        long firstWeight = Math.round(((Box)o1).getWeight() * 10);
        long secondWeight = Math.round(((Box)o2).getWeight() * 10);
        return Long.compare(firstWeight, secondWeight);
    }

    public void addFruit(T t) {
        fruitsInBox.add(t);
    }

    public void replace(Box<T> otherBox, int count) throws NotEnoughFruitsInBoxToReplace {
        if(count < fruitsInBox.size()) {
            throw new NotEnoughFruitsInBoxToReplace();
        } else {
            for (int i = 0; i < count; i++) {
                T t = fruitsInBox.remove(fruitsInBox.size() - 1);
                otherBox.addFruit(t);
            }
        }
    }

    public void display() {
        if(fruitsInBox.size() == 0) {
            System.out.println("Пустая коробка");
        } else {
            System.out.println("Коробка, содержащая " + ((Fruitable)fruitsInBox.get(0)).getNameOfFruit()
                    + " в количестве " + " и весом " + String.format("%.1f", this.getWeight()));
        }
    }
}