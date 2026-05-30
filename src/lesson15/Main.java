package lesson15;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MyRunnable());
        executorService.submit(new MyCallable<String>());
        executorService.shutdown();
    }
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable");
        }
    }
    static class MyCallable<T> implements Callable<T> {
        @Override
        public T call() {
            System.out.println("MyCallable");
            return null;
        }
    }
}
