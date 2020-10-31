package ru.geekbrains;

public class Cat extends Animal {
    static int countOfCats = 0;

    public Cat(int run, double jump, int swim) {
        super(run, jump, swim);
        countOfCats++;
    }
}
