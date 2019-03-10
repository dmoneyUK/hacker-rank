package hacker.rank.interviewpreparation.StringManipulating;

import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Palindrome {

    @Test
    public void should_find_all_single_characters() {
        String s = "abc";
        assertThat(substrCount(s.length(), s)).isEqualTo(3);
    }

    @Test
    public void should_find_all_from_one_repeated_character() {
        String s = "aaaa";
        assertThat(substrCount(s.length(), s)).isEqualTo(10);
    }

    @Test
    public void should_find_all_from_two_repeated_characters() {
        String s = "aaabbb";
        assertThat(substrCount(s.length(), s)).isEqualTo(12);
    }

    @Test
    public void should_find_all_from_middle_break() {
        String s = "aba";
        substrCount(s.length(), s);
        assertThat(substrCount(s.length(), s)).isEqualTo(4);
    }

    @Test
    public void testSample1() {
        String s = "asasd";
        substrCount(s.length(), s);
        assertThat(substrCount(s.length(), s)).isEqualTo(7);
    }

    @Test
    public void testSample2() {
        String s = "abcbaba";
        substrCount(s.length(), s);
        assertThat(substrCount(s.length(), s)).isEqualTo(10);
    }

    @Test
    public void should_find_all_from_repeated_one_character_and_middle_break() {
        String s = "aaabaa";
        assertThat(substrCount(s.length(), s)).isEqualTo(12);

    }

    // My solution
    //private long substrCount(int length, String s) {
    //    int result = 0;
    //    char[] chars = s.toCharArray();
    //    for (int i = 0, j = 1; i < length; i++, j = i + 1) {
    //
    //        int count = 1;    // how many time the chars[i] appears continously
    //        for (; j < length; j++) { // traverse the remaining using index j
    //            if (chars[i] == chars[j]) {
    //                count++; // add 1 if the chars[j] equals to chars[i]
    //            } else if (j + count < length) {
    //                // if the chars[j] is diff, check if there is element on the j+count
    //                boolean isSameChar = true;
    //                int end = j + count;
    //                while (++j <= end && isSameChar) {
    //                    // check if the elements from j to j+count all equals to chars[i]
    //                    isSameChar &= (chars[j] == chars[i]);
    //
    //                }
    //
    //                if (isSameChar) {
    //                    count++; //if the elements from j to j+count all equals to chars[i], add 1 to count
    //                }
    //
    //                break;
    //            } else {
    //                break;
    //            }
    //        }
    //        result += count;
    //
    //    }

    private long substrCount(int n, String s) {

        int result = 0;
        List<Pair<Character, Integer>> counts = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            counts.add(new Pair<>(s.charAt(i), j - i));
            i = j - 1;
        }

        for (int i = 0; i < counts.size(); i++) {
            Pair<Character, Integer> currentPair = counts.get(i);
            Integer currentValue = currentPair.getValue();
            result += (currentValue + 1) * currentValue / 2;
            if (i + 2 < counts.size()
                    && counts.get(i + 1).getValue() == 1
                    && counts.get(i + 2).getKey() == currentPair.getKey()) {
                int min = Math.min(currentPair.getValue(), counts.get(i + 2).getValue());
                result += min;
            }
        }

        return result;
    }
}
