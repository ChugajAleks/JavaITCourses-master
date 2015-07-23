package basics.array.rotate_2D;




import java.util.Arrays;


/**
 * Реализуйте метод rotateClockwise(int[][]) класса ArrayUtils, который
 * 1) проверяет, что метод получил "квадратную" матрицу (допустимые размеры 1x1, 2x2, 3x3, ...) иначе выбрасывает исключение
 * throw new IllegalArgumentException();
 * (возможные ошибки: null вместо массива, одна из размерностей = 0, длина не равна ширине, есть строки разной длины, есть строки с null вместо одномерных массивов)
 * 2) "проворачивает" массив по часовой стрелке на 90 градусов, т.е
 * [1]
 * ->
 * [1]
 * <p>
 * [[1, 2],
 * [3, 4]]
 * ->
 * [[3, 1],
 * [4, 2]]
 * <p>
 * [[1, 2, 3],
 * [4, 5, 6],
 * [7, 8, 9]]
 * ->
 * [[7, 4, 1],
 * [8, 5, 2],
 * [9, 6, 3]]
 * ...
 */
public class ArrayUtils {
    public static int[][] rotateClockwise(int[][] arg) {


        if (arg == null || arg.length == 0 || arg[0] == null || arg[0].length != arg.length) {
            throw new IllegalArgumentException();
        }

        final int w = arg.length;
        final int h = arg[0].length;

        for(int i = 0; i < w; i++){
            if(arg[i] == null || arg[i].length != h){
                throw new IllegalArgumentException();
            }
        }

        int[][] result = new int[h][w];
        // rotate
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                result[i][j] = arg[w - j - 1][i];
            }
        }

        return result;
    }
}

class RotateTest {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(ArrayUtils.rotateClockwise(arr)));
    }
}