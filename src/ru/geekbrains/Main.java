package ru.geekbrains;


//Задание 1.3
//Напишите программный код, в котором все данные хранятся только в переменных трех типов данных:
// Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.
//Выведите написанные данные.
//Задание 1.4
//Дополните предыдущий код сравнением ваших данных с другой переменной, данный код должен имитировать
// простейший поиск перебором.
//Оцените время выполнения алгоритма с помощью базового метода System.nanoTime().


class MyWindow {
    String name;
    int age;
    public MyWindow(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // задача 1.3, метод отображения данных
    @Override
    public String toString() {
        return "Имя='" + name + '\'' +
                ", возраст=" + age;
    }

    // задача 1.4, метод сравнения возраста
    boolean isOlder(int age) {
        boolean result = false;
        if(this.age > age)
            result = true;
        return result;
    }
}

public class Main {
    // примитивный тип данных
    public static final int age = 17;
    // ссылочный тип данных
    public static final String name = "Robot";
    public static void main(String[] args) {

        System.out.println("Примитивный тип данных:" + age);
        System.out.println("Ссылочный тип данных:" + name);
        // создаю ссылочный тип данных,
        MyWindow robot = new MyWindow(name, 5);
        if(robot.isOlder(age))
            System.out.println("Совершеннолетний робот");
        else
            System.out.println("Роботу не продадут сигареты и пиво");
    }
}

