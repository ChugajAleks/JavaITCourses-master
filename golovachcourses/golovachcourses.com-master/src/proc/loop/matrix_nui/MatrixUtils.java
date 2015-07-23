package proc.loop.matrix_nui;

public class MatrixUtils {
	
	public static boolean checkMatrix(int[][] fst) {
    	int fsize = fst[0].length;
    	int tmp = fsize;
    	boolean flag = false;
    	for (int i = 0; i < fst.length; i++) {

    		fsize = fst[i].length;
    		if (tmp != fsize) {
    			flag = true;
    			break;
    		}

    	}

    	return flag;
	}
	
    public static int[][] mul(int[][] fst, int[][] snd) {

    	// null checking
    	if (fst == null || snd == null) {
    		throw new IllegalArgumentException("One of the args is NULL!");
    	}
    	
    	for (int i=0; i < fst.length; i++) {
    		if (fst[i] == null) {
    			throw new IllegalArgumentException("One of the args of fst array is null");
    		}
    	}

    	for (int i=0; i < snd.length; i++) {
    		if (snd[i] == null) {
    			throw new IllegalArgumentException("One of the args of snd array is null");
    		}
    	}
    	

    	// check the args to be correct matricies
    	if ( checkMatrix(fst) || checkMatrix(snd) ) {
    		throw new IllegalArgumentException("One of the args of fst/snd is not a double array!");
    	}
    
       
     
        // width check of fst, height check of snd.	
    	if (fst[0].length != snd.length) {
    		throw new IllegalArgumentException("Width of fst array !- height of snd array!");
    	}

    	int[][] result = new int[fst.length][snd[0].length];
    	
    	for (int i=0; i < fst.length; i++) {

    		for (int j=0; j < snd[0].length; j++) {
    			
    			//System.out.println("LNGTH = " + snd[0].length);
    			//System.out.println("fst.length = " + fst.length);
    			
    			
        		for (int k=0; k < fst[0].length; k++) {
        			
        			 //System.out.println("i = " + i + ", j = " + j);
        			 //System.out.println("k = " + k);
        			 //System.out.println("fst[" + i + "][" + k + "]= " + fst[i][k]);
        			 //System.out.println("snd[" + k + "][" + j + "]= " + snd[k][j]);

        			 if (fst[i] != null && snd[k] != null) {

        				 result[i][j] += fst[i][k] * snd[k][j];
        				 
        			 } else {
        				 
        				 if (fst[i] == null || snd[k] == null) {
        					 result[i][j] += 0;
        				 }
        				 
        			 }
        			 
        			// System.out.println(Arrays.deepToString(result));
        			 
        		}
        		
        	}

        }
  	
    	return result;
    }
    
}

/*
Произведение двух двумерных матриц матриц A и B размером NxM и MxK- это матрица С размером NxK,
где каждый элемент C[i][j] высчитывается по формуле:

C[i][j] = A[i][0]*B[0][j] + A[i][1]*B[1][j] + ... + A[i][N-1]*B[N-1][j]

Пример:


	
|1 2|   |3 4 5 6|   |21 4  7  10|
|7 8| * |9 0 1 2| = |93 28 43 58|
|3 4|               |45 12 19 26|

так как
1*3 + 2*9 = 21, 1*4 + 2*0 = 4, 1*5 + 2*1 = 7, 1*6 + 2*2 = 10
7*3 + 8*9 = 93, 7*4 + 8*0 = 28, 7*5 + 8*1 = 43, 7*6 + 8*2 = 58
3*3 + 4*9 = 45, 3*4 + 4*0 = 12, 3*5 + 4*1 = 19, 3*6 + 4*2 = 26
1. Если один из аргументов равен null - throw new IllegalArgumentException().
2. Если один из аргументов НЕ прямоугольная/квадратная матрица - throw new IllegalArgumentException().
3. Если ширина первой матрицы не равна высоте второй матрицы - throw new IllegalArgumentException().

Подсказка: вам необходим тройной вложенный цикл.

*/