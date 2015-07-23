import java.net.URL;
import java.util.Scanner;


public class HTTPRequest {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new URL("http://www.rosettacode.org").openStream());
        while (sc.hasNext())
            System.out.println(sc.nextLine());
        sc.close();
    }
}
