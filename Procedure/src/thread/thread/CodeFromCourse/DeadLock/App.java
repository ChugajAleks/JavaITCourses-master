package thread.thread.CodeFromCourse.DeadLock;

/**
 * Created by aleks on 01.09.15.
 */
//Два потока могут попасть в "классический deadlock" ("Егорыч: не умру, пока не дождусь
// похорон Сидорыча; Сидорыч: не умру, пока не дождусь похорон Егорыча")
public class App {
    public static void main(String[] args) {
        final Thread[] thread = new Thread[2];
        thread[0] = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("#0 join to #1");
                try {
                    thread[1].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread[1] = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("#1 join to #0");
                try {
                    thread[0].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread[0].start();
        thread[1].start();
    }
}
