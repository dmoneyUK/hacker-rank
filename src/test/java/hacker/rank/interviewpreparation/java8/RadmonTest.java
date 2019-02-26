package hacker.rank.interviewpreparation.java8;

import org.junit.Test;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RadmonTest {

    @Test
    public void testRandomOfNonPowerOfTwo() {

        Random rd = new Random();

        IntStream.range(0, 1000000).map(i -> rd.nextInt() % 7).boxed()
                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


}
