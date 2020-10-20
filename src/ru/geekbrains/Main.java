package ru.geekbrains;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        createSquareArray();
        int[] arr = {
                2, 2, 2, 1, 2, 2, 10, 1
        };
        boolean b = checkBalance(arr);
        System.out.println(b);
        int[] arr1 = {
                1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        b = checkBalance(arr1);
        System.out.println(b);

        shiftArray(arr1, -6);
    }

    // функция создает массив из нулей и единиц и заменяет их друг другом
    public static void revertZeroAndOnes() {
        int[] arr = {
            1, 1, 0, 0, 1, 0, 1, 1, 0, 0
        };

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                arr[i] = 1;
            } else if(arr[i] == 1) {
                arr[i] = 0;
            }
        }
    }

    // Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
    // значениями 0 3 6 9 12 15 18 21
    public static void fillArray() {
        int[] arr = new int[8];
        for(int i = 0; i < 8; i++) {
            arr[i] = 3 * i;
        }
    }

    // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    // и числа меньшие 6 умножить на 2
    public static void operateArray() {
        int[] arr = {
                1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1
        };
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void createSquareArray() {
        int[][] arr = new int[6][6];
        for(int i=0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - i - 1] = 1;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]) + " ");
            System.out.println();
        }
    }

    // Задать одномерный массив и найти в нем минимальный и максимальный элементы (без
    // помощи интернета
    public static void findMaxAndMin() {
        int[] arr = {
                5, 12, 2, 99, 33, 12, 54, 6, 76, 49
        };
        int minValue = arr[0];
        int maxValue = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < minValue) {
                minValue = arr[i];
            }
            if(arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        System.out.println("Максимальное значение: " + maxValue);
        System.out.println("Минимальное значение: " + minValue);
    }

    // Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
    // части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
    // эти символы в массив не входят.
    public static boolean checkBalance(int[] arr) {
        // пускаем суммирование с начала и конца массива, добавляем к сумме элемент с той стороны
        // c какой сумма меньше, если суммы одинаковы добавляем с обеих сторон
        if(arr.length < 2) {
            return false;
        }
        int leftSum = 0;
        int rightSum = 0;
        int leftIndex = -1;
        int rightIndex = arr.length;
        while(true) {
            if(leftSum == rightSum) {
                leftIndex += 1;
                rightIndex -= 1;
                leftSum += arr[leftIndex];
                rightSum += arr[rightIndex];
            } else if(leftSum < rightSum) {
                leftIndex += 1;
                leftSum += arr[leftIndex];
            } else if(rightSum < leftSum) {
                rightIndex -= 1;
                rightSum += arr[rightIndex];
            }
            // ставим проверку, что левый индекс на единицу меньше и суммы равны, в этом случае true
            if((leftIndex + 1) == rightIndex) {
                if(leftSum == rightSum) {
                    return true;
                } else {
                    return false;
                }
            }
            // если левый индекс равен или больше (излишняя проверка) правого, то false
            if(leftIndex >= rightIndex) {
                return false;
            }
        }
    }


    // Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или
    // трицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя
    // пользоваться вспомогательными массивами.
    public static void shiftArray(int[] arr, int n) {
        if(n == 0)
            return;

        System.out.println(Arrays.toString(arr));

        // для случая n > длины массива находим целочисленный остаток, это и будет реальной сдвигом,
        // чтобы не гонять массив несколько раз
        int shift = n % arr.length;
        if(shift == 0)
            return;

        // для положительного n (сдвиг вправо) начинаем с первого элемента массива
        int begin = 0;
        // для отрицательного с последнего элемента массива
        if(n < 0) {
            begin = arr.length - 1;
        }

        // здесь используется некий финт для продолжения цикличности, вызванный тем, что если количество элементов
        // массива делится нацело, то нужно подключать дополнительные цепочки смещения, которые зависят от остатка деления
        // нацело
        int ticks = arr.length % shift;
        if(ticks == 0) {
            ticks = shift;
            if(shift < 0) {
                ticks = -1 * ticks;
            }
        }

        int tempIndex;
        for(int i = 0; i < ticks; i++){
            if(shift > 0) {
                begin++;
            } else {
                begin--;
            }
            int next = begin;
            int tempValue = arr[next];
            int prevValue = arr[next];

            do {
//            tempIndex = next;
                if (((next + shift) >= 0) && ((next + shift) <= (arr.length - 1))) {
                    next += shift;
                } else if (shift > 0) {
                    next = arr.length - next - shift;
                } else if (shift < 0) {
                    next = arr.length + next + shift;
                }
                tempValue = arr[next];
                arr[next] = prevValue;
                prevValue = tempValue;
            } while (next != begin);
        }
        System.out.println(Arrays.toString(arr));
    }
}

