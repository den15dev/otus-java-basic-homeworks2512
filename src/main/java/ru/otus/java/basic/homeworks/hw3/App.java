package ru.otus.java.basic.homeworks.hw3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число от 1 до 5: ");

        int n = scanner.nextInt();

        while (n < 1 || n > 5) {
            System.out.print("Вы ввели неверное число. Попробуйте ещё раз: ");
            n = scanner.nextInt();
        }

        switch (n) {
            case 1:
                greetings();
                break;

            case 2:
                int a = (int) (Math.random() * 20 - 10);
                int b = (int) (Math.random() * 20 - 10);
                int c = (int) (Math.random() * 20 - 10);
                checkSign(a, b, c);
                break;

            case 3:
                selectColor();
                break;

            case 4:
                compareNumbers();
                break;

            case 5:
                int initVal = (int) (Math.random() * 20);
                int delta = (int) (Math.random() * 12);
                boolean incr = Math.random() > 0.5;
                addOrSubtractAndPrint(initVal, delta, incr);
                break;

            default:
                System.out.println("Введено неверное число");
        }
    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;

        if (sum >= 0) {
            System.out.print("Сумма положительная: ");
        } else {
            System.out.print("Сумма отрицательная: ");
        }

        System.out.println(sum);
    }

    public static void selectColor() {
        int data = (int) (Math.random() * 30);

        System.out.print(data + ": ");

        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);

        System.out.println("a: " + a + ", b: " + b);

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(
        int initValue,
        int delta,
        boolean increment
    ) {
        int result;

        if (increment) {
            result = initValue + delta;
        } else {
            result = initValue - delta;
        }

        System.out.println(result);
    }
}
