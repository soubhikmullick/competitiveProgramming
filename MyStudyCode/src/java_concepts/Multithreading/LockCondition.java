package java_concepts.Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {

    private Lock lock = new ReentrantLock();
    private Condition produced = lock.newCondition();
    private Condition consumed = lock.newCondition();
    private Queue<Integer> list = new LinkedList<>();
    private int i = 0;

    public void producer() throws InterruptedException {
        while (list.size() <= 20) {
            lock.lock();
            System.out.println("Produced i = " + i);
            list.add(i++);
            while (list.size() == 20) {
                consumed.await();
            }
            produced.signal();
            Thread.sleep(100);
            lock.unlock();
        }

    }

    public void consumer() throws InterruptedException {

        while (list.size() >= 0) {
            lock.lock();
            while (list.size() == 0) {
                produced.await();
            }
            System.out.println("Consumed i = " + list.remove());
            consumed.signal();
            Thread.sleep(100);
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        LockCondition lc = new LockCondition();
        Thread t1 = new Thread(() -> {
            try {
                lc.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                lc.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                lc.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                lc.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        t3.start();

        t2.start();

        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
