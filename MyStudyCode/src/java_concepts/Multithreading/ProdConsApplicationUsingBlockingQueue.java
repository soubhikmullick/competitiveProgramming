package java_concepts.Multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdConsApplicationUsingBlockingQueue {
    private BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

    private void producer(int i) throws InterruptedException {
        Thread.sleep(80);
        arrayBlockingQueue.put(i);
    }

    private void consumer() throws InterruptedException {
        Thread.sleep(100);
        System.out.println(arrayBlockingQueue.remove());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Started");

        ProdConsApplicationUsingBlockingQueue prodConsApplicationUsingBlockingQueue = new ProdConsApplicationUsingBlockingQueue();
        Thread t1 = new Thread(() -> {
            for(int i=0;i<100;i++) {
                try {
                    prodConsApplicationUsingBlockingQueue.producer(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0;i<100;i++) {
                try {
                    prodConsApplicationUsingBlockingQueue.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Finished");
    }
}
