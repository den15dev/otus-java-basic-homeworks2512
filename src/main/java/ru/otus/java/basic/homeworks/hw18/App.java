package ru.otus.java.basic.homeworks.hw18;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        MyTreeMap<Integer, String> treeMap = new MyTreeMap<>();
        treeMap.put(1, "one");
        treeMap.put(2, "two");
        treeMap.put(3, "three");
        treeMap.put(4, "four");
        treeMap.put(5, "five");

        System.out.println(treeMap);
        System.out.println("Размер TreeMap: " + treeMap.size());

        System.out.println("Значение под ключом 4: " + treeMap.get(4));
    }
}
