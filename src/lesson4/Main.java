package lesson4;

class Car {
    private static int count = 0;

    public static synchronized void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

class WorkerThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Car.incrementCount();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WorkerThread t1 = new WorkerThread();
        WorkerThread t2 = new WorkerThread();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Total cars created: " + Car.getCount());
    }
}