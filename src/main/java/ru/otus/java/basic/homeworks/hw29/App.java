package ru.otus.java.basic.homeworks.hw29;

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

        String text = getTextFromFile(filePath);
        int numOfMatches = countMatches(text, searchToken);

        System.out.println("Количество вхождений строки \"" + searchToken + "\": " + numOfMatches);
    }


    private static String getTextFromFile(String filePath) {
        StringBuilder contentBuilder =  new StringBuilder();

        try (FileReader fileReader = new FileReader(filePath, StandardCharsets.UTF_8)) {
            int nextCharCode;
            while((nextCharCode = fileReader.read()) != -1) {
                contentBuilder.append((char) nextCharCode);
            }

        } catch (IOException e) {
            System.out.println("Ошибка при открытии файла: "  + e.getMessage());
        }

        return contentBuilder.toString();
    }


    private static int countMatches(String text, String token) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(token, index)) != -1) {
            count++;
            index += token.length();
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
