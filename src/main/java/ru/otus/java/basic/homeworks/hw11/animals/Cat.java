package ru.otus.java.basic.homeworks.hw11.animals;

public class Cat extends Animal {
    public Cat(String name,
        int runSpeed,
        int initEndurance
    ) {
        super("Кот", name, runSpeed, 0, initEndurance, null);
    }


    public double swim(int distance) {
        System.out.println("Коты не умеют плавать.");
        return -1;
    }


    public void info() {
        System.out.println("Животное: Кот");
        System.out.println("Кличка: " + name);
        System.out.println("Скорость бега (м/с): " + runSpeed);
        System.out.println("Скорость плаванья: не умеет плавать");
        System.out.println("Выносливость: " + endurance);
        System.out.println("Затраты выносливости на метр бега: " + runEndurancePerMeter);
        System.out.println("Затраты выносливости на метр плаванья: не умеет плавать");
    }
}
