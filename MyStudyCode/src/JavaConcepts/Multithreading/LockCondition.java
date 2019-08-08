package JavaConcepts.Multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        lock.lock();
        while (list.size() <= 20) {
            System.out.println("Produced i = "+ i);
            list.add(i++);
            while (list.size() == 20) {
                consumed.await();
            }
            produced.signal();
            Thread.sleep(100);
        }
        lock.unlock();
    }

    public void consumer() throws InterruptedException {
        lock.lock();
        while (list.size() >= 0) {
            System.out.println("Consumed i = "+list.remove());
            while(list.size()==0){
                produced.await();
            }
            consumed.signal();
            Thread.sleep(100);
        }
        lock.unlock();
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
                lc.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        Thread.sleep(2);
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
