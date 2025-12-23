package ru.otus.java.basic.homeworks.hw5;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] arr = {8, 19, 1, 98, 27, 3, 12, 31};

        printStringNTimes("Java homework 5", 5);
        sumGreaterThan(arr.clone(), 5);
        fillArrayWithValue(arr.clone(), 8);
        increaseElementsByValue(arr.clone(), 10);
        detectWhichHalfIsGreater(arr.clone());
    }


    public static void printStringNTimes(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }


    public static void sumGreaterThan(int[] arr, int threshold) {
        int sum = 0;

        for (int num : arr) {
            if (num > threshold) {
                sum += num;
            }
        }

        System.out.println("Сумма элементов, больших чем " + threshold + ": " + sum);
    }


    public static void fillArrayWithValue(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }

        System.out.println(Arrays.toString(arr));
    }


    public static void increaseElementsByValue(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += value;
        }

        System.out.println(Arrays.toString(arr));
    }


    public static void detectWhichHalfIsGreater(int[] arr) {
        int firstHalfSum = 0;
        int secondHalfSum = 0;

        for (int i = 0; i < arr.length / 2; i++) {
            firstHalfSum += arr[i];
        }

        for (int i = arr.length / 2; i < arr.length; i++) {
            secondHalfSum += arr[i];
        }

        if (firstHalfSum > secondHalfSum) {
            System.out.println("Сумма первой половины больше: " + firstHalfSum + " > " + secondHalfSum);

        } else if (firstHalfSum < secondHalfSum) {
            System.out.println("Сумма второй половины больше: " + firstHalfSum + " < " + secondHalfSum);

        } else {
            System.out.println("Суммы половин равны: " + firstHalfSum + " = " + secondHalfSum);
        }
    }
}
