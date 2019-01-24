package hacker.rank.problemsolving;

import org.junit.Test;

import java.util.Arrays;

public class ArrayAccumulator {
    @Test
    public void testArrayAccumulator() {
        int[][] arr = {{11, 2, 4}, {4, 5, 6}, {10, 8, -12}};

        int[] result = Arrays.stream(arr).collect(() -> new int[2], (a, b) -> {
            a[0] += b[0];
            a[1] += b[1];
        }, (a, b) -> {
            a[0] += b[0];
            a[1] += b[1];
        });

        int end = arr[0].length - 1;

        System.out.println(result);

    }
}
