package hacker.rank.interviewpreparation.sorting;

import org.junit.Test;

public class MergeSort {

    @Test
    public void testMergeSort() {

        int[] arr = {8, 4, 2, 3, 9, 6, 7, 5, 1};

        sort(arr, 0, arr.length - 1);

    }

    void sort(int[] arr, int begin, int end) {

        if (begin < end) {
            int mid = (begin + end) / 2;
            sort(arr, begin, mid);
            sort(arr, mid + 1, end);

            merge(arr, begin, mid, end);

        }

    }

    void merge(int[] arr, int begin, int mid, int end) {
        int n1 = mid - begin + 1;
        int n2 = end - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[begin + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = begin;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
