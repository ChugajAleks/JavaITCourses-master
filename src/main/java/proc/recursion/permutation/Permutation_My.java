package proc.recursion.permutation;

import java.util.Arrays;

public class Permutation_My {
  public static int countPermutation;
  public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        permutation(arr, arr.length);
    System.out.println("countPermutation = " + countPermutation);
  }
  
  private static void permutation(int[] arr, int size){
    if (size < 2){
      System.out.println(Arrays.toString(arr));
      countPermutation++;
    }
    else{
      for(int i = 0; i < size; i++){
        swap(arr, i, size - 1);
        permutation(arr, size -1);
        swap(arr, i, size - 1);
      }
    }
  }
  
  private static void swap(int[] arr, int indexSwap, int indexLast){
    int tmp = arr[indexSwap];
    arr[indexSwap] = arr[indexLast];
    arr[indexLast] = tmp;
  }
}
