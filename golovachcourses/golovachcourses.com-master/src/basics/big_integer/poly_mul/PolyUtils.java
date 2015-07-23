package basics.big_integer.poly_mul;

import java.math.BigInteger;

public class PolyUtils {

    /**
     *
     * Return the product of 2 polynomials, i.e. (x+1) * (x+1)
     * @param x - BigInteger array
     * @param y - BigInteger array
     * @return  - BigInteger array
     * {@link http://stackoverflow.com/questions/21717426/converting-whole-program-from-int-to-biginteger}
     */
    public static BigInteger[] mul(BigInteger[] x, BigInteger[] y) {

        BigInteger[] result = new BigInteger[degree(x) + degree(y) + 1];
        initializeBigIntegerArray(result);
        for (int i = 0; i <= degree(x); i++)
            for (int j = 0; j <= degree(y); j++) {
                System.out.println("x[i] = " + x[i]);
                System.out.println("y[j] = " + y[j]);
                result[i + j] = result[i + j].add(x[i].multiply(y[j]));

            }

        return result;

    }

    /**
     *
     * Return the degree of this polynomial (0 for the constant polynomial).
     * @param coef - BigInteger array
     * @return     - degree of this polynomial
     */
     public static int degree(BigInteger[] coef) {
        int d = 0;
        for (int i = 0; i < coef.length; i++)
            if (coef[i] != BigInteger.valueOf(0)) d = i;
        return d;
    }

    private static void initializeBigIntegerArray(BigInteger[] bigIntegers) {
        for (int i=0; i<bigIntegers.length; i++) {
            // So you don't overwrite anything you assign explicitly
            if (bigIntegers[i] == null) {
                bigIntegers[i] = BigInteger.ZERO;
            }
        }
    }
}




/*

for test:

        int degreeX = 0;
        for (int di = 0; di < x.length; di++)
            if (x[di] != BigInteger.valueOf(0)) degreeX = di;

        int degreeY = 0;
        for (int dy = 0; dy < y.length; dy++)
            if (y[dy] != BigInteger.valueOf(0)) degreeY = dy;

        BigInteger[] result = new BigInteger[degreeX + degreeY + 1];

        for (int m=0; m<result.length; m++) {
            // So you don't overwrite anything you assign explicitly
            if (result[m] == null) {
                result[m] = BigInteger.ZERO;
            }
        }

        for (int i = 0; i <= degreeX; i++)
            for (int j = 0; j <= degreeY; j++) {
                result[i + j] = result[i + j].add(x[i].multiply(y[j]));

            }

        return result;
*/
