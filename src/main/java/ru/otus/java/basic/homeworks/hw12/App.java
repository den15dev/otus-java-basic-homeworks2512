package ru.otus.java.basic.homeworks.hw12;

public class App {
    public static void main(String[] args) {
        Plate bigPlate = new Plate(100);
        Cat[] cats = new Cat[5];

        for (int i = 0; i < 5; i++) {
            int appetite = (int) (20 + Math.random() * 20);
            cats[i] = new Cat("Cat" + (i + 1), appetite);
        }

        showCatInfo(cats);
        System.out.println();

        for (Cat cat : cats) {
            cat.eatFrom(bigPlate);
        }
    }


    public static void showCatInfo(Cat[] cats) {
        System.out.println("Отряд из " + cats.length + " котов:");
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }
}
