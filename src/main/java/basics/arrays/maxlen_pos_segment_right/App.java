package basics.arrays.maxlen_pos_segment_right;

import basics.arrays.maxlen_pos_segment_right.ArrayUtils;

import java.util.Arrays;

/**
 * В заданном одномерном массиве найти диапазон максимальной ширины, состоящий из положительных элементов (больше 0).
 * Ответом является массив из двух элементов, где
 * - элемент №0 - индекс элемента левой границы отрезка
 * - элемент №1 - индекс элемента правой границы отрезка
 * Если подходящих диапазоном несколько - вернуть "САМЫЙ ПРАВЫЙ".
 * Если аргумент равен null или длина массива 0 - кинуть IllegalArgumentException.
 * Если в массиве нет такого диапазона (нет положительных чисел) - вернуть массив длины 0.
 * Примеры
 * lookFor([1, 1, 1]) = [0, 2]
 * lookFor([0, 1, 1]) = [1, 2]
 * lookFor([1, 1, 0]) = [0, 1]
 * lookFor([0, -100, 1, 1, 0, -1]) = [2, 3]
 * lookFor([1, 1, 0, 1, 1]) = [0, 1] // возвращаем ПРАВЫЙ
 * lookFor([0, -1, 0, -1]) = [] // нет положительных чисел
 */
public class App {

    public static void main(String[] args) {

        int[] out = ArrayUtils.lookFor(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0});

        System.out.println(Arrays.toString(out));


    }
}
