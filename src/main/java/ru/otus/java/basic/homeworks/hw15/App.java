package ru.otus.java.basic.homeworks.hw15;

import ru.otus.java.basic.homeworks.hw15.exceptions.*;

public class App {
    public static void main(String[] args) {
        String[][] arr = {
            {"1", "2", "3", "4"},
            {"5", "6", "apple", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Сумма всех элементов: " + sumElements(arr));
        } catch (AppArrayDataException | AppArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }


    public static int sumElements(String[][] matrix) {
        int size = 4;
        int sum = 0;

        if (matrix.length != size) {
            throw new AppArraySizeException("В массиве должно быть " +
                    size + " строк, но передано " + matrix.length + ".");
        }

        for (int i = 0; i < size; i++) {
            if (matrix[i].length != size) {
                throw new AppArraySizeException("В каждом массиве должно быть " +
                        size + " элементов, но в " + i +
                        "-м передано " + matrix[i].length + ".");
            }

            for (int j = 0; j < size; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Неверный формат числа: \"" +
                            matrix[i][j] + "\" (ряд: " + (i + 1) +
                            ", столбец: " + (j + 1) + ")");
                }
            }
        }

        return sum;
    }
}
