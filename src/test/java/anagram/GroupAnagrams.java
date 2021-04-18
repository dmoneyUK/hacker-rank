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
import static org.assertj.core.util.Lists.list;

public class GroupAnagrams {

    @ParameterizedTest
    @MethodSource("testInputs" )
    public void test(String[] s, List<List<String>> expected) {
        assertThat(groupAnagrams(s)).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> testInputs() {
        return Stream.of(
            Arguments.of(new String[]{"eat","tea","tan","ate","nat","bat"}, Lists.list(list("bat"), list("nat","tan"), list("ate","eat","tea")))
        );
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList(map.values());
    }
}
