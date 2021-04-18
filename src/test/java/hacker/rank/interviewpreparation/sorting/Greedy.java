package hacker.rank.interviewpreparation.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Greedy {

    @Test
    public void testGreedy() {
        int[] arr = {1, 12, 5, 111, 200, 1000, 10};
        int total = 50;

        new MergeSort().mergeSort(arr);

        assertThat(arr).isEqualTo(new int[]{1, 5, 10, 12, 111, 200, 1000});

        int sum = 0;
        int i = 0;

        while (sum <= total){
            sum += arr[i++];
        }

        assertThat(i).isEqualTo(5);
    }
    

}
