package lesson5;

public class Main {
    volatile static int i;
    public static void main(String[] args) {
        new WriterThread().start();
        new ReaderThread().start();
    }
    static class WriterThread extends Thread {
        @Override
        public void run() {
            while(i<5){
                System.out.println("increment i to "+(++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    static class ReaderThread extends Thread {
        @Override
        public void run() {
            int localvar = i;
            while(localvar<5){
                if(localvar!=i){
                    System.out.println("new value of i is "+i);
                    localvar=i;
                }
            }
        }
    }
}
