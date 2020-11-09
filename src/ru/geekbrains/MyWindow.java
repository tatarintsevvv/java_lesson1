package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyWindow extends JFrame {
    protected boolean isAlive = true;

    public MyWindow(final int SIZE) {
        setTitle("Bombs and Deaths");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        boolean[][] bombs = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                bombs[i][j] = Math.random() <= 0.25;
            }
        }

        JButton[][] buttons = new JButton[SIZE][SIZE];

        setLayout(new GridLayout(SIZE, SIZE));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;
                button.setText("???");
                int ii = i;
                int jj = j;
                button.addActionListener(actionEvent -> {
                    if (!isAlive) return;
                    if (bombs[ii][jj]) {
                        button.setText("\u2620");
                        button.setFont(button.getFont().deriveFont(50.F));
                        button.setBackground(Color.RED);
                        button.setForeground(Color.WHITE);
                        isAlive = false;
                        // открываю все остальные клетки с бомбами, но не с карсным, а темно-серым фоном
                        for(int i1 = 0; i1 < SIZE; i1++) {
                            for (int j1 = 0; j1 < SIZE; j1++) {
                                // если бомба и другая клетка
                                if(bombs[i1][j1] && ((ii != i1) || (jj != j1))) {
                                    buttons[i1][j1].setText("\u2620");
                                    buttons[i1][j1].setFont(button.getFont().deriveFont(50.F));
                                    buttons[i1][j1].setBackground(Color.DARK_GRAY);
                                    buttons[i1][j1].setForeground(Color.WHITE);
                                }
                            }
                        }
                    } else {
                        // нет бомбы
                        // подсчитываем число бомб в соседних клетках и выводим его в клетке
                        int amount = 0;
                        for(int i1 = 0; i1 < SIZE; i1++) {
                            for(int j1 = 0; j1 < SIZE; j1++) {
                                // проверяем соседние клетки
                                int diffX = Math.abs(ii - i1);
                                int diffY = Math.abs(jj - j1);
                                if((diffX <= 1) && (diffY <= 1) && ((diffX + diffY) != 0)) {
                                    if(bombs[i1][j1]) {
                                        amount++;
                                    }
                                }
                            }
                        }
                        button.setText("" + amount);
                        button.setBackground(Color.GREEN);
                        // проверяю, есть ли еще неоткрыте клетки без бомб
                        // определяю по цвету фона, если не бомба и хоть где-то не зеленый фон

                        // сейчас подсчитываю количество неоткрытх клеток без бомб
                        amount = 0;
                        for(int i1 = 0; i1 < SIZE; i1++) {
                            for (int j1 = 0; j1 < SIZE; j1++) {
                                if(!bombs[i1][j1] && (buttons[i1][j1].getBackground() != Color.GREEN)) {
                                    // взвожу флаг, что игра закончилась
                                    amount++;
                                }
                            }
                        }
                        // если не осталось неоткрытых клеток без бомб
                        if(amount == 0) {
                            isAlive = false;
                            for(int i1 = 0; i1 < SIZE; i1++) {
                                for (int j1 = 0; j1 < SIZE; j1++) {
                                    // если бомба
                                    if(bombs[i1][j1]) {
                                        buttons[i1][j1].setText("\u2620");
                                        buttons[i1][j1].setFont(button.getFont().deriveFont(50.F));
                                        buttons[i1][j1].setBackground(Color.GREEN);
                                        buttons[i1][j1].setForeground(Color.WHITE);
                                    }
                                }
                            }
                        }
                    }
                });
                add(button);
            }
        }

        setVisible(true);
    }
}
