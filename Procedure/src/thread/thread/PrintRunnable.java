package thread.thread;

/**
 * User: Igor Russo
 * Date: 26.02.13
 * Time: 7:29
 */
public class PrintRunnable implements Runnable {
    private String msg;
    private long sleepMillis;
    private static int id = 0;

    public PrintRunnable(String msg, long sleepMillis) {
        id++;
        this.msg = msg;
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        for (int k = 0; k < 10; k++) {
            try {
               Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("id = " + id + "; k = " + k + "; msg = " + msg);
        }
    }
}
