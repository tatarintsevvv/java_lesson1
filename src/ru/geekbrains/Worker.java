package ru.geekbrains;

// Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
// Конструктор класса должен заполнять эти поля при создании объекта;
// Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
public class Worker {
    private String FIO;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Worker(String FIO, String position, String email, String phone, double salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    // пишу сеттеры
    public void setFIO(String FIO) {
        if ((FIO != null) && !FIO.isBlank()) {
            this.FIO = FIO;
        } else {
            System.out.println("Введено некорректное ФИО");
        }
    }
    public void setPosition(String position) {
        if ((position != null) && !position.isBlank()) {
            this.position = position;
        } else {
            System.out.println("Введена некорректная должность");
        }
    }
    public void setEmail(String email) {
        if ((email != null) && !email.isBlank()) {
            this.email = email;
        } else {
            System.out.println("Введен некорректный адрес электрпоннойц почты");
        }
    }
    public void setPhone(String phone) {
        if ((phone != null) && !phone.isBlank()) {
            this.phone = phone;
        } else {
            System.out.println("Введен некорректный номер телефона");
        }
    }
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Введена некорректная запрлата");
        }
    }
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Введен некорректный возраст");
        }
    }    

    // пишу геттеры
    public String getFIO() {
        return this.FIO;
    }
    public String getPosition() {
        return this.position;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPhone() {
        return this.phone;
    }
    public double getSalary() {
        return this.salary;
    }
    public int getAge() {
        return this.age;
    }


    public String toString() {
        String res = "ФИО: " + FIO + ", должность: " + position + ", емейл: " + email +
                ", телефон: " + phone + ", зарплата: " + salary + ", возраст: " + age;
        return res;
    }
}
