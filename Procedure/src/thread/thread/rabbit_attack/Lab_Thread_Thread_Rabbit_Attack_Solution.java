package thread.thread.rabbit_attack;

/**
 * User: Igor Russo
 * Date: 26.02.13
 * Time: 7:56
 */
public class Lab_Thread_Thread_Rabbit_Attack_Solution {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new RabbitPrinter(" New rabbit born!", 1000)).start();
    }


    private static String spaces(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += " ";
        }
        return result;
    }

    private static class RabbitPrinter implements Runnable {
        private static int id = 0;
        private String msg;
        private long sleepMillis;

        @Override
        public void run() {
            System.out.println(spaces(id) + id + msg);
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (id < 1000) {
                new Thread(new RabbitPrinter( msg, sleepMillis)).start();
            }
        }

        public RabbitPrinter(String msg, long sleepMillis) {
            this.id++;
            this.msg = msg;
            this.sleepMillis = sleepMillis;
        }
    }
}

