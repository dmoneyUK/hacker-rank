package hacker.rank.interviewpreparation.StringManipulating;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestCommonSequence {

    int step = 0;
    int[][] mem = new int[10][10];

    @Test
    public void should_find_1() {
        String s1 = "ABC";
        String s2 = "BDE";

        assertThat(lcs(s1, s2, 0, 0)).isEqualTo(1);
    }

    @Test
    public void test_should_return_string_length_if_they_are_same() {
        String s1 = "HARRY";
        String s2 = "HARRY";

        assertThat(lcs(s1, s2, 0, 0)).isEqualTo(5);
    }

    @Test
    public void should_return_2_when_compare_HARRY_SALLY() {
        String s1 = "HARRY";
        String s2 = "SALLY";

        assertThat(recursiveLCS(s1, s2)).isEqualTo(2);
        assertThat(dynamicLCS(s1, s2)).isEqualTo(2);
    }

    @Test
    public void should_return_0_when_compare_AA_BB() {
        String s1 = "AA";
        String s2 = "BB";

        assertThat(lcs(s1, s2, 0, 0)).isEqualTo(0);
    }

    @Test
    public void should_return_3_when_compare_SHINCHAN_NOHARAAA() {
        String s1 = "SHINCHAN";
        String s2 = "NOHARAAA";

        assertThat(recursiveLCS(s1, s2)).isEqualTo(3);
        assertThat(dynamicLCS(s1, s2)).isEqualTo(3);
    }

    private int recursiveLCS(String s1, String s2) {
        step = 0;
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        int max = lcs(s1, s2, 0, 0);

        System.out.println("Recursive Programming:" + step);

        return max;
    }

    private int lcs(String s1, String s2, int i, int j) {
        if (mem[i][j] == -1) {
            step++;
            if (i >= s1.length() || j >= s1.length()) {
                mem[i][j] = 0;
            } else if (s1.charAt(i) == s2.charAt(j)) {
                mem[i][j] = 1 + lcs(s1, s2, i + 1, j + 1);
            } else {
                mem[i][j] = Math.max(lcs(s1, s2, i + 1, j), lcs(s1, s2, i, j + 1));
            }
        }
        return mem[i][j];
    }

    private int dynamicLCS(String s1, String s2) {
        step = 0;
        int max = 0;

        Arrays.fill(mem[0], 0);
        for (int i = 1; i < mem[0].length; i++) {
            Arrays.fill(mem[i], -1);
            mem[i][0] = 0;

        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                step++;
                if (i == 0 || j == 0) {
                    mem[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    mem[i][j] = 1 + mem[i - 1][j - 1];
                    max = max > mem[i][j] ? max : mem[i][j];
                } else {
                    mem[i][j] = Math.max(mem[i][j - 1], mem[i - 1][j]);
                }
            }
        }
        System.out.println("Dynamic Programming:" + step);
        return max;
    }

}
