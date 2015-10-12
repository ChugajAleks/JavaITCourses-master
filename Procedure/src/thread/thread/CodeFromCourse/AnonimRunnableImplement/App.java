package thread.thread.CodeFromCourse.AnonimRunnableImplement;

/**
 * Created by aleks on 01.09.15.
 */
public class App {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        }).start();
    }
}
