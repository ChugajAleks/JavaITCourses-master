package basics.array.rotate_2D;

import java.util.Arrays;

/**
 * Реализуйте метод rotateClockwise(int[][]) класса ArrayUtils, который
 * 1) проверяет, что метод получил "квадратную" матрицу (допустимые размеры 1x1, 2x2, 3x3, ...) иначе выбрасывает исключение
 * throw new IllegalArgumentException();
 * (возможные ошибки: null вместо массива, одна из размерностей = 0, длина не равна ширине, есть строки разной длины, 
 * есть строки с null вместо одномерных массивов)
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

public class ArrayUtils_My {
    public static int[][] rotateClockwise(int[][] arr) {
        try{
            checkArray(arr);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Sorry! Array not rotated.");
            return arr;
        }
        int[][] rotatedArray = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j< arr.length; j++){
                rotatedArray[i][j] = arr[arr.length - j -1][i];
            }
        }
        return rotatedArray;
    }

    private static void checkArray(int[][] arr){
        if(arr == null)
            throw new IllegalArgumentException("Array is null");
        else if(arr.length != arr[0].length)
            throw new IllegalArgumentException("Array width not equal length");
        else if(arr.length == 0 || arr[0].length == 0)
            throw new IllegalArgumentException("one of dimention is 0");

        for(int i = 0; i < arr.length; i++){
            if(arr[i].length == 0)
                throw new IllegalArgumentException("string " + i + " -> dimention is 0");
            if(arr[i] == null)
                throw new IllegalArgumentException("string " + i + " ->  is null");
            if(arr[i].length != arr.length)
                throw new IllegalArgumentException("string " + i + " -> wrong length");
        }


    }
}



class RotateTest_My {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(Arrays.deepToString(ArrayUtils_My.rotateClockwise(arr)));
    }
}