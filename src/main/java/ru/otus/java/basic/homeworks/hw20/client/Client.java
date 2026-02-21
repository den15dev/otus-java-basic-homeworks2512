package ru.otus.java.basic.homeworks.hw20.client;

import java.io.*;

public class Client implements AutoCloseable {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public Client(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new DataInputStream(inputStream);
        this.outputStream = new DataOutputStream(outputStream);
    }

    public void send(String message) throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();

        try {
            String result = inputStream.readUTF();
            System.out.println("Ответ от сервера: " + result);

        } catch (EOFException e) {
            System.out.println("Сервер закрыл соединение.");
        }
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
