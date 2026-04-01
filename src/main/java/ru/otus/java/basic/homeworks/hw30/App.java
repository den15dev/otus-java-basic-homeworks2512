package ru.otus.java.basic.homeworks.hw30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    private final static int totalRepeats = 5;
    private static volatile char currentChar = 'A';
    private static final Object mon = new Object();


    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(3)) {
            service.execute(() -> printSymbolAndSleep('A', 'B', false));
            service.execute(() -> printSymbolAndSleep('B', 'C', false));
            service.execute(() -> printSymbolAndSleep('C', 'A', true));
        }
    }


    private static void printSymbolAndSleep(char symbol, char nextSymbol, boolean isLastSymbol) {
        synchronized (mon) {
            for (int i = 0; i < totalRepeats; i++) {
                while (currentChar != symbol) {
                    try {
                        mon.wait();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.print(symbol);
                currentChar = nextSymbol;

                if (isLastSymbol) {
                    System.out.print(" ");
                }

                if (!isLastSymbol || i < totalRepeats - 1) {
                    try {
                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                mon.notifyAll();
            }
        }
    }
}
