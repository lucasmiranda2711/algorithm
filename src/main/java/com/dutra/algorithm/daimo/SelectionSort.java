package com.dutra.algorithm.daimo;

public class SelectionSort {



    public int[] sort(int[] array){

        int size = array.length;

        for (int i = 0; i < size - 1; i++) {
            int minValue = i;

            for (int k = i + 1; k < size; k++) {

                if (array[k] < array[minValue]) {
                    minValue = k;
                }
            }
            int temp = array[i];
            array[i] = array[minValue];
            array[minValue] = temp;
        }


        return array;
    }
}
