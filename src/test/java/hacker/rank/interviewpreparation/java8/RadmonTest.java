package hacker.rank.interviewpreparation.java8;

import org.junit.Test;

import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RadmonTest {

    @Test
    public void testRandomOfNonPowerOfTwo() {

        Random rd = new Random();

        Map<Integer, Long> result =IntStream.range(0, 10000000).map(i -> Math.abs(rd.nextInt()) % 7).boxed()
                                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
    }





}
