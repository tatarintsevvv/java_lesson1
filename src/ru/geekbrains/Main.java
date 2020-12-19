package ru.geekbrains;


// 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся). Найти и вывести
// список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое
// слово.
// 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот
// телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по
// фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
// запросе такой фамилии должны выводиться все телефоны.

import java.util.*;

class Main {

    public static void main(String args[]) {

        long startTime, endTime = 0;

        // 7.1
        // пример графа это атлас автомобильных дорог с показанными расстояниями отрезков дорог

        // 7.2
        Graph graph = new Graph(32);
        graph.add(new Vertex("A"));
        graph.add(new Vertex("B"));
        graph.add(new Vertex("C"));
        graph.add(new Vertex("D"));
        graph.add(new Vertex("E"));
        graph.add(new Vertex("F"));
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(0, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        // 7.3 добавить методо обхода в глубину
        startTime = System.nanoTime();
        graph.DFS(0);
        graph.refreshVertixes();
        System.out.println("Метод обхода в глубину прошёл за " + (endTime - startTime));

        // 7.4 добавить метод обхода в ширину
        startTime = System.nanoTime();
        graph.BDFS(0);
        System.out.println("Метод обхода в глубину прошёл за " + (endTime - startTime));



    }

}
