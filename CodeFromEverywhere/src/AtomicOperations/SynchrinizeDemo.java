package AtomicOperations;

/**
 * Created by aleks on 03.09.15.
 */
public class SynchrinizeDemo {
    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();
        counter.set(0);
        Thread[] threads = new Thread[2];
        threads[0] = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.err.println("Thread 1 -> " + counter.increment());
                    System.err.println("Thread 1 <- " + counter.get());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threads[1] = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.err.println("Thread 2 -> " + counter.increment());
                    System.err.println("Thread 2 <- " + counter.get());
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        threads[0].start();
        threads[1].start();
    }
}
