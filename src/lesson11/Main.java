package lesson11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.i = 5;
        resource.j = 5;
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        myThread.setName("one");
        myThread.setResource(resource);
        myThread1.setResource(resource);
        myThread.start();
        myThread1.start();
        myThread.join();
        myThread1.join();
        System.out.println(resource.i);
        System.out.println(resource.j);
    }
}

class MyThread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeJ();
        resource.changeI();
    }
}

class Resource{
    int i;
    int j;
    Lock lock = new ReentrantLock();

    public void changeJ(){
        lock.lock();
        if(Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }
        int j = this.j;
        j++;
        this.j = j;
    }

    public void changeI(){
        if(Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }
        int i = this.i;
        i++;
        this.i = i;
        lock.unlock();
    }
}