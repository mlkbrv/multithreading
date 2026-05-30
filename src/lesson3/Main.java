package lesson3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.i = 5;
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
    }
}

class MyThread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
    }
}

class Resource{
    int i;
    public void Do()
    {
        synchronized (this) {
            System.out.println("S");
        }
    }
    public synchronized void changeI(){
        if(Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }
        int i = this.i;
        i++;
        this.i = i;
    }
}