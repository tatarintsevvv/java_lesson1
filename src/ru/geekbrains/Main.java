package ru.geekbrains;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        findValue();
    }

    // Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это
    // число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
    // или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
    // (1 – повторить, 0 – нет).
    public  static  void findValue() {
        Random random = new Random();
        while(true) {
            int prompts = 3;
            int decision = random.nextInt(10);

            for (int i = 0; i < prompts; i++) {
                System.out.println("Укажите целое число от 0 до 9:");

                int prompt = scanner.nextInt();

                if (prompt > decision) {
                    System.out.println("Ввведенное вами число " + prompt + " больше загаданного");
                } else if (prompt < decision) {
                    System.out.println("Ввведенное вами число " + prompt + " меньше загаданного");
                } else {
                    // число угадано
                    System.out.println("Поздравляю! Вы угадали!");
                    break;
                }

            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            int repeat = scanner.nextInt();
            if(repeat == 0) {
                System.out.println("Игра завершена");
                break;
            }
        }
    }

    /*
    не совсем понял, в задание было написано делать только одну задачу (?!), поэтому эту часть закомментировал
     */
    // При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер
    // показывает буквы которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно, можно пользоваться:
    //String str = "apple";
    //str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово
    public static void findWord() {
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"
        };
    }
    */
}

