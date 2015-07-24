package proc.loop.matrix_mul;

import java.util.Arrays;

public class MatrixUtils_My {
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

        int[][] arrMul = mul(a, b);
        System.out.println("Matrix A => " + Arrays.deepToString(a));
        System.out.println("x");
        System.out.println("Matrix B => " + Arrays.deepToString(b));
        System.out.println("Result => " + Arrays.deepToString(arrMul));

        System.out.println(testMatrixMul(a, b, axb));
    }

    private static boolean testMatrixMul(int[][] a, int[][] b, int[][] axb)
    {
        int[][] c = mul(a, b);
        return Arrays.deepToString(c).equals(Arrays.deepToString(axb));
    }

    private static int[][] mul (int[][] a, int[][] b){
        if(a.length != b[0].length){
            System.out.println("Width not equal heigth");
            return null;
        }
        int[][] c = new int[a.length][b[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b[0].length; j++){
                c[i][j] = arrElementMul(a, b, i, j);
            }
        }
        return c;
    }


    private static int arrElementMul(int[][] a, int[][] b, int i, int j){
        int result = 0;
        for(int k = 0; k < a[0].length; k++){
            result = result + a[i][k] * b[k][j];
        }
        return result;
    }
}

