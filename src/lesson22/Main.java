package lesson22;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();


        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                queue.add("1");
            }
        }.start();
    }
}
