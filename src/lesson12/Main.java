package lesson12;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
    static class Thread1 extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println(getName()+" started working");
            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName()+" stop working");
            lock.unlock();
            System.out.println(getName()+" lock is released");
        }
    }
    static class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println(getName()+" started working");
            while(true) {
                if (lock.tryLock()) {
                    System.out.println(getName() + " stop working");
                    break;
                } else  {
                    System.out.println(getName()+" waiting ");
                }
            }
        }
    }
}
