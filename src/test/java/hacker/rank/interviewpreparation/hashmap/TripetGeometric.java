package hacker.rank.interviewpreparation.hashmap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripetGeometric {

    @Test
    public void testTripetGeometric() {
        //List<Long> arr = Arrays.asList(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
        List<Long> arr = Arrays.asList(1L, 3l, 9l, 9l, 27L, 81L);
        int r = 3;

        Map<Long, Long> t2 = new HashMap<>();
        Map<Long, Long> t3 = new HashMap<>();
        Long result = arr.stream().map(a -> {
            long count = t3.getOrDefault(a, 0l);
            if (t2.containsKey(a)) {
                t3.merge(a * r, t2.get(a), (x, y) -> x + y);
            }
            t2.merge(a * r, 1L, (x, y) -> x + y);
            return count;
        }).reduce(0L, Long::sum);

        System.out.println(result);

    }
}
