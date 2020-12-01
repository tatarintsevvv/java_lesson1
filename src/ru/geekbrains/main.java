package ru.geekbrains;

import java.util.*;

// 1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче
// массива другого размера необходимо бросить исключение MyArraySizeException.
// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
// текст вместо числа), должно быть брошено исключение MyArrayDataException – с детализацией, в какой
// именно ячейке лежат неверные данные.
// 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
// и MyArrayDataException и вывести результат расчета.
class MyArraySizeException extends Exception {
}

class MyArrayDataException extends Exception {
    private int row;
    private int column;
    public MyArrayDataException(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Не число в " + row + " строке и " + column + " столбце";
    }
}
class Main {
    public static void main(String args[]) {
        final String[][] arr = {
                {"1", "1", "1", "1"},
                {"2", "2", "c", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}
        };
        try {
            task1(arr);
        } catch(MyArraySizeException e) {
            System.out.println("Array has not 4x4 dimensions");
        } catch(MyArrayDataException e) {
            System.out.println(e.toString());
        }
    }

    // метод выполняетзадачу 1.4
    public static void task1(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if(arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length != 4) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch(NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Сумма = " + sum);
    }


}
