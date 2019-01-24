package hacker.rank.interviewpreparation.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RotLeft {
    @Test
    public void testRotLeft() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int d = 3;

        int[] temp = IntStream.range(0, d).map(i -> a[i]).toArray();
        for (int i = d; i < a.length; i++) {
            a[i - d] = a[i];
        }
        for (int i = 0; i < d; i++) {
            a[a.length - d + i] = temp[i];
        }

        Arrays.stream(a).forEach(System.out::println);
    }

}
