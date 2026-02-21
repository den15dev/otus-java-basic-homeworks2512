package ru.otus.java.basic.homeworks.hw21;

public class MathPerformer {
    private final int numOfIterations;
    private final int numOfThreads;
    private final double[] arr;


    public MathPerformer(int numOfIterations, int numOfThreads) {
        this.numOfIterations = numOfIterations;
        this.numOfThreads = numOfThreads;
        this.arr = new double[numOfIterations];
    }


    private double calc(int val) {
        return 1.14 * Math.cos(val) * Math.sin(val * 0.2) * Math.cos(val / 1.2);
    }


    public void calculateSingleThread() {
        long startTime = System.nanoTime();

        for (int i = 0; i < numOfIterations; i++) {
            arr[i] = calc(i);
        }

        long duration = System.nanoTime() - startTime;
        System.out.println("Время выполнения одним потоком: " + duration / 1_000_000 + " мс");
    }


    public void calculateMultiThread() throws InterruptedException {
        int chunk = numOfIterations / numOfThreads;
        Thread[] threads = new Thread[numOfThreads];
        long startTime = System.nanoTime();

        for (int j = 0; j < numOfThreads; j++) {
            int startIndex = chunk * j;
            int endIndex = (j == numOfThreads - 1)
                    ? numOfIterations
                    : chunk * (j + 1);

            threads[j] = new Thread(() -> {
                for (int i = startIndex; i < endIndex; i++) {
                    arr[i] = calc(i);
                }
            });
            threads[j].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long duration = System.nanoTime() - startTime;
        System.out.println("Время выполнения " + numOfThreads + " потоками: " + duration / 1_000_000 + " мс");
    }
}
