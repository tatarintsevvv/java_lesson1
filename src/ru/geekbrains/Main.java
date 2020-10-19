package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
	// write your code here
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
            for(int i1 = 0; i1 < arr[i].length; i1++) {
                if(i == i1) {
                    arr[i][i1] = 1;
                }
            }
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
    public static void findEqualiser(int[] arr) {
        // пускаем суммирование с начала и конца массива, добавляем к сумме элемент с той стороны
        // c какой сумма меньше, если суммы одинаковы добавляем с обеих сторон
    }
}

