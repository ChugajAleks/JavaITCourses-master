package basics.bits.swap;

/**
 *
 * Реализуйте метод swapBits(b, i, j), который производит "рокировку" битов с номерами i и j, то есть
 * swapBits(0b1111_0000, 0, 6) = 0b1011_0001
 * swapBits(0b0000_1000, 3, 1) = 0b0000_0010
 *
 */

public class App {

    public static void main(String[] args) {

        byte b = (byte) 0b1111_0000;
        printByteInBinary(b);

        byte result = BitUtils.swapBits(b, 0, 6);
        printByteInBinary(result);
        
    }

    /**
     *
     * 0xFF basically converts a signed byte to an unsigned integer.
     * For example, -129 is represented by 11111111111111111111111110000001.
     * In this case, you basically want the first (least significant) 8 bits,
     * so you AND (&) it with 0xFF (00000000000000000000000011111111),
     * effectively cleaning the 1's to the left that we don't care about, leaving out just 10000001
     *
     * @param b byte value
     * {@link http://stackoverflow.com/a/12310078}
     *
     */

     public static void printByteInBinary(byte b) {
         String s1 = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
         System.out.println("0b" + s1); // 11110000
     }
}
