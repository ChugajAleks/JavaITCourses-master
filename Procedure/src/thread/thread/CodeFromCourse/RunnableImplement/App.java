package thread.thread.CodeFromCourse.RunnableImplement;

public class App {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableImpl());
        thread.start();
    }

}
