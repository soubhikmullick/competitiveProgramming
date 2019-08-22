package java_concepts.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ProdConsumerApi {
    private List<Integer> list = new ArrayList<>();
    int num, inp;

    public void producer(Object lock) {
        synchronized (lock) {
            while (list.size() < 10) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                inp = new Random().nextInt(10);
                System.out.println("Produced : "+inp);
                list.add(inp);
                lock.notify();
            }
            while (list.size() == 10) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consumer(Object lock) {
        synchronized (lock) {
            while (list.size() == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (list.size() > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num = list.remove(list.size() - 1);
                System.out.println("Element removed is : "+ num);
                lock.notify();
            }

        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Started");
        ProdConsumerApi prodConsumerApi = new ProdConsumerApi();
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            for(int i=0;i<100;i++)
                prodConsumerApi.producer(lock);
        });

        Thread t2 = new Thread(() -> {
            for(int i=0;i<100;i++)
                prodConsumerApi.consumer(lock);
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Finished");

    }
}
