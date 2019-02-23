package hacker.rank.interviewpreparation.StringManipulating;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.lang.Math.abs;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

public class MakeAnagram {

    @Test
    public void should_return_0_when_no_need_delete() {
        String a = "abc";
        String b = "bca";

        assertThat(makeAnagram(a, b)).isEqualTo(0);
    }

    @Test
    public void should_return_1_when_need_to_delete_1_additional_from_a() {
        String a = "abcd";
        String b = "bca";

        assertThat(makeAnagram(a, b)).isEqualTo(1);
    }

    @Test
    public void should_return_1_when_need_to_delete_1_repeated_from_a() {
        String a = "aabc";
        String b = "bca";

        assertThat(makeAnagram(a, b)).isEqualTo(1);
    }

    @Test
    public void should_return_1_when_need_to_delete_1_additional_from_b() {
        String a = "abc";
        String b = "bcae";

        assertThat(makeAnagram(a, b)).isEqualTo(1);
    }

    @Test
    public void should_return_1_when_need_to_delete_1_repeated_from_b() {
        String a = "abc";
        String b = "bcaa";

        assertThat(makeAnagram(a, b)).isEqualTo(1);
    }

    @Test
    public void should_return_4_when_need_to_delete_4_diffs_from_a_and_b() {
        String a = "abc";
        String b = "cde";

        assertThat(makeAnagram(a, b)).isEqualTo(4);
    }

    private int makeAnagram(String a, String b) {
        return makeAnagramWithArrays(a, b);
    }

    private int makeAnagramWithMaps(String a, String b) {
        Map<Integer, Long> map_A = a.chars().boxed().collect(groupingBy(identity(), TreeMap::new, counting()));
        Map<Integer, Long> map_B = b.chars().boxed().collect(groupingBy(identity(), TreeMap::new, counting()));

        int total = 0;
        Iterator<Entry<Integer, Long>> it_outter = map_A.entrySet().iterator();
        Iterator<Entry<Integer, Long>> it_inner = map_B.entrySet().iterator();

        Entry<Integer, Long> nextOutter = it_outter.next();
        Entry<Integer, Long> nextInner = it_inner.next();

        while (!isExhausted(it_outter)) {

            if (nextOutter.getKey() == nextInner.getKey()) {
                total += abs(nextOutter.getValue() - nextInner.getValue());
                if (isExhausted(it_inner) || isExhausted(it_outter)) {
                    break;
                }
                nextOutter = it_outter.next();
                nextInner = it_inner.next();

            } else if (nextOutter.getKey() < nextInner.getKey()) {
                total += nextOutter.getValue();
                nextOutter = it_outter.next();
            } else {
                total += nextInner.getValue();
                nextOutter = it_inner.next();
            }
        }

        total += getRemainingSum(it_outter);
        total += getRemainingSum(it_inner);

        return total;
    }

    private int makeAnagramWithArrays(String a, String b) {

        Supplier<Integer[]> supplier = () -> {
            Integer[] result = new Integer[26];
            Arrays.fill(result, 1);
            return result;
        };

        BiConsumer<Integer[], Integer> accumulator = (x, y) -> {
            x[y - 'a']++;
        };

        BiConsumer<Integer[], Integer[]> combiner = (x, y) -> {
            for (int i = 0; i < x.length; i++) {
                x[i] += y[i];
            }
        };

        Integer[] aChars = a.chars().boxed().collect(supplier, accumulator, combiner);

        Integer[] bChars = b.chars().boxed().collect(supplier, accumulator, combiner);

        return IntStream.range(0, 26).map(i -> abs(aChars[i] - bChars[i])).sum();
    }

    private boolean isExhausted(Iterator<Entry<Integer, Long>> iterator) {
        return !iterator.hasNext();
    }

    private int getRemainingSum(Iterator<Entry<Integer, Long>> iterator) {
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next().getValue();
        }
        return sum;
    }
}
