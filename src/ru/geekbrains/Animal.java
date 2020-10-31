package ru.geekbrains;

public class Animal {
    private int run; // длина бега
    private double jump; // высота прыжка
    private int swim; // длина сколько проплывет

    public Animal(int run,double jump, int swim) {
        this.run = run;
        this.jump = jump;
        this.swim = swim;
    }

    public boolean canRun(int run) {
        if((this.run >= run) && (run > 0)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean canJump(double jump) {
        if((this.jump >= jump) && (jump > 0)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean canSwim(int swim) {
        if((this.swim >= swim) && (swim > 0)) {
            return true;
        } else {
            return false;
        }
    }
}
