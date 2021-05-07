
package com.mergeSort;

public class Main {

    public static void main(String[] args) {

        int[] array = {30, 22, 11, 9, 51, 3,17 };

        System.out.println("Given Array");
        printArray(array);

        MergeSort.mergeSort(array);

        System.out.println("\nSorted array");
        printArray(array);
    }


    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}