package hacker.rank.problemsolving;

import org.junit.Test;

import java.util.Arrays;

public class SockMerchant {
    @Test
    public void testSockMerchant() {
        int[] arr = {1, 2, 1, 2, 3, 4, 1, 3, 4, 2};
        int[] counts = new int[101];
        Arrays.stream(arr).forEach(
                i -> counts[i]++
        );
        int paris = Arrays.stream(counts).reduce((a, b) -> a + b / 2).getAsInt();
        System.out.println(paris);
    }
}
