package proc.recursion.permuation;

/**
 * Created by pafnat on 22/04/14.
 */

import java.util.Arrays;

public class Permutation_q {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        permutation(arr, 0);
    }
    private static void permutation(int[] arr, int i) {
        if (i == arr.length -1) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int k = i; k < arr.length; k++) {

                    swap(arr, i, k);

                    permutation(arr, i+1);

                    swap(arr, i, k);

            }
        }
    }
    private static void swap(int[] arr, int index0, int index1) {
            int tmp = arr[index0];
            arr[index0] = arr[index1];
            arr[index1] = tmp;
    }
}


// http://www.sql.ru/forum/actualutils.aspx?action=gotomsg&tid=464610&msg=4550030

/*
1 2 3

-> k=0
3 2 1
permutation(arr, 2);
        k=0
        2 3 1
        permuatation(arr, 1);
        out (2 3 1)
        k=1<2? yes
        3 2 1




 */



/*

1, 2, 3

1 2 3
1 3 2

2 1 3
2 3 1


3 1 2
3 2 1



====

3 2 1


 */