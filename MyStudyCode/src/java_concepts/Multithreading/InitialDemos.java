package java_concepts.Multithreading;

class Runner extends Thread {
    public void run() {
        for(int i=0;i<10;i++)
            System.out.println("Hello " + i);
        System.out.println("--------------------");
    }
}

class RunnerImp implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<10;i++)
            System.out.println("Hello " + i);
        System.out.println("--------------------");

    }
}

public class InitialDemos {
    public static void main(String[] args) {
        Runner r1 = new Runner();
        Thread t1 = new Thread(new RunnerImp());
        r1.start();
        t1.start();


        Thread runnableInstance = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                    System.out.println("Hello " + i );
                System.out.println("--------------------");

            }
        });
        runnableInstance.start();

        try {
            r1.join();
            t1.join();
            runnableInstance.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
