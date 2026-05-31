package lesson24;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {
    static long numOfOperations = 100_000_000_000L;

    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        System.out.println(new Date());
//        long j = 0;
//        for (long i = 0; i <numOfOperations ; i++) {
//            j+=i;
//        }
//        System.out.println(j);
//        Sun May 31 04:36:12 GMT+04:00 2026
//        932355974711512064
//        Sun May 31 04:36:38 GMT+04:00 2026
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new MyFork(0,numOfOperations)));
//        Sun May 31 04:49:17 GMT+04:00 2026
//        932356074711512064
//        Sun May 31 04:49:19 GMT+04:00 2026
        System.out.println(new Date());
    }
    static class MyFork extends RecursiveTask<Long> {

        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from <= 10_000_000L) {
                long j = 0;
                for (long i = from; i <= to; i++) {
                    j += i;
                }
                return j;
            } else {
                long middle = (from + to) / 2;
                MyFork left = new MyFork(from, middle);
                left.fork();
                MyFork right = new MyFork(middle + 1, to);
                long secondValue = right.compute();
                return (secondValue + left.join());
            }
        }
    }
}
