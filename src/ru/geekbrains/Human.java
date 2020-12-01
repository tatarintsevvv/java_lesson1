package ru.geekbrains;

public class Human {
    private String name;
    private double heightJump;
    private int lengthRun;

    public void isPossible() {
        String actions = "Я могу бегать и прыгать";
        System.out.println("Я - " + name + ". " + actions);
    }

    public Human() {
        this.name = new String("человек");
        this.heightJump = 1.0;
        this.lengthRun = 3000;
    }

    public void canJump() {
        System.out.println("Я - " + this.name + ". Я могу прыгать");
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
