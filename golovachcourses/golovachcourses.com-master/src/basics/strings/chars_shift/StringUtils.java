package basics.strings.chars_shift;

/**
 * Реализовать функцию, которая делает циклический сдвиг букв вправо, то есть
 * rightShift("ABCDE", 1) = "EABCD"
 * rightShift("ABCDE", 2) = "DEABC"
 * rightShift("ABCDE", 3) = "CDEAB"
 * rightShift("ABCDE", 4) = "BCDEA"
 *
 * Допустимо сдвигать на расстояние больше длины строки
 * rightShift("ABCDE", 5) = "ABCDE"
 * rightShift("ABCDE", 6) = "EABCD"
 * rightShift("ABCDE", 7) = "DEABC"
 *
 * Допустимо сдвигать на отрицательное расстояние (выходит сдвиг влево)
 * rightShift("ABCDE", -1) = "BCDEA"
 * rightShift("ABCDE", -2) = "CDEAB"
 * rightShift("ABCDE", -7) = "CDEAB"
 *
 * В случае аргумента null - выкидывать IllegalArgumentException.
 * Сдвиг на расстояние 0 и сдвиги строк длиной 0 и 1 символ - разрешены.
 *
 * TODO: не работает проверка на сайте, хотя тут все должно быть верно.
 */


public class StringUtils {

    public static String rightShift(String arg, int delta) {

        if (arg == null) throw new IllegalArgumentException("arg is null");

        String result = arg;
        System.out.println(delta);
        System.out.println(-delta);
        if (delta>=0) {
            for (int i = 0; i < delta; i++) {
                result = result.charAt(result.length() - 1) + result.substring(0, result.length() - 1);
            }
        } else {
            delta = -delta;
            for (int i = 0; i < delta; i++) {
                result = result.charAt(1) + result.substring(2, result.length() ) + result.substring(0, 1);
            }
        }


        return result;

    }

}

class TestRightShift {

    public static void main(String[] args) {

        System.out.println(StringUtils.rightShift("ABCDE", 2));

    }

}

