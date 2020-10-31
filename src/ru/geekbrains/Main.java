package ru.geekbrains;

//Создать массив из 5 сотрудников
//        * С помощью цикла вывести информацию только о сотрудниках старше 40 лет


public class Main {

    public static void main(String[] args) {
	// write your code here
        Worker[] workers = new Worker[5];
        workers[0] = new Worker("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000.00, 30);
        workers[1] = new Worker("Ivanov Pyotr", "Engineer", "pyoutr_ivan@mailbox.com", "892312313", 32000.00, 50);
        workers[2] = new Worker("Ivanov Max", "Engineer", "max_ivan@mailbox.com", "892312314", 34000.00, 25);
        workers[3] = new Worker("Ivanov Alex", "Engineer", "alex_ivan@mailbox.com", "892312315", 35000.00, 42);
        workers[4] = new Worker("Ivanov Oleg", "Engineer", "oleg_ivan@mailbox.com", "892312316", 33000.00, 40);
        for (int i = 0; i < workers.length; i++) {
            if(workers[i].getAge() > 40) {
                System.out.println(workers[i]);
            }
        }
    }

}

