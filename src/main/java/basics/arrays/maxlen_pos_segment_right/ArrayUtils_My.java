package basics.arrays.maxlen_pos_segment_right;
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
import java.util.Arrays;

public class ArrayUtils_My {

    public static int[] lookFor(int[] array) {
      if(array == null || array.length == 0)
        throw new IllegalArgumentException();
      boolean newDiapazon = false;
      int startDiapazon = 0;
      int stopDiapazon = 0;
      int[] result = {0, 0};
      boolean posElementPresent = false;
      
      for(int i = 0; i < array.length; i++){
        if(array[i] > 0 && !newDiapazon){
          newDiapazon = true;
          startDiapazon = i;
          posElementPresent = true;
        }
        else if((array[i] <= 0 || i >= array.length -1) && newDiapazon){
          newDiapazon = false;
          stopDiapazon = (array[i] > 0 && i >= array.length -1) ? i : i-1;        
          if((stopDiapazon - startDiapazon) >= (result[1] - result[0])){
            result[0] = startDiapazon;
            result[1] = stopDiapazon;
            System.out.println("intermediat result " + Arrays.toString(result));
          } 
        }
       
      }
      if(!posElementPresent)
        result = new int[0];
		return result;
    }
}
