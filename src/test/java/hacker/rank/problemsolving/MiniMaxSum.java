package hacker.rank.problemsolving;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MiniMaxSum {
    @Test
    public void testMiniMaxSum() {
        int[] arr = {256741038, 623958417, 467905213, 714532089, 938071625};
        long[] temp = Arrays.stream(arr).collect(() -> new long[]{0, 0, 0}, (ar, i) -> {
            ar[0] += i;
            if (i < ar[1]) {
                ar[1] = i;
            } else if (i > ar[2]) {
                ar[2] = i;
            }
        }, (a, b) -> {
            a[0] += b[0];
            if (b[1] < a[1]) {
                a[1] = b[1];
            }
            if (b[2] > a[2]) {
                a[2] = b[2];
            }
        });
        System.out.println(String.valueOf(temp[0] - temp[1]) + " " + String.valueOf(temp[0] - temp[2]));
    }
}
