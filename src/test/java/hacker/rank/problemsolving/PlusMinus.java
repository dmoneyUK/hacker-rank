package hacker.rank.problemsolving;

import org.junit.Test;

import java.util.Arrays;

public class PlusMinus {
    @Test
    public void testPlusMinus() {
        int[] arr = {-4, 3, -9, 0, 4, 1};

        int[] counts = Arrays.stream(arr).collect(() -> new int[]{0, 0, 0}, (a, i) -> {
            if (i > 0) {
                a[0]++;
            } else if (i < 0) {
                a[1]++;
            } else {
                a[2]++;
            }
        }, (a, b) -> {
            a[0] += b[0];
            a[1] += b[1];
            a[2] += b[2];
        });
        float[] result = {(float) counts[0] / arr.length, (float) counts[1] / arr.length, (float) counts[2] / arr.length};
        System.out.println(result[0]);
    }
}
