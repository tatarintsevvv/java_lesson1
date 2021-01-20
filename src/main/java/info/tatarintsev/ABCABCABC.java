package info.tatarintsev;//package info.tatarintsev;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ABCABCABC {
    private static Object key = new Object();
    private static volatile char charTyped = 'A';
    private static ExecutorService executorService;
    private static char[] letters = {'A', 'B', 'C'};

    public static void main(String[] args) {

        executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> tiktokOneLetters('A'));
        executorService.submit(() -> tiktokOneLetters('B'));
        executorService.submit(() -> tiktokOneLetters('C'));
    }

    private static void tiktokOneLetters(char tiktok) {

        try {
            for (int i = 0; i < 5; i++) {
                synchronized (key) {
                    while (charTyped != tiktok) {
                        key.wait();
                    }
                    System.out.println(tiktok);
                    int position = Arrays.binarySearch(letters, tiktok);
                    if (position >= (letters.length - 1)) {
                        charTyped = letters[0];
                    } else {
                        charTyped = letters[position + 1];
                    }
                    key.notifyAll();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
