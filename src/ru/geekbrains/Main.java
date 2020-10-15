package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
	// write your code here
        initializeVariables();
        greatings("Ольга");
        double d = calculateFormula1(1.1, 2.2, 3.3, 4.4);
        boolean b = checkFromTenToTwenty(5, 7);
        checkPositive((0));
        b = checkNegative(0);
        checkLeapYear(2020);
    }

    // создаю и инициализирую пройденные переменные
    public static void initializeVariables() {
        byte b =0;
        short sh = 1;
        int i = 10;
        long l = 15;

        float f = 0.1F;
        double d = 1.1;

        char c = 'f';
        String s = "String";
        boolean boo = true;
    }

    public static double calculateFormula1(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    // возвращает true если сумма чисел лежит в промежутке от 10 до 20
    public static boolean checkFromTenToTwenty(int a, int b) {
        boolean result = false;
        int sum = a + b;
        if((sum >= 10) && (sum <= 20)) {
            result = true;
        }
        return result;
    }

    // метод должен напечатать в консоль положительное ли число передали, или отрицательное;
    // ноль считаем положительным числом.
    public static void checkPositive(int x) {
        if(x >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    // метод должен вернуть true, если число отрицательное
    public static boolean checkNegative(int x) {
        boolean result = false;
        if(x < 0) {
            result = true;
        }
        return result;
    }

    // метод выводит приветствие
    public static void greatings(String s) {
        System.out.println("Привет, " + s + "!");
    }

    // метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный
    public static void checkLeapYear(int year) {
        boolean b = false;
        if(year % 400 == 0) {
            b = true;
        } else if(year % 100 == 0) {
        } else if(year % 4 == 0) {
            b = true;
        }
        if(b) {
            System.out.println(year + " високосный год");
        } else {
            System.out.println(year + " не високосный год");
        }
    }

}
