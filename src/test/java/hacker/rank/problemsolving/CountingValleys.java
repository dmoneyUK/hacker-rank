package hacker.rank.problemsolving;

import org.junit.jupiter.api.Test;

public class CountingValleys {
    @Test
    public void testCountingValleys() {
        String s = "UDDDUDUU";
        int[] pos = new int[2];

        for (char c : s.toCharArray()) {
            int step = 0;
            if (c == 'U') {
                step = 1;
            } else if (c == 'D') {
                step = -1;
            }
            pos[1] += step;
            if (step == 1 && pos[1] == 0) {
                pos[0]++;
            }
        }

        System.out.println(pos[0]);
    }
}
