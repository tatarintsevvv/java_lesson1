package ru.geekbrains;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static final Scanner scanner = new Scanner(System.in);
    public static final int SIZE = 3;
    public static final char CROSS = 'x';
    public static final char ZERO = '0';
    public static final char EMPTY_CELL = ' ';
    public static final char LINE_LENGTH = 3;



    public static void main(String[] args) {
	// write your code here
        playGame();
    }

    /*
    1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
    2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
    3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
    4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
    */


    public static void showPaper(char[][] arr) {
        for(int i = 0 ; i < SIZE; i++) {
            Arrays.toString(arr[i]);
        }
        System.out.println();
    }

    // проверка на то, что игра завершена, игрок ставит крестики
    public static char checkEndOfGame(xSet, ySet, CROSS){
        return EMPTY_CELL;
    }

    // получаю число пустых ячеек
    public static int getFreeAmount(cells) {
        int res = 0;
        for(int i = 0 ; i < SIZE; i++) {
            for(int i1 = 0; i1 < SIZE; i1++) {
                if(cells[i][i1] == EMPTY_CELL;) {
                    res++;
                }
            }
        }
        return res;
    }


    public  static  void playGame() {
        char[][] cells = new char[SIZE][SIZE];
        for(int i = 0 ; i < SIZE; i++) {
            for(int i1 = 0; i1 < SIZE; i1++) {
                cells[i][i1] = EMPTY_CELL;
            }
        }
        Random random = new Random();
        // цикл пока никто не победил или не осталось свободных клеток
        do {
//            int prompts = 3;
//            int decision = random.nextInt(10);

            showPaper(cells);
            System.out.println("Укажите через пробел номера столбца и строки клетки от 1 до " + SIZE + ": ");
            String str = scanner.nextLine();
            String[] arr = str.split();if(arr.length != 2) {
                System.out.println("Ошибка ввода: должны быть введены два числа через пробел");
                continue;
            }
            // пробуем преобразовать в целые числа, предполагаю, что это целые числа
            int xCell = Integer.parseInt(arr[0]);
            int yCell = Integer.parseInt(arr[1]);
            // проверяю введенные числа на интервал от 1 до SIZE
            if((xCell < 1) || (xCell > SIZE) || (yCell < 1) || (yCell > SIZE)) {
                System.out.println("Введенный номер не попадает в клетку от 1 до " + SIZE);
                continue;
            }
            xCell--;
            yCell--;
            // проверка на то, не поставлена уже клетка с указанным столбцом и строкой
            if(cells[xCell][yCell] != EMPTY_CELL){
                System.out.println("Клетка cо столбцом " + xCell + " и строкой " + yCell + "уже занята");
                continue;
            }
            // проверка на то, что игра завершена, игрок ставит крестики
            char res = checkEndOfGame(xSet, ySet, CROSS);
            if(res == '\0') {
                    // нет свободных ячеек, завершаю игру
                    System.out.println("Не осталось свободных клеток. Ничья!");
                    break;
            } else if(res == CROSS) {
                System.out.println("Вы выиграли!");
                break;
            }
            // при ходе игрока комьютер выиграть не может, остается только продолжение игры
            // генерирую ответ компьютера

            // получаю число пустых ячеек
            int freeAmount = getFreeAmount(cells);
            // генерирую случайный номер от 0 до freeAmount - 1
            int number = random.nextInt(freeAmount);
            // получаю номер ячейки, куда пойдет ход компьютера
            for(int i = 0 ; i < SIZE; i++) {
                for(int i1 = 0; i1 < SIZE; i1++) {
                    if(number == 0) {
                        xCell = i;
                        yCell = i1;
                    }
                    if(cells[i][i1] == EMPTY_CELL) {
                        number--;
                    }
                }
            }
            System.out.println("Компьютер ответил ходом на " + xCell + " ячейку и " + yCell + " столбец");
            // делаю проверку на ход компьютера, не завершает ли он игру
            res = checkEndOfGame(xSet, ySet, ZERO);
            if(res == '\0') {
                // нет свободных ячеек, завершаю игру
                System.out.println("Не осталось свободных клеток. Ничья!");
                break;
            } else if(res == ZERO) {
                System.out.println("Компьютер выиграл!");
                break;
            }
            
        } while(true);
    }

}


