package ru.geekbrains;

public class Cat {
    private String name;
    private int appetite;
    // сытость, первоначально false
    private boolean satiety;


    // геттеры и сеттеры
    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    //    конструктор
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        if(p.decreaseFood(appetite)) {
            this.satiety = true;
        } else {
            this.satiety = false;
        }
    }
}
