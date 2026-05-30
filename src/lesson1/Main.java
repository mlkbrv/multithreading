package lesson1;

public class Main {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        System.out.println(Thread.currentThread().getName());
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread1 = new Thread(myRunnable);
//        Thread thread2 = new Thread(myRunnable);
//        thread1.start();
//        thread2.start();
        new MyThread2().start();
        new MyThread2().start();
        new MyThread2().start();
    }
}



class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("This is new thread");
        someMethod();
    }
    private void someMethod() {
        throw new RuntimeException();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i=0; i<40; i++) {
            System.out.println("This thread name is "+Thread.currentThread().getName()+" i = "+i);
        }
    }
}