package ru.otus.java.basic.homeworks.hw27;

import ru.otus.java.basic.homeworks.hw27.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits;


    Box() {
        fruits = new ArrayList<>();
    }


    public List<T> getFruits() {
        return fruits;
    }


    public void add(T fruit) {
        fruits.add(fruit);
    }

    public int getWeight() {
        int weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }

        return weight;
    }


    public boolean compare(Box<?> box) {
        return getWeight() == box.getWeight();
    }


    public void transferToSame(Box<T> targetBox) {
        targetBox.getFruits().addAll(fruits);
        fruits.clear();
    }


    public void transferToMixed(Box<Fruit> targetBox) {
        targetBox.getFruits().addAll(fruits);
        fruits.clear();
    }
}
