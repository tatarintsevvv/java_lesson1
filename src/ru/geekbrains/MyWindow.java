package ru.geekbrains;

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
