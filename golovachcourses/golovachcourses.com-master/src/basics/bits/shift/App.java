package basics.bits.shift;

import static java.lang.Integer.toBinaryString;
import static java.lang.String.format;

/**
 *
 * basics.bits.shift.left
 *
 * Реализовать метод leftShift(int) класса IntegerUtils, который осуществляют ЦИКЛИЧЕСКИЙ СДВИГ
 * (биты, которые “выталкивают” с одного конца – появляются на втором конце) битов влево.
 * То есть leftShift(int)
 * получив число 0b00000000_00000000_00000000_00000001 возвращает 0b00000000_00000000_00000000_00000010
 * получив число 0b10000000_00000000_00000000_00000000 возвращает 0b00000000_00000000_00000000_00000001
 * получив число 0b00111000_11111111_00000000_10101010 возвращает 0b01110001_11111110_00000001_01010100
 *
 * Реализовать метод rightShift(int) класса IntegerUtils, который осуществляют ЦИКЛИЧЕСКИЙ СДВИГ
 * (биты, которые “выталкивают” с одного конца – появляются на втором конце) битов вправо.
 * То есть rightShift(int)
 * получив число 0b00000000_00000000_00000000_00000001 возвращает 0b10000000_00000000_00000000_00000000
 * получив число 0b10000000_00000000_00000000_00000000 возвращает 0b01000000_00000000_00000000_00000000
 * получив число 0b00111000_11111111_00000000_10101010 возвращает 0b00011100_01111111_10000000_01010101
 *
 * another one solution: http://en.wikipedia.org/wiki/Circular_shift
 *
 */

public class App {

    public static void main(String[] args) {

        int result1 = basics.bits.shift.left.IntegerUtils.leftShift(0b00000000_00000000_00000000_00000001);
        printlnBinary(result1);

        int result2 = basics.bits.shift.right.IntegerUtils.rightShift(0b00000000_00000000_00000000_00000001);
        printlnBinary(result2);

    }

    public static void printlnBinary(int x) {
        System.out.println("0b" + format("%32s", toBinaryString(x)).replace(' ', '0'));
    }
}
