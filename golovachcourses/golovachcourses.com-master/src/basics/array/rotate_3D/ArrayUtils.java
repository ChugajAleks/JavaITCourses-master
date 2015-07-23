package basics.array.rotate_3D;
import java.util.Arrays;
//import basics.array.rotate_3D.ArrayUtils;

/**
 * Реализуйте метод rotateClockwise класса ArrayUtils, который
 * 1) проверяет, что метод получил "кубическую" матрицу (допустимые размеры 1x1x1, 2x2x2, 3x3x3, ...) иначе выбрасывает исключение
 * throw new IllegalArgumentException(); (возможные ошибки: аргумент равен null, "длина" / "ширина" / "высота" не равны,
 * есть строки разной длины, есть строки с null вместо одномерных/двумерных массивов ...)
 * 2) "проворачивает куб" относительно главной диагонали проходящей от элемента [0][0][0] до элемента [L-1][L-1][L-1]
 * (L - длина "грани куба") массив по часовой стрелке на 120 градусов (по часовой стрелке - если смотреть вдоль оси от
 * элемента [L-1][L-1][L-1] в сторону элемента [0][0][0]), то есть
 *
 * [[[1]]]
 * ->
 * [[[1]]]
 *
 * [
 * [[1, 2],
 * [3, 4]],
 * [[5, 6],
 * [7, 8]],
 * ]
 * ->
 * [
 * [[1, 3],
 * [5, 7]],
 * [[2, 4],
 * [6, 8]],
 * ]
 *
 * [
 * [[10, 11, 12],
 * [20, 21, 22],
 * [30, 31, 32]],
 *
 * [[40, 41, 42],
 * [50, 51, 52],
 * [60, 61, 62]],
 *
 * [[70, 71, 72],
 * [80, 81, 82],
 * [90, 91, 92]]
 * ]
 * ->
 * [
 * [[10, 40, 70],
 * [11, 41, 71],
 * [12, 42, 72]],
 *
 * [[20, 50, 80],
 * [21, 51, 81],
 * [22, 52, 82]],
 *
 * [[30, 60, 90],
 * [31, 61, 91],
 * [32, 62, 92]]
 * ]
 * ...
 */
public class ArrayUtils {
    public static int[][][] rotateClockwise(int[][][] arr) {
        try{
            checkArray(arr);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Sorry! Array not rotated.");
            return arr;
        }
        int h = arr.length;
        int w = arr[0].length;
        int l = arr[0][0].length;
        int rotatedCub[][][] = new int[h][w][l];
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                for(int k = 0; k < l; k++){
                    rotatedCub[j][k][i] = arr[i][j][k];
                }
            }
        }
        return rotatedCub;
    }

    private static void checkArray(int[][][] arr){
        if(arr == null)
            throw new IllegalArgumentException("Array is null");
        else if(arr.length != arr[0].length || arr.length != arr[0][0].length)
            throw new IllegalArgumentException("Array width not equal length");
        else if(arr.length == 0 || arr[0].length == 0 || arr[0][0].length == 0)
            throw new IllegalArgumentException("one of dimention is 0");

        for(int i = 0; i < arr.length; i++){
            if(arr[i].length == 0)
                throw new IllegalArgumentException("string " + i + " -> dimention is 0");
            if(arr[i] == null)
                throw new IllegalArgumentException("string " + i + " ->  is null");
            if(arr[i].length != arr.length)
                throw new IllegalArgumentException("string " + i + " -> wrong length");

            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j].length == 0)
                    throw new IllegalArgumentException("string " + i + " -> dimention is 0");
                if(arr[i][j] == null)
                    throw new IllegalArgumentException("string " + i + " ->  is null");
                if(arr[i][j].length != arr.length)
                    throw new IllegalArgumentException("string " + i + " -> wrong length");
            }
        }


    }
}

class TestRotate3D {
    public static void main(String[] args) {
        /*int[][][] arr = {{
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8},
        }};*/
        int[][][] arr = {
                {{10, 11, 12},
                        {20, 21, 22},
                        {30, 31, 32}},

                {{40, 41, 42},
                        {50, 51, 52},
                        {60, 61, 62}},

                {{70, 71, 72},
                        {80, 81, 82},
                        {90, 91, 92}}
        };
        int[][][] result = ArrayUtils.rotateClockwise(arr);
        System.out.println(Arrays.deepToString(result));
    }
}
