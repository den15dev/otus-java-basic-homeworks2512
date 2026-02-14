package ru.otus.java.basic.homeworks.hw19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File dir = new File("files");
        Scanner scanner = new Scanner(System.in);

        File[] files = dir.listFiles();

        printFileList(files);
        System.out.println();

        File file = getFileFromPrompt(dir, scanner);

        System.out.println("Содержимое файла " + file.getName() + ":");
        printFileContent(file);
        System.out.println();

        System.out.println("Введите текст, который вы хотите записать в этот файл:");
        String inputContent = scanner.nextLine();
        while (inputContent.isEmpty()) {
            System.out.println("Файл не должен быть пустым. Введите любой текст:");
            inputContent = scanner.nextLine();
        }

        writeToFile(file, inputContent);
        System.out.println("Ваш текст успешно записан в файл " + file.getName());
    }


    private static void printFileList(File[] files) {
        if (files == null) {
            throw new RuntimeException("Это не директория.");
        }

        if (files.length == 0) {
            System.out.println("Директория пуста.");
            return;
        }

        System.out.println("Список файлов:");

        for (File file : files) {
            System.out.println(file.getName());
        }
    }


    private static void printFileContent(File file) {
        if (file == null) {
            throw new RuntimeException("Такого файла не существует.");
        }

        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)
        )) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static File getFileFromPrompt(File dir, Scanner scanner) {
        System.out.println("Введите имя файла (без расширения .txt):");
        String inputFileName = scanner.nextLine() + ".txt";

        File file = new File(dir, inputFileName);

        while (!file.exists()) {
            System.out.println("Такого файла не существует. Введите правильное имя:");
            inputFileName = scanner.nextLine() + ".txt";
            file = new File(dir, inputFileName);
        }

        return file;
    }


    private static void writeToFile(File file, String content) {
        try (FileOutputStream out = new FileOutputStream(file.getPath())) {
            byte[] buffer = content.getBytes(StandardCharsets.UTF_8);
            out.write(buffer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
