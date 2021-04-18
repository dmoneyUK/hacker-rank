package hacker.rank.problemsolving;

import org.junit.jupiter.api.Test;

public class JumpingOnCloud {

    @Test
    public void testJumpingOnCloud() {
        int[] c = {0, 0, 0, 0, 1, 0};
        int count = 0;
        int i = 0;
        while (i < c.length - 1) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i += 2;
            } else {
                i++;
            }
            count++;
        }
        System.out.println(count);
    }
}
