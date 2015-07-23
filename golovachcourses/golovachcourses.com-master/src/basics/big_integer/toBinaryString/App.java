package basics.big_integer.toBinaryString;

import java.math.BigInteger;

/**
 * Реализовать метод, который преобразует BigInteger в битовую строку (String из '0' и '1')
 * toBitStr(new BigInteger("2")) = "10"
 * toBitStr(new BigInteger("8")) = "1000"
 * toBitStr(new BigInteger("10")) = "1010"
 * toBitStr(new BigInteger("140")) = "10001100"
 */

public class App {

    public static void main(String[] args) {

        String result = BigIntegerUtils.toBitStr(new BigInteger("10"));
        System.out.println(result);

    }
}