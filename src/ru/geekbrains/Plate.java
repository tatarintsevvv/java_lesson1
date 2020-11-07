package ru.geekbrains;

public class Plate {
    private int food;
    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if(food > 0) {
            this.food = food;
        } else {
            System.out.println("В тарелке не может быть отрицательного количества еды");
        }
    }

    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        if(this.food >= n) {
            // кот карпризныцй и не будет есть еду, если её недостаточно насытиться
            food -= n;
            return true;
        } else {
            return false;
        }
    }
    // метод по добавлению в тарелку еды
    public void increaseFood(int n) {
        if(n < 0) {
            System.out.println("Нельзя добавлять в тарелку отрицательное количество еды");
        } else {
            this.food += n;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
