package ru.geekbrains;

public class Cat {
    private String name;
    private double heightJump;
    private int lengthRun;

    public void isPossible() {
        String actions = "Я могу бегать и прыгать";
        System.out.println("Я - " + name + ". " + actions);
    }

    public Cat() {
        this.name = "кот";
        this.heightJump = 1;
        this.lengthRun = 500;
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
