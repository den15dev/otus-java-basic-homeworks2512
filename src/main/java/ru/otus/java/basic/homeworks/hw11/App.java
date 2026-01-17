package ru.otus.java.basic.homeworks.hw11;

import ru.otus.java.basic.homeworks.hw11.animals.*;

public class App {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", 2, 80);
        Dog dog = new Dog("Шарик", 3, 1, 160);
        Horse horse = new Horse("Зорька", 5, 2, 240);

        cat.run(30);
        dog.run(30);
        horse.run(30);
        System.out.println("-----");

        cat.swim(10);
        dog.swim(10);
        horse.swim(10);
        System.out.println("-----");

        cat.info();
        dog.info();
        horse.info();
        System.out.println("-----");

        dog.swim(80);
    }
}
