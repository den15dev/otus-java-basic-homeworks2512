package ru.otus.java.basic.homeworks.hw7;

public class App {
    public static void main(String[] args) {
        // Задание 1
        int[][] arr1 = generate2DArray(5, -50, 50);
        System.out.println("Исходный массив:");
        printArrayMatrix(arr1);
        System.out.println("Сумма положительных чисел: " + sumOfPositiveElements(arr1) + "\n");
        System.out.println("-----\n");

        // Задание 2
        printAsteriskSquare(10);
        System.out.println("-----\n");

        // Задание 3
        int[][] arr3 = generate2DArray(5, 2, 8);
        setDiagonalsToZero(arr3);
        printArrayMatrix(arr3);
        System.out.println("-----\n");

        // Задание 4
        int[][] arr4 = generate2DArray(5, 0, 100);
        System.out.println("Исходный массив:");
        printArrayMatrix(arr4);
        System.out.println("Максимальное значение: " + findMax(arr4));
        System.out.println("-----\n");

        // Задание 5
        int[][] arr5 = generate2DArray(5, 0, 100);
        System.out.println("Исходный массив:");
        printArrayMatrix(arr5);
        int sum5 = getSumOfSecondRow(arr5);
        if (sum5 > 0) {
            System.out.println("Сумма элементов второй строки: " + sum5);
        } else {
            System.out.println("В массиве менее двух строк.");
        }
        System.out.println("-----\n");
    }


    private static int sumOfPositiveElements(int[][] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                }
            }
        }

        return sum;
    }


    private static void printAsteriskSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }


    private static void setDiagonalsToZero(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || i + j == arr.length - 1) {
                    arr[i][j] = 0;
                }
            }
        }
    }


    private static int findMax(int[][] arr) {
        int max = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }

        return max;
    }


    private static int getSumOfSecondRow(int[][] arr) {
        if (arr.length < 2) return -1;

        int sum = 0;
        for (int i = 0; i < arr[1].length; i++) {
            sum += arr[1][i];
        }

        return sum;
    }


    private static int[][] generate2DArray(int size, int min, int max) {
        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = (int) (Math.random() * (max - min) + min);
            }
        }

        return arr;
    }


    private static void printArrayMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }


    private static void printArrayMatrix(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
