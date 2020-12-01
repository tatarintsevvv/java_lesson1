package ru.geekbrains;

import java.util.*;

// 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся). Найти и вывести
// список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое
// слово.
// 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот
// телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по
// фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
// запросе такой фамилии должны выводиться все телефоны.

class Main {
    public static void main(String args[]) {
        final String[] arr = {
                "Robot1",
                "Robot2",
                "Robot3",
                "Robot4",
                "Robot5",
                "Robot1",
                "Robot6",
                "Robot1",
                "Robot7",
                "Robot3",
                "Robot8",
                "Robot9",
                "Robot10",
                "Robot7",
                "Robot11",
        };
        HashSet<String> set = new HashSet<>();
        for (String str: arr) {
            set.add(str);
        }
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            String temp = (String)iterator.next();
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i].equals(temp)) {
                    count++;
                }
            }
            System.out.println(temp + " встречается " + count + " раз");
        }

        // теперь задание 3.2
        PhoneBook book = new PhoneBook();
        book.add("Robot", "+7(911)111-11-11");
        book.add("Cat", "+7(911)111-11-12");
        book.add("Wilson", "+7(911)111-11-13");
        book.add("Wall", "+7(911)111-11-14");
        book.add("Nelson", "+7(911)111-11-15");
        book.add("Treadmill", "+7(911)111-11-16");
        book.add("Human", "+7(911)111-11-17");
        book.add("Wilson", "+7(911)111-11-18");
        book.add("Nelson", "+7(911)111-11-19");
        book.add("Brown", "+7(911)111-11-21");

        String lastName = "Wilson";
        ArrayList<String> list = book.get(lastName);
        if(list.isEmpty()) {
            System.out.println(lastName + " without phone");
        } else {
            System.out.println(lastName + " with phone(s):");
            iterator = list.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}
