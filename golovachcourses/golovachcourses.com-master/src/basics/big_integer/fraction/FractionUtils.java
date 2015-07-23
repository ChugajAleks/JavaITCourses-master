package basics.big_integer.fraction;

import java.math.BigInteger;

/**
 * Created by pafnat on 01/09/14.
 */
public class FractionUtils {

    public static BigInteger[] sum(BigInteger[] x, BigInteger[] y) {

        BigInteger cDevX = x[1].gcd(x[1].multiply(y[1]));
        BigInteger cDevY = y[1].gcd(x[1].multiply(y[1]));

        // sum
        BigInteger cDev = cDevY.multiply(x[0]).add(cDevX.multiply(y[0]));
        BigInteger cDen = x[1].multiply(y[1]);

        // the result should be as irreducible
        // now assign gcd of cDev, cDen to bi
        BigInteger bi = cDev.gcd(cDen);

        String str = "GCD of " + cDev + " and " + cDen + " is " + bi;
        // print bi value
        //System.out.println( str );

        cDev = cDev.divide(bi);
        cDen = cDen.divide(bi);


        BigInteger[] result = {cDev, cDen};


        return result;
    }
}
