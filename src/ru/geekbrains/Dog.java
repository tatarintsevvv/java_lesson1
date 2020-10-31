package ru.geekbrains;

public class Dog extends Animal {
    static int countOfDogs = 0;

    public Dog(int run, double jump, int swim) {
        super(run, jump, swim);
        countOfDogs++;
    }
}
