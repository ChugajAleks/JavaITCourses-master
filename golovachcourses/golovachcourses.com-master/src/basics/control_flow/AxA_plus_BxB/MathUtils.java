package basics.control_flow.AxA_plus_BxB;

public class MathUtils {

    public static int lookFor(int max) {

        int a, b=0;
        int count = 0;
        int limit = max;

        for (a=1; a <= limit; a++) {
            for (b=1; b <= limit; b++) {
                if ((a*a + b*b) <= max) {
                    count++;
                }
            }
        }

        return count;

    }
}