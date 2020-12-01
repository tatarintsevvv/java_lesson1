package ru.geekbrains;

public class TreadMill {
    private double length;

    public TreadMill(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean run(Object obj) {
        int lengthRun = 0;
        if(obj instanceof Human) {
            Human human = (Human)obj;
            human.canRun();
            lengthRun = human.getLengthRun();
        } else if(obj instanceof Cat) {
            Cat cat = (Cat)obj;
            cat.canRun();
            lengthRun = cat.getLengthRun();
        } else if(obj instanceof Robot) {
            Robot robot = (Robot)obj;
            robot.canRun();
            lengthRun = robot.getLengthRun();
        } else {
            System.out.println("Неизвестный науке зверь");
            return false;
        }
        if(lengthRun >= this.length) {
            System.out.println("Этот пробежал");
            return true;
        } else {
            System.out.println("Не добрался!");
        }
        return false;
    }

}
