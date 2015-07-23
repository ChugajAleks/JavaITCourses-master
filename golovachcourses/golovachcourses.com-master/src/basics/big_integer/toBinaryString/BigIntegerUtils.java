package basics.big_integer.toBinaryString;

import java.math.BigInteger;

public class BigIntegerUtils {

    public static String toBitStr(BigInteger arg) {

        /*
        Converting BigInteger to binary string
        http://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#toString%28int%29
         */

        return arg.toString(2);

    }

}