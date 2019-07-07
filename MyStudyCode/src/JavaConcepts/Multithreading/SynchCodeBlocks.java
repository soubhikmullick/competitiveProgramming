package JavaConcepts.Multithreading;

public class SynchCodeBlocks {
    private int count1 = 0;
    private int count2 = 0;
    public Object lock1 = new Object();
    public Object lock2 = new Object();


    public void incre1() {
        synchronized (lock1) {
            for(int i=0; i<1000; i++)
            {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count1++;
            }
        }
    }

    public void incre2() {
        synchronized (lock2) {
            for(int i=0; i<1000; i++)
            {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count2++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting");
        long start = System.currentTimeMillis();
        SynchCodeBlocks synchCodeBlocks = new SynchCodeBlocks();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchCodeBlocks.incre1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchCodeBlocks.incre2();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Total Time = "+ (end-start));
        System.out.println("Count = "+ (synchCodeBlocks.count1+synchCodeBlocks.count2) );

    }
}
