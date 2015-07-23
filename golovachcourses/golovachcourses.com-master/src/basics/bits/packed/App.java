package basics.bits.packed;

/**
 *
 * Спецификация Java оставляет за разработчиком JVM право определить размер boolean.
 * Таким образом в массиве boolean[] каждый элемент занимает не меньше одного бита
 * (а возможно и один байт или даже машинное слово (32 или 64 бита)).
 * Предлагается вместо boolean[] использовать биты long. Тогда мы гарантированно тратим по одному биту на boolean
 * см. класс PackedFlagArray64
 *
 * Однако такое решение не подходит для случая, если мы хотим хранить более 64 флагов.
 * Необходимо перейти от long к long[]. Сделайте это - реализуйте методы setFlag(int, boolean) и getFlag(int).
 * P.S. Обратите внимание, что хотя окно для ввода ОДНО, Вы тем не менее можете реализовать ДВА метода следующим образом
 */

public class App {

    public static void main(String[] args) {

/*
        int LEN = 10;
        PackedFlagArray64 mask = new PackedFlagArray64(LEN);
        mask.setFlag(3, true);
        mask.setFlag(7, true);

        for (int k = 0; k < LEN; k++) {
            System.out.println("mask[" + k + "]: " + mask.getFlag(k));
        }

        System.out.println("mask: " + mask);
*/


        int LEN = 75;
        // создаем новый массив флагов
        PackedFlagArray mask = new PackedFlagArray(LEN);

        // и проверяем, что там одни false-ы
        for (int k = 0; k < LEN; k++) {
            if (mask.getFlag(k)) {
                throw new AssertionError();
            }
        }


        System.out.println("OK");



        System.out.println("mask: " + mask);

        mask.setFlag(0, true);
        mask.setFlag(10, true);
        mask.setFlag(63, true);
        mask.setFlag(64, true);
        mask.setFlag(65, true);
        mask.setFlag(74, true);


        System.out.println("mask: " + mask);

        System.out.println("=========");
        for (int k = 0; k < LEN; k++) {
            System.out.println("mask[" + k + "]: " + mask.getFlag(k));
        }

        System.out.println("mask: " + mask);




    }





}