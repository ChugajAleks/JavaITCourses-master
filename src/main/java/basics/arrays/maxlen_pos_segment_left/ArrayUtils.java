package basics.arrays.maxlen_pos_segment_left;


import java.util.Arrays;

public class ArrayUtils {

    public static int[] lookFor(int[] array) {

        System.out.println("income array : "  + Arrays.toString(array));

        // if array == null or length == 0
        if (array == null || array.length==0) {
            throw new IllegalArgumentException("Array length = 0");
        }

        // checking if all the array items <=0
        boolean chkArr = false;
        for (int i=0; i<array.length; i++) {
            if (array[i]>0)
                chkArr = true;
        }
        if (!chkArr) return new int[] {};

        // check if array contain only 1 item
        if (array.length==1 && array[0]>0)
            return new int[] {0,0};

        int[][] doubleArr = new int[array.length][2];   // will store all positive segments in double array
        boolean isFound = false;                        // we will set this flag = true when we find fstPos
        int fstPos = 0;                                 // position of the first positive num in array inside a segment
        int index = 0;                                  // index of array
        int i = 0;                                      // index of double array

        // main loop
        do {
            if (!isFound && array[index]>0) {
                isFound = true;
                fstPos = index;
            }
            else if (isFound && array[index]>0) {
                if (index==array.length-1) {
                    doubleArr[i++] = new int[] {fstPos, index};
                }
            } else if (isFound && array[index]<=0) {
                    doubleArr[i++] = new int[] {fstPos, index-1};
                    isFound = false;
            }
            index++;
        } while (index <= (array.length - 1));


        System.out.println("doubleArr = "  + Arrays.deepToString(doubleArr));


        // find the biggest segment from left to right
        int indexOfSegment = 0;
        int segmLength = 0;
        if (doubleArr[0].length>1)
        for (int k=0; k< doubleArr[0].length; k++) {
            int xa = doubleArr[k][0];
            int xb = doubleArr[k][1];
            if ( (xb-xa) > segmLength) {
                segmLength = xb - xa;
                indexOfSegment = k;
            }
        }

        //System.out.println("the result details: " + Arrays.toString(doubleArr[indexOfSegment]));

        return new int[] {doubleArr[indexOfSegment][0], doubleArr[indexOfSegment][1]};


    }

}
