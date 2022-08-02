package Sorts;

import java.util.Random;

public class Sorts {
    public static void main(String[] args){
        int[] bubbleNumbers = getInts();

        int[] insertionNumbers = getInts();

//
        int[] mergeSortNumbers = getInts();

        int[] quickSortNumbers = getInts();

//
//        System.out.println("------------------------BUBBLESORT---------------------------");
//        sortTheBubbleSorts(bubbleNumbers);
//        System.out.println("--------------------------END-------------------------------");
//
//        System.out.println("\n------------------------INSERTIONSORT--------------------");
//        sortTheInsertionSort(insertionNumbers);
//        System.out.println("------------------------END-------------------------------");
//
//
//        System.out.println("\n------------------------MERGESORT--------------------");
//        sortTheMergeSort(mergeSortNumbers);
//        System.out.println("------------------------END-------------------------------");



        System.out.println("\n------------------------QUICKSORT--------------------");
        sortTheQuickSort(quickSortNumbers);
        System.out.println("------------------------END-------------------------------");

    }

    private static void sortTheQuickSort(int[] numbers) {
        System.out.println("Normal quick sort:");
        System.out.println("\nBefore:");
        printArray(numbers);

        long x = System.nanoTime();
        QuickSort.quickSort(numbers);
        long y = System.nanoTime();
        long z = (y - x) / 1000000;


        System.out.println("\nAfter:");
        printArray(numbers);
        System.out.println("Duration: " + z + "ms");
    }

    private static int[] getInts() {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }
        return numbers;
    }


    private static void sortTheInsertionSort(int[] numbers){
        System.out.println("Normal insertion sort:");
        System.out.println("\nBefore:");
        printArray(numbers);

        long x = System.nanoTime();
        InsertionSort.sort(numbers);
        long y = System.nanoTime();
        long z = (y - x) / 1000000;


        System.out.println("\nAfter:");
        printArray(numbers);
        System.out.println("Duration: " + z + "ms");


    }


    private static void sortTheMergeSort(int[] numbers){
        System.out.println("Normal merge sort:");
        System.out.println("\nBefore:");
        printArray(numbers);

        long x = System.nanoTime();
        MergeSort.mergeSort(numbers);
        long y = System.nanoTime();
        long z = (y - x) / 1000000;


        System.out.println("\nAfter:");
        printArray(numbers);
        System.out.println("Duration: " + z + "ms");


    }

    private static void sortTheBubbleSorts(int[] numbers) {
        System.out.println("Normal bubblesort:");
        System.out.println("\nBefore:");
        printArray(numbers);

        long x = System.nanoTime();
        BubbleSort.sort(numbers);
        long y = System.nanoTime();
        long z = (y - x) / 1000000;


        System.out.println("\nAfter:");
        printArray(numbers);
        System.out.println("Duration: " + z + "ms");


        System.out.println("\nOptimized bubblesort");
        System.out.println("\nBefore:");
        printArray(numbers);
        long startTime = System.nanoTime();
        BubbleSort.optimizedSort(numbers);
        long encTime = System.nanoTime();

        long duration = (encTime - startTime) / 1000000;

        System.out.println("\nAfter:");
        printArray(numbers);
        System.out.println("Duration: " + duration + "ms");
    }

    private static void printArray(int[] numbers){
        for (int number : numbers) {
            System.out.println(number);
        }
    }

}
