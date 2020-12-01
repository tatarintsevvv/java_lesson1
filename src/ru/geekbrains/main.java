package ru.geekbrains;

import java.util.*;

class Main {
    public static void main(String args[]) {
        long nanoStartTime, nanoEndTime;

        //  выполняет задачу 1.1
        LinkedList<Object> list = new LinkedList<>();
        list.add((Object)new Human());
        list.add((Object)new Robot());
        list.add((Object)new Cat());

        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            if(obj instanceof Human) {
                ((Human)obj).canRun();
            } else if(obj instanceof Cat) {
                ((Cat)obj).canRun();
            } else if(obj instanceof Robot) {
                ((Robot)obj).canRun();
            }
        }

        iterator = list.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            if(obj instanceof Human) {
                ((Human)obj).canJump();
            } else if(obj instanceof Cat) {
                ((Cat)obj).canJump();
            } else if(obj instanceof Robot) {
                ((Robot)obj).canJump();
            }
        }

        // задача 1.2, реализованы соответствующие классы
        Wall wall = new Wall(0.7);
        TreadMill treadmill = new TreadMill(700);


        // задача 1.3 и сразу же 1.4, препятствия я сделал массивом, а участников
        // контейнером (двусвязным списком)
        Object[] arr = { (Object)wall, (Object)treadmill};
        for (Object obj: arr) {
            if(obj instanceof Wall) {
                Wall objWall = (Wall)obj;
                iterator = list.iterator();
                while(iterator.hasNext()) {
                    boolean result = ((Wall)objWall).jump(iterator.next());
                    if(!result) {
                        iterator.remove();
                    }
                }
            } else if(obj instanceof TreadMill) {
                TreadMill objTreadmill = (TreadMill)obj;
                iterator = list.iterator();
                while(iterator.hasNext()) {
                    boolean result = objTreadmill.run(iterator.next());
                    if(!result) {
                        iterator.remove();
                    }
                }
            } else {
                System.out.println("Неизвестное препятствие!");
            }
        }

    }

    // метод выполняетзадачу 1.4
    public static void task4() {
    }


    // метод выполняет задачу 1.3
    public static void task3() {
    }


    // заджание 3.5, сортировка методом выбора
    public static void task5() {
    }
}
