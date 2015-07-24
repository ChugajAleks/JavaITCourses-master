package basics.arrays.maxarea_pos_rect;

import java.util.Arrays;

/**
 * В заданной двухмерной матрице (возможно не прямоугольной, возможно содержащей null или массивы длины 0 вместо строк)
 * найти прямоугольный участок максимальной площади содержащий только элементы больше нуля. И вернуть площадь этого участка.
 * Если вместо массива null или массив длины 0 - выбрасывать IllegalArgumentException.
 * Если нет такого прямоугольника (пример: все элементы не больше нуля, все строки null) - возвращать -1.
 * ---
 * {{1, 1}, {1, 1}} - возвращать 4
 * {{0, 1}, {1, 1}} - возвращать 2
 * {{1, 1, 1}, {1, 1, 1}, {1, 1, 0}} - возвращать 6
 * {{0, 1, 1}, {1, 1, 1}, {1, 1, 0}} - возвращать 4
 * ---
 * null или new int[0][] - IllegalArgumentException
 * new int[][] {null, null, null} - возвращать -1
 * new int[][] {{}, {}, {}} - возвращать -1
 * new int[][] {{0, 0, 0}, {-1, -1}, {-2}} - возвращать -1
 *
 * http://n00tc0d3r.blogspot.ru/2013/04/maximum-rectangle.html
 *
 */

public class ArrayUtils_My {
  public static long maxArea(int[][] array) {
 	 
    int h = array.length;
    int w = array[0].length;
    int[][] arr = new int[h][w];
    //in first string round value to 1 or 0
    for(int i = 0; i < w; i++)
      arr[0][i] = (array[0][i] > 0) ? 1 : 0;
    //counting sequence positive numbers in colums
    for(int i = 1; i < h; i++){
      for(int j = 0; j < w; j++){
        arr[i][j] = (array[i][j] > 0) ? arr[i - 1][j] + 1 : 0;
      }
    }
    System.out.println("h = "+h+" w = "+w );
    System.out.println(Arrays.deepToString(array));
    System.out.println(Arrays.deepToString(arr));
    //calculate max positive rectangle area
    
    long maxArea = 0;
    for(int i = h -1; i > 0; i--){
      for(int j = 0; j < w; j++){
        int higthArea = 0;
        int widthArea = 0;
        if(arr[i][j] > 0){
          higthArea = arr[i][j];
          for(int k = j; k < w; k++){
            if(arr[i][k] < higthArea){
              break;
            }
            widthArea++;
          }
          int tmpMaxArea = widthArea * higthArea;
          maxArea = (tmpMaxArea > maxArea) ? tmpMaxArea : maxArea;
        }
      }
    }
    return maxArea;
  }
}
