import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Java21VirtualThreads {

    /**
     * Example from <a href="https://www.youtube.com/watch?v=aXGrR8Q9_ak">Virtual Threads in Java 21</a>
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var begin = Instant.now();

        // Play with following number of threads
        int numberOfThreads = 1_000;

        // Executors.newVirtualThreadPerTaskExecutor()
        // Executors.newFixedThreadPool(numberOfThreads)
        // Executors.newCachedThreadPool()
        try (var executor = Executors.newCachedThreadPool()) {
            IntStream.range(0, numberOfThreads)
                    .forEach(i -> executor.submit(() -> {
                        Thread.sleep(Duration.ofSeconds(1));
                        return i;
                    }));
        }

        var end = Instant.now();
        System.out.println("Duration: " + Duration.between(begin, end));
    }

}