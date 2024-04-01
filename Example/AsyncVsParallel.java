package Example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncVsParallel {

    public static void main(String[] args) throws Exception {
        // Varying dataset sizes
        int[] datasetSizes = {100, 1000, 10000};

        for (int size : datasetSizes) {
            System.out.println("Dataset size: " + size);

            // Asynchronous Programming
            long startTimeAsync = System.nanoTime();
            runAsynchronousTasks(size);
            long endTimeAsync = System.nanoTime();
            long durationAsync = TimeUnit.MILLISECONDS.convert(endTimeAsync - startTimeAsync, TimeUnit.NANOSECONDS);
            System.out.println("Asynchronous Execution Time: " + durationAsync + " ms");

            // Parallel Programming
            long startTimeParallel = System.nanoTime();
            runParallelTasks(size);
            long endTimeParallel = System.nanoTime();
            long durationParallel = TimeUnit.MILLISECONDS.convert(endTimeParallel - startTimeParallel, TimeUnit.NANOSECONDS);
            System.out.println("Parallel Execution Time: " + durationParallel + " ms");

            System.out.println();
        }
    }

    private static void runAsynchronousTasks(int size) {
        CompletableFuture<Void>[] futures = new CompletableFuture[size];
        for (int i = 0; i < size; i++) {
            final int index = i;
            futures[i] = CompletableFuture.runAsync(() -> {
                // Simulate some processing
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        // Wait for all tasks to complete
        CompletableFuture.allOf(futures).join();
    }

    private static void runParallelTasks(int size) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < size; i++) {
            final int index = i;
            executor.submit(() -> {
                // Simulate some processing
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }
}
