package ru.geekbrains;

public class Wall {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean jump(Object obj) {
        double heightJump = 0;
        if(obj instanceof Human) {
            Human human = (Human)obj;
            human.canJump();
            heightJump = human.getHeightJump();
        } else if(obj instanceof Cat) {
            Cat cat = (Cat)obj;
            cat.canJump();
            heightJump = cat.getHeightJump();
        } else if(obj instanceof Robot) {
            Robot robot = (Robot)obj;
            robot.canJump();
            heightJump = robot.getHeightJump();
        } else {
            System.out.println("Неизвестный науке зверь");
            return false;
        }
        if(heightJump >= this.height) {
            System.out.println("Этот перепрыгнул");
            return true;
        } else {
            System.out.println("Не перепрыгнул!");
        }
        return false;
    }
}
