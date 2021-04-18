package hacker.rank.interviewpreparation.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSort {

    @Test
    public void test() {

        int[] array = {2, 6, 5, 1, 4, 3};

        bubbleSort(array);

        Arrays.stream(array).forEach(System.out::print);
    }

    private void bubbleSort(int[] array) {

        for (int i = 1; i < array.length; i++) { // Traverse from the 2nd element forward
            int key = array[i]; // take the current element array[i]
            int j = i - 1; // find the last sorted element i-1

            while (j >= 0 && array[j] > key) { // Traverse the sorted elements from i-1 backward to find the first smaller element (j)
                swap(array, j + 1, j); // move the elements forward one position
                j--; // Keep moving backward
            }

            array[j + 1] = key; // Added the current
        }

    }

    private void swap(int[] array, int i, int j) {

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
