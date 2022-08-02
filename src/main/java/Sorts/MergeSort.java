package Sorts;

public class MergeSort {
    public static void mergeSort(int[] array){
        int inputLength = array.length;


        // if the split arrays are less than 2, that means that the array only has a size of one, and don't need to be split up again

        if(inputLength < 2){
            return;
        }


        // We calculate half of the array, so if the starting size is 10, then it splits into an array of 5, and another array of 5. Since this is recursive until the input length is < 2, this wil then again happen with the array with size 5
        int midIndex = inputLength / 2;

        int[] leftHalf = new int[midIndex];
        // The left half indicates the "smaller" of the numbers, so recursively, the left half will  be the smallest array of size one

        // Although you could say that the right half would also be midIndex, this only works with even numbers, so if the array was of size 9, 9 / 2 would be 4 on left half, and the right half would be the whole array (9) - midindex (4), making the right half of size 5.
        int[] rightHalf = new int[inputLength - midIndex];

        // Here we go through the left half of the array, and fill it with all the numbers, starting from index 0
        for(int i = 0; i < midIndex; i++){
            leftHalf[i] = array[i];
        }

        // Here we go through the right half of the array, but we fill it with the "remaining" ints in the array
        for (int i = midIndex; i < inputLength; i++){
            rightHalf[i - midIndex] = array[i];
        }


        // Then we do it all again until they've all been split up to each of their own array
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // this also happens everytime the first array gets split, the same number of times
        merge(array, leftHalf, rightHalf);

    }

    private static void merge(int[] numbers, int[] leftHalf, int[] rightHalf){
        // Here we just do like in the mergeSort function and get the size of the left half, and the size of the right half, the first time around this will be 1
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        // We create three pointers, one to go through the left half (i), one for the right half (j) and then last pointer to go through the merged array (k)
        int i = 0, j = 0, k = 0;

        // So here we take the first number from the left side and compare it to the first number of the right half (the first time around at least)
        while (i < leftSize && j < rightSize){
            // if the left sides number is less than the right side (or the same)
            //the number on the left gets placed ihn the array, and the increment increases to the next number in the left half
            if(leftHalf[i] <= rightHalf[j]){
                numbers[k] = leftHalf[i];
                i++;
            } else {
                // If the right sides number is less than the left, the right side number gets placed in the merged array, and the right side increments
                numbers[k] = rightHalf[j];
                j++;
            }
            // Either way the merged array increments for each time this happens
            k++;
        }
        //After the comparison we just get the remaining numbers that haven't been placed in the merged array and place them accordingly
        while (i < leftSize){
            numbers[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize){
            numbers[k] = rightHalf[j];
            j++;
            k++;
        }

    }
}
