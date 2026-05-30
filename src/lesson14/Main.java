package lesson14;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Long> task = new SumTask();
        FutureTask<Long> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("Counting");
        Long result = futureTask.get();
        System.out.println(result);
    }

    static class SumTask implements Callable<Long> {
        @Override
        public Long call() throws Exception {
            long result = 0;
            for (int i = 1; i <= 1_000_000; i++) {
                result += i;
            }
            return result;
        }
    }
}
