package lesson7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NameList nameList = new NameList();
        nameList.add("first");

        class MyThread1 extends Thread {
            @Override
            public void run() {
                System.out.println(nameList.removeFirst());
            }
        }
        MyThread1 myThread1 = new MyThread1();
        myThread1.setName("MyThread1");
        myThread1.start();
        new MyThread1().start();
    }

    static class NameList {
        private List list = Collections.synchronizedList(new ArrayList<>());

        public void add(String name) {
            list.add(name);
        }

        public List getList() {
            return list;
        }

        public synchronized String removeFirst() {
            if (list.size() > 0) {
                if (Thread.currentThread().getName().equals("MyThread1")) {
                    Thread.yield();
                }
                return list.remove(0).toString();
            }
            return null;
        }
    }
}
