package hacker.rank.problemsolving;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class CompareTriplets {
    @Test
    public void testCompareTriplets() {
        int[] input = {1, 2, 3, 4, 5};

        Averager averager = Arrays.stream(input).collect(Averager::new, Averager::accept,
                                                         Averager::combine);
        System.out.println(averager.average());
    }

    class Averager implements IntConsumer {
        private int count;
        private int total;

        public int average() {
            return count > 0 ? total / count : 0;
        }

        @Override
        public void accept(int value) {
            count++;
            total += value;
        }

        public void combine(Averager other) {
            total += other.total;
            count += other.count;
        }
    }
}
