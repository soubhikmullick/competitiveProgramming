package Multithreading;

class Incrementor implements Runnable{
    private int count = 0;
    @Override
    public void run() {
        for(int i=0;i<10000;i++)
            incre(); //count++ will give wrong result here
    }

    public synchronized void incre() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizedKeyword {
    public static void main(String[] args) {
        Incrementor incrementor = new Incrementor();
        Thread t1 = new Thread(incrementor);
        Thread t2 = new Thread(incrementor);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(incrementor.getCount());
    }
}
