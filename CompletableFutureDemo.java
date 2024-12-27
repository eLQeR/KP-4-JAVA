import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class CompletableFutureDemo {
    private static final Logger logger = Logger.getLogger(CompletableFutureDemo.class.getName());

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Task 1: Generate and process sequence of natural numbers
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            logger.info("Task 1: Generating a sequence of natural numbers.");
            List<Integer> numbers = new Random().ints(20, 1, 100).boxed().toList();
            logger.info("Generated sequence: " + numbers);

            int minSum = IntStream.range(0, numbers.size() - 1)
                    .map(i -> numbers.get(i) + numbers.get(i + 1))
                    .min()
                    .orElseThrow();

            logger.info("Minimum sum of consecutive pairs: " + minSum);
        });

        // Task 2: Generate and process 3x3 matrix
        CompletableFuture<Void> task2 = CompletableFuture.supplyAsync(() -> {
            logger.info("Task 2: Generating a 3x3 matrix.");
            int[][] matrix = new int[3][3];
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = random.nextInt(100);
                }
            }
            logger.info("Generated matrix:");
            for (int[] row : matrix) {
                logger.info(Arrays.toString(row));
            }
            return matrix;
        }).thenAcceptAsync(matrix -> {
            for (int i = 0; i < 3; i++) {
                StringBuilder column = new StringBuilder("Column " + (i + 1) + ": ");
                for (int j = 0; j < 3; j++) {
                    column.append(matrix[j][i]).append(" ");
                }
                logger.info(column.toString());
            }
        }).thenRunAsync(() -> logger.info("Task 2 completed."));

        // Task 3: Process real number sequence
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(() -> {
            logger.info("Task 3: Generating a sequence of real numbers.");
            List<Double> realNumbers = new Random().doubles(20, 1.0, 100.0).boxed().toList();
            logger.info("Generated real number sequence: " + realNumbers);

            double minOddIndex = IntStream.range(0, realNumbers.size())
                    .filter(i -> i % 2 == 0)
                    .mapToDouble(realNumbers::get)
                    .min()
                    .orElseThrow();

            double maxEvenIndex = IntStream.range(0, realNumbers.size())
                    .filter(i -> i % 2 != 0)
                    .mapToDouble(realNumbers::get)
                    .max()
                    .orElseThrow();

            double result = minOddIndex + maxEvenIndex;
            logger.info("Result (min odd index + max even index): " + result);
        });

        // Wait for all tasks to complete
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        allTasks.join();

        long endTime = System.currentTimeMillis();
        logger.info("All tasks completed in: " + (endTime - startTime) + " ms");
    }
}
