package ru.otus.java.basic.homeworks.hw11.animals;

public class Dog extends Animal {
    public Dog(String name,
        int runSpeed,
        int swimSpeed,
        int initEndurance
    ) {
        super("Пёс", name, runSpeed, swimSpeed, initEndurance, 2);
    }
}
