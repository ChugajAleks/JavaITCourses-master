package thread.thread.CodeFromCourse.Demon;

/**
 * Created by aleks on 01.09.15.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main.isDeamon " + Thread.currentThread().isDaemon());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                System.out.println("Thread 1.isDeamon " + Thread.currentThread().isDaemon());
                Thread oneMoreThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Thread 2 start");
                        System.out.println("Thread 2.isDeamon " + Thread.currentThread().isDaemon());
                        while(true){
                            /*NOP*/
                        }
                    }
                });
                oneMoreThread.start();//т. к. oneMoreThread поррожден от демона он тоже демон
                while(true){
                    /*NOP*/
                }
            }
        });
        //thread.setDaemon(false);//thread не демон поэтому висим
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1000);
    }
}
