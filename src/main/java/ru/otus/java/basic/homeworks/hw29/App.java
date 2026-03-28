package ru.otus.java.basic.homeworks.hw29;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filePath = getFilepath(scanner);
        String searchToken = getSearchToken(scanner);

        int numOfMatches = countMatchesInFile(filePath, searchToken);

        System.out.println("Количество вхождений строки \"" + searchToken + "\": " + numOfMatches);
    }


    private static int countMatchesInFile(String filePath, String searchToken) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String nextLine;

            while ((nextLine = reader.readLine()) != null) {
                int index = 0;

                while ((index = nextLine.indexOf(searchToken, index)) != -1) {
                    count++;
                    index += searchToken.length();
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка при открытии файла: "  + e.getMessage());
        }

        return count;
    }


    private static String getFilepath(Scanner scanner) {
        String prompt = "Введите путь к файлу (без расширения .txt):";

        System.out.println(prompt);
        String filePath = scanner.nextLine() + ".txt";

        File file = new File(filePath);

        while (!file.exists()) {
            System.out.println("Такого файла не существует.");
            System.out.println(prompt);
            filePath = scanner.nextLine() + ".txt";

            file = new File(filePath);
        }

        return filePath;
    }


    private static String getSearchToken(Scanner scanner) {
        String prompt = "Введите искомую строку:";

        System.out.println(prompt);
        String token = scanner.nextLine();

        while (token.isEmpty()) {
            System.out.println("Строка не должна быть пустой.");
            System.out.println(prompt);
            token = scanner.nextLine();
        }

        return token;
    }
}
