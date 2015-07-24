package proc.loop.matrix_mul;

import java.util.Arrays;

public class MatrixUtils {
    public static int[][] mul(int[][] a, int[][] b) {
        if(!checkArraysForMultiply(a, b))
        {
            throw new ArithmeticException("Multiplication cannot be applied to these arrays.");
        }

        int bHeight = b[0].length;
        int aHeight = a[0].length;

        int [][] c = new int[a.length][bHeight];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < bHeight; j++) {
                c[i][j] = 0;
                for (int k = 0; k < aHeight; k++) {
                    c[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }
        return c;
    }

    private static boolean checkArraysForMultiply(int[][] a, int[][] b){
        boolean result = true;

        if(!checkArray(a) || !checkArray(b) || a[0].length != b.length){
            result = false;
        }
        return result;
    }

    private static boolean checkArray(int[][] a){
        int rowLength = a[0].length;
        for (int i = 0; i < a.length; i++) {
            if(a[i].length != rowLength)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [][] a = {
                {2,1,4},
                {9,7,8}
        };

        int [][] b = {
                {7,1},
                {9,7},
                {5,4}
        };

        int [][] axb = {
                {43,25},
                {166,90}
        };


        System.out.println(testMatrixMul(a, b, axb));
    }

    private static boolean testMatrixMul(int[][] a, int[][] b, int[][] axb)
    {
        int[][] c = mul(a, b);
        return Arrays.deepToString(c).equals(Arrays.deepToString(axb));
    }
}
