package ru.otus.java.basic.homeworks.hw21;

public class App {
    public static void main(String[] args) {
        MathPerformer performer = new MathPerformer(30_000_000, 4);

        try {
            performer.calculateSingleThread();
            performer.calculateMultiThread();

        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}
