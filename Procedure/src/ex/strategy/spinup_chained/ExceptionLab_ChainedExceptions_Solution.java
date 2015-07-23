package ex.strategy.spinup_chained;

import java.util.Arrays;

/**
 * User: Igor Russo
 * Date: 02.02.13
 * Time: 22:46
 */
public class ExceptionLab_ChainedExceptions_Solution {
    public static void main(String[] args) {
        try {
            f();
        } catch (RuntimeException e) {
            String[] messageArray = extractMessages(e);
            System.out.println(Arrays.toString(messageArray));
        }
    }

    public static void f() {
        RuntimeException tail = new RuntimeException("0");
        for (int k = 1; k < 10; k++) {
            tail = new RuntimeException("message from: " + k, tail);
        }
        throw tail;
    }

    public static String[] extractMessages(Throwable t) {
        // Достаем длину списка
        int length = 0;
        Throwable temp = t;
        while(temp.getCause() != null)
        {
            temp = temp.getCause();
            length++;
        }

        // Создаем массив нужной нам длины
        String[] result = new String[length];

        // Заполняем массив значениями
        while(length > 0)
        {
            result[--length] = t.getMessage();
            t = t.getCause();
        }
        return result;
    }
}
