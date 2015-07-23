package basics.big_integer.poly_eval;

import java.math.BigInteger;

public class PolyUtils {

    public static BigInteger eval(BigInteger[] poly, BigInteger arg) {

        BigInteger result = new BigInteger("0");

        for (int i = 0; i < poly.length ; i++) {

            int pow = poly.length - i - 1;
            result = result.add(poly[i].multiply(arg.pow(pow)));

        }

        return result;
    }
}
