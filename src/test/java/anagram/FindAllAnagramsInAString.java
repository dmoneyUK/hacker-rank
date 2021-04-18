package anagram;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAllAnagramsInAString {

    @ParameterizedTest
    @MethodSource("testInputs" )
    public void test(String s, String p, List<Integer> expected) {
        assertThat(findAllAnagramsInAString(s, p)).isEqualTo(expected);
    }

    private static Stream<Arguments> testInputs() {
        return Stream.of(
            Arguments.of("cbaebabacd", "abc", Lists.list(0, 6)),
            Arguments.of("abab", "ab", Lists.list(0, 1, 2)),
            Arguments.of("aa", "bb", Lists.list())
        );
    }

    public List<Integer> findAllAnagramsInAString(String s, String p) {

        Map<String, List<Integer>> stringIntegerMap = new HashMap<>();

        int pLength = p.length();
        char[] tmp = new char[pLength];
        for (int i = 0; i <= s.length() - pLength; i++) {
            s.getChars(i, i + pLength, tmp, 0);
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            stringIntegerMap.putIfAbsent(key, new ArrayList<>());
            stringIntegerMap.get(key).add(i);
        }

        char[] sortedPChars = p.toCharArray();
        Arrays.sort(sortedPChars);
        String sortedP = String.valueOf(sortedPChars);

        return stringIntegerMap.getOrDefault(sortedP, new ArrayList<>());
    }


}
