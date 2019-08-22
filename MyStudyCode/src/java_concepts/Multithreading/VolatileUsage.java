package java_concepts.Multithreading;

class Volatile implements Runnable {

    private volatile boolean status = true;

    @Override
    public void run() {
        while (status) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.status = false;
    }
}

public class VolatileUsage {
    public static void main(String[] args) {
        Volatile v = new Volatile();
        Thread t1 = new Thread(v);
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.shutdown();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
