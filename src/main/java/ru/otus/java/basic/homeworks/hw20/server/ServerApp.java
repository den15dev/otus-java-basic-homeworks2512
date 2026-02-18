package ru.otus.java.basic.homeworks.hw20.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try (ServerSocket socket = new ServerSocket(8080)) {
            System.out.println("Сервер запущен.");

            while (true) {
                Socket client = socket.accept();
                System.out.println("Порт клиента: " + client.getPort());

                try (DataInputStream is = new DataInputStream(client.getInputStream());
                    DataOutputStream os = new DataOutputStream(client.getOutputStream())) {
                    String userInput = is.readUTF();

                    System.out.println("Получен запрос: " + userInput);

                    String response;
                    try {
                        response = calculator.getResult(userInput);

                    } catch (Exception e) {
                        response = "Ошибка! " + e.getMessage();
                    }

                    os.writeUTF(response);
                    os.flush();

                    System.out.println("Послали ответ: " + response);
                }
            }

        } catch (IOException e) {
            System.out.println("Сервер закрыл соединение по причине: " + e.getMessage());
        }
    }
}
