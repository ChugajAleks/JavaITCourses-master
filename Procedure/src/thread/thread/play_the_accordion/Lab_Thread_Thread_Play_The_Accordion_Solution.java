package thread.thread.play_the_accordion;

import thread.thread.PrintRunnable;

/**
 * User: Igor Russo
 * Date: 26.02.13
 * Time: 7:30
 */
public class Lab_Thread_Thread_Play_The_Accordion_Solution {
    public static Runnable threadCoordinator;


    public static void main(String[] args) throws InterruptedException {

            threadCoordinator = new CoordinatorRunnable();
            Thread threadCoord = new Thread(threadCoordinator);
            threadCoord.start();
            threadCoord.join();

            System.out.println("Main thread execution complete!");
    }

    private static class CoordinatorRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("CoordinatorRunnable");
            for (int k = 0; k < 10; k++) {
                // A + B
                Runnable printerA = new PrintRunnable("A   .", 100);
                Thread threadA = new Thread(printerA);
                threadA.start();
                Runnable printerB = new PrintRunnable(".   B", 99);
                Thread threadB = new Thread(printerB);
                threadB.start();
                try {
                    threadA.join();
                    threadB.join();
                } catch (InterruptedException e){

                }
                // C
                System.out.println("-----");

                CRunnable cRunnable = new CRunnable();
                Thread threadC = new Thread(cRunnable);
                threadC.start();
                try {
                    threadC.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("----- End of main loop k = "+ k);
            }
        }
    }

    private static class CRunnable implements Runnable {
        @Override
        public void run() {
            Runnable printerC = new PrintRunnable("  C", 100);
            printerC.run();
        }
    }
}
