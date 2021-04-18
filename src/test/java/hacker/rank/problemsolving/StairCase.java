package hacker.rank.problemsolving;

import org.junit.jupiter.api.Test;

public class StairCase {

    @Test
    public void testStairCase() {
        int n = 6;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            for (int j = n - 1; j > i; j++) {
                sb.append(" ");
            }
            for (int k = 0; k < i; k++) {
                sb.append("#");
            }
            System.out.println(sb.toString());
        }
    }
}
