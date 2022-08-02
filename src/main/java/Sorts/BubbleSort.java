package Sorts;


import java.util.Random;

public class BubbleSort {
    public static void sort(int[] array) {
        boolean swapped = true;
        while (swapped){

            swapped = false;

            for(int i = 0; i < array.length - 1; i++){
                int j = i + 1;
                if(array[i] > array[j]){
                    swapped = true;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    public static void optimizedSort(int[] array){
        boolean swapped = true;

        while (swapped){
            swapped = false;
            int index = array.length - 1;
            for(int i = 0; i < array.length - 1; i++){
                int j = i + 1;
                if(array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                    swapped = true;
                    index--;
                }
            }
        }
    }
}
