import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final long KEEP_ALIVE_TIME = 5L;
    private static final int QUEUE_CAPACITY = 100;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });
        ExecutorService service1 = Executors.newSingleThreadExecutor();
        ExecutorService service2 = Executors.newCachedThreadPool();
        CompletableFuture<Object> objectCompletableFuture = new CompletableFuture<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 10; i++) {
            Runnable myRunnable = new MyRunnable("" + i);
            threadPoolExecutor.submit(myRunnable);
        }

        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}
