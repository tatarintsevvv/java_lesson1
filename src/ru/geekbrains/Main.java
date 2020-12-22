package ru.geekbrains;

import java.util.Arrays;
import java.util.Random;

class Item {
    private int key;

    public Item(int key) {
        this.key = key;
    }

    int getKey() { return this.key; }
}

class LinearHashTable {
    private Item[] arrHash;
    private int size;
    private Item noItem;
    private double loadFactor;
    private int count;

    public LinearHashTable(int size, double loadFactor) {
        this.size = size;
        arrHash = new Item[this.size];
        noItem = new Item(-1);
        this.loadFactor = loadFactor;
        count = 0;
    }

    public LinearHashTable(int size) {
        this.size = size;
        arrHash = new Item[this.size];
        noItem = new Item(-1);
        loadFactor = 0.75;
        count = 0;
    }

    public void display() {
        for (int i = 0; i < arrHash.length; i++) {
            if(arrHash[i] == null) {
                System.out.println("***");
            } else {
                System.out.println(arrHash[i].getKey());
            }
        }
    }

    public int hashFunc(int key) { return key % this.size; }

    public void insert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while(arrHash[hashVal] != null && arrHash[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= this.size;
        }

        arrHash[hashVal] = item;
        count++;
        // проверка на заполненность хэш таблицы согласно loadFactor,
        // если заполненность больше, то увеличиваем размер хэш таблицы вдвое
        if(((double)count / (double)size) >= loadFactor) {
            arrHash = Arrays.copyOf(arrHash, size * 2);
        }
    }

    public Item delete(int key) {
        if(count > 0) {
            int hashVal = hashFunc(key);
            while (arrHash[hashVal] != null) {
                if (arrHash[hashVal].getKey() == key) {
                    Item temp = arrHash[hashVal];
                    arrHash[hashVal] = noItem;
                    count--;
                    return temp;
                }
                ++hashVal;
                hashVal %= this.size;
            }
        }
        return null;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        while(arrHash[hashVal] != null) {
            if(arrHash[hashVal].getKey() == key) {
                return arrHash[hashVal];
            }
            ++hashVal;
            hashVal %= this.size;
        }
        return null;
    }


}

class DoubledHashTable {
    private Item[] arrHash;
    private int size;
    private Item noItem;
    private double loadFactor;
    private int count;

    public DoubledHashTable(int size, double loadFactor) {
        this.size = size;
        arrHash = new Item[this.size];
        noItem = new Item(-1);
        this.loadFactor = loadFactor;
        count = 0;
    }

    public DoubledHashTable(int size) {
        this.size = size;
        arrHash = new Item[this.size];
        noItem = new Item(-1);
        loadFactor = 0.75;
        count = 0;
    }

    public void display() {
        for (int i = 0; i < arrHash.length; i++) {
            if(arrHash[i] == null) {
                System.out.println("***");
            } else {
                System.out.println(arrHash[i].getKey());
            }
        }
    }

    public int hashFunc(int key) { return key % this.size; }
    private int hashFunc2(int key) { return (5 - key % 5);}

    public void insert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);

        while(arrHash[hashVal] != null && arrHash[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= this.size;
        }

        arrHash[hashVal] = item;
        count++;
        // проверка на заполненность хэш таблицы согласно loadFactor,
        // если заполненность больше, то увеличиваем размер хэш таблицы вдвое
        if(((double)count / (double)size) >= loadFactor) {
            arrHash = Arrays.copyOf(arrHash, size * 2);
        }
    }

    public Item delete(int key) {
        if(count > 0) {
            int hashVal = hashFunc(key);
            int stepSize = hashFunc2(key);
            while (arrHash[hashVal] != null) {
                if (arrHash[hashVal].getKey() == key) {
                    Item temp = arrHash[hashVal];
                    arrHash[hashVal] = noItem;
                    count--;
                    return temp;
                }
                hashVal += stepSize;
                hashVal %= this.size;
            }
        }
        return null;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        while(arrHash[hashVal] != null) {
            if(arrHash[hashVal].getKey() == key) {
                return arrHash[hashVal];
            }
            ++hashVal;
            hashVal %= this.size;
        }
        return null;
    }


}



public class Main {

    public static void main(String[] args) {
        // 8.4, задание на хэш-балицу с линейным пробированием,
        // добавлен loadFactor и увеличение размера массива при достоижение заполненности
        LinearHashTable hashTable = new LinearHashTable(99);

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            hashTable.insert(new Item(random.nextInt(999)));
        }

        hashTable.display();

        // 8.5, задача на хэш-таблицу с двойным хэшированием
        // добавлен loadFactor и увеличение размера массива при достоижение заполненности
        DoubledHashTable hashTable2 = new DoubledHashTable(99, 0.75);
        for (int i = 0; i < 20; i++) {
            hashTable2.insert(new Item(random.nextInt(999)));
        }
        hashTable2.display();
    }
}
