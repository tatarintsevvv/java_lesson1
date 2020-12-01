package ru.geekbrains;

public class Robot {
    private String name;
    private double heightJump;
    private int lengthRun;

    public void isPossible() {
        String actions = "Я могу бегать и прыгать";
        System.out.println("Я - " + name + ". " + actions);
    }

    public Robot() {
        this.name = "робот";
        this.heightJump = 0.1;
        this.lengthRun = 100;
    }

    public void canJump() {
        System.out.println("Я - " + name + ". Я могу прыгать");
    }
    public void canRun() {
        System.out.println("Я - " + name + ". Я могу бежать");
    }

    public double getHeightJump() {
        return heightJump;
    }

    public void setHeightJump(double heightJump) {
        this.heightJump = heightJump;
    }

    public int getLengthRun() {
        return lengthRun;
    }

    public void setLengthRun(int lengthRun) {
        this.lengthRun = lengthRun;
    }
}
