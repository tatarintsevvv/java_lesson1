package ru.geekbrains;

//Создать массив из 5 сотрудников
//        * С помощью цикла вывести информацию только о сотрудниках старше 40 лет


public class Main {

    public static void main(String[] args) {
        // write your code here
        // создаю кошек
        Cat cat = new Cat(200, 2.0, 0);
        Dog dog = new Dog(500, 0.5, 10);
        Dog shortDog = new Dog(400, 0.5, 10);
        Dog longDog = new Dog(600, 0.5, 10);
        Animal[] animals = new Animal[4];
        animals[0] = cat;
        animals[1] = dog;
        animals[2] = shortDog;
        animals[3] = longDog;
        for (int i = 0; i < animals.length; i++) {
            if(animals[i] instanceof Animal) {
                boolean res = animals[i].canRun(450);
                if(res) {
                    System.out.println("result:run:true");
                } else {
                    System.out.println("result:run:false");
                }
            }
        }
        System.out.println("Собак создано: " + Dog.countOfDogs);
        System.out.println("Котов создано: " + Cat.countOfCats);
    }
}

