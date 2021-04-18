package hacker.rank.interviewpreparation.array;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class MiniSwapSorting {

    @Test
    public void testMiniSwapSorting() {
        int swap = 0;
        int[] arr = {2, 3, 4, 1, 5};
        for (int i = 0; i < arr.length; i++) {
            swap += check(arr, i);
        }
        System.out.println(swap);
    }

    private int check(int[] arr, int index) {
        int s = 0;
        if (arr[index] != index + 1) {
            s = 1;
            swap(arr, index, arr[index] - 1);
            int t = check(arr, index);
            s += t;
        }
        return s;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
