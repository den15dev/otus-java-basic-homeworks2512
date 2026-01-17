package ru.otus.java.basic.homeworks.hw11.animals;

public class Horse extends Animal {
    public Horse(String name,
        int runSpeed,
        int swimSpeed,
        int initEndurance
    ) {
        super("Лошадь", name, runSpeed, swimSpeed, initEndurance, 4);
    }
}
