package hacker.rank.interviewpreparation.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HourglassSum {
    @Test
    public void testHourglassSum() {
        int[][] arr = {{1, 1, 1, 0, 0, 0},
                       {0, 1, 0, 0, 0, 0},
                       {1, 1, 1, 0, 0, 0},
                       {0, 0, 2, 4, 4, 0},
                       {0, 0, 0, 2, 0, 0},
                       {0, 0, 1, 2, 4, 0}};
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sums.add(arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                                 + arr[i + 1][j + 1]
                                 + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);
            }
        }
        int mx = sums.stream().max((a, b) -> {
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                return 0;
            }
        }).get();

        System.out.println(mx);

    }
}
