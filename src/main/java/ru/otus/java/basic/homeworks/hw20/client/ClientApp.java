package ru.otus.java.basic.homeworks.hw20.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (Socket socket = new Socket("localhost", 8080)) {
                Client client = new Client(
                    socket.getInputStream(),
                    socket.getOutputStream()
                );
                System.out.println("Введите выражение в формате \"2 + 3\" (доступны операции +, -, *, /): ");
                String userInput = scanner.nextLine();
                client.send(userInput);

            } catch (IOException e) {
                System.out.println("Сервер не доступен.");
                throw new RuntimeException();
            }
        }
    }
}
