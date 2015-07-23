package basics.big_integer.fraction;

import basics.big_integer.toBinaryString.BigIntegerUtils;

import java.math.BigInteger;

/**
 * Предположим, что мы работаем с дробями, представляя их как пару BigInteger-ов.
 * 2/3 будем представлять как
 * BigInteger[] x = {new BigInteger("2"), new BigInteger("3")};
 * Реализовать метод, который обеспечивает
 * - сложение дробей
 * 1/3 + 1/3 = 2/3
 * 1/2 + 1/3 = 5/6
 * - итоговая дробь должна быть несократимой
 * 1/2 + 1/2 = 1/1 (а не 2/2)
 * 2/3 - 1/6 = 1/2 (а не 3/6)
 * 1/2 + (-1)/2 = 0/1 (а не 0/2)
 * ---
 * P.S. Возможно, вам потребуется метод BigInteger.gcd().
 *
 */

public class App {

    public static void main(String[] args) {
        BigInteger[] x = {new BigInteger("1"), new BigInteger("3")};
        BigInteger[] y = {new BigInteger("1"), new BigInteger("3")};

        BigInteger[] res = FractionUtils.sum(x, y);

        System.out.println("result = " + res[0] + "/" + res[1]);


/*
        // create 3 BigInteger objects
        BigInteger bi1, bi2, bi3;

        // assign values to bi1, bi2
        bi1 = new BigInteger("2");
        bi2 = new BigInteger("3");

        // assign gcd of bi1, bi2 to bi3
        bi3 = bi1.gcd(bi2);

        String str = "GCD of " + bi1 + " and " + bi2 + " is " +bi3;

        // print bi3 value
        System.out.println( str );*/

    }

}
