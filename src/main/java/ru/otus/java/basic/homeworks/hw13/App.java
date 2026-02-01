package ru.otus.java.basic.homeworks.hw13;

import ru.otus.java.basic.homeworks.hw13.human.Human;
import ru.otus.java.basic.homeworks.hw13.terrain.Terrain;
import ru.otus.java.basic.homeworks.hw13.transport.*;

public class App {
    public static void main(String[] args) {
        Human john = new Human("John");

        Transport ford = new Car();
        john.setCurrentTransport(ford);
        john.drive(Terrain.FOREST, 10);
        System.out.println();

        john.drive(Terrain.PLAIN, 8);
        System.out.println();

        Transport vezdehod = new ATV();
        john.setCurrentTransport(vezdehod);
        john.drive(Terrain.SWAMP, 5);
        System.out.println();

        john.setCurrentTransport(null);
        john.drive(Terrain.FOREST, 3);
        System.out.println();

        Transport bike = new Bike();
        john.setCurrentTransport(bike);
        john.drive(Terrain.FOREST, 80);
        System.out.println();
    }
}
