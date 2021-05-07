package com.mergeSort;

public class MergeSort {

    public static void mergeSort( int[] array ) {
        if ( array.length > 1 ) {
            // split array into two halves
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    public static int[] leftHalf( int[] array ) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        System.arraycopy(array, 0, left, 0, size1);
        return left;
    }

    public static int[] rightHalf( int[] array ) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        if (size2 >= 0) System.arraycopy(array, size1, right, 0, size2);
        return right;
    }


    public static void merge( int[] result,
                              int[] left, int[] right ) {
        int i1 = 0;
        int i2 = 0;

        for ( int i = 0; i < result.length; i++ ) {
            if ( i2 >= right.length || (i1 < left.length &&
                    left[i1] <= right[i2]) ) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }

    static void printArray(int[] arr) {
        int i = arr.length;
         System.out.print(i + " ");
        System.out.println();
    }
}
