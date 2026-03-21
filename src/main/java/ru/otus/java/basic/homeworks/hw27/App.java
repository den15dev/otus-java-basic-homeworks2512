package ru.otus.java.basic.homeworks.hw27;

import ru.otus.java.basic.homeworks.hw27.fruits.Apple;
import ru.otus.java.basic.homeworks.hw27.fruits.Fruit;
import ru.otus.java.basic.homeworks.hw27.fruits.Orange;

public class App {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i < 8; i++) {
            Apple apple = new Apple();
            appleBox.add(apple);
        }

        for (int i = 0; i < 5; i++) {
            Orange orange = new Orange();
            orangeBox.add(orange);
        }

        System.out.println("В коробке с яблоками " + appleBox.getFruits().size() +
                " яблок общей массой " + appleBox.getWeight() + ".");

        System.out.println("В коробке с апельсинами " + orangeBox.getFruits().size() +
                " апельсинов общей массой " + orangeBox.getWeight() + ".");

        if (appleBox.compare(orangeBox)) {
            System.out.println("Массы коробок равны.");
        } else {
            System.out.println("Массы коробок не равны.");
        }

        Box<Apple> appleBox2 = new Box<>();
        for (int i = 0; i < 15; i++) {
            Apple apple = new Apple();
            appleBox2.add(apple);
        }

        System.out.println("Пересыпаем яблоки из appleBox2:");
        appleBox2.transferToSame(appleBox);
        System.out.println("Теперь в appleBox " + appleBox.getFruits().size() +
                " яблок общей массой " + appleBox.getWeight() + ", а в appleBox2 - " +
                appleBox2.getFruits().size() + ".");

        Box<Fruit> mixedBox = new Box<>();
        System.out.println("Пересыпаем яблоки и апельсины в одну общую коробку:");
        appleBox.transferToMixed(mixedBox);
        orangeBox.transferToMixed(mixedBox);
        System.out.println("Теперь в общей коробке " + mixedBox.getFruits().size() +
                " разных фруктов общей массой " + mixedBox.getWeight() + ".");
    }
}
