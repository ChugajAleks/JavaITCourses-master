package proc.loop.arraY_merger_fixed;

import java.util.Arrays;

public class Merger {

	// corrected....

    public static int[] merge(int[] fst, int[] snd) {
        
    	int[] result = new int[fst.length + snd.length];
        int fstIndex = 0;
        int sndIndex = 0;
        
        if (snd.length == 0) {
        	result = fst;
        }
        if (fst.length == 0) {
        	result = snd;
        }
        
        while ( fstIndex < fst.length && sndIndex < snd.length) {
        	
        	int pos = fstIndex + sndIndex;
        	
            if ( fst[fstIndex] < snd[sndIndex]) {
                result[pos] = fst[fstIndex++];
            } else {
                result[pos] = snd[sndIndex++];
            }
        }

        //После того как обнаружится, что один из массивов "исчерпан" копируйте данные из второго массива 
        // в результат не в цикле, а одним вызовом System.arraycopy(...).
        
    	/*
    	 * 
     	 *  That won't change the O(n) performance characteristics of your solution, though.
    	 */
        
        if (fst.length!=0) {
        	if (fstIndex==fst.length) {
        		
        		//System.out.println(fstIndex);
        		//System.out.println(sndIndex);
        		
        		// Object src,
        		// int srcPos,
        		// Object dest, 
        		// int destPos, 
        		// int length
        		// { 0 } , { 1 }  ---->  { 0, 1}
        		// 
        		System.arraycopy(snd, sndIndex, result, fstIndex+sndIndex, snd.length - sndIndex);
        		
        	}
        }
        if (snd.length!=0) {
        	if (sndIndex==snd.length) {
        		
        		// {0, 2, 7, 9, 123} -> {1, 3, 4, 5, 6};
        		System.arraycopy(fst, fstIndex, result, fstIndex+sndIndex, fst.length - fstIndex);
        		
        	}
        }

        //System.out.println(Arrays.toString(result));
        
        return result;
        
    }
    
}
