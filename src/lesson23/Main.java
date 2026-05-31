package lesson23;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("MyThread");
                t.setPriority(Thread.MIN_PRIORITY);
                return t;
            }
        };
        threadFactory.newThread(new MyRunnable()).start();
    }
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
