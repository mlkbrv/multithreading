package lesson2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
//        myThread.setPriority(MyThread.MAX_PRIORITY);
//        Thread.sleep(4000);
//        Thread.yield();
        myThread.join();
        System.out.println("thread main");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread 0");
    }
}