package hacker.rank.interviewpreparation.StringManipulating;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class sherlockValidString {

    public static final String YES = "YES";
    public static final String NO = "NO";

    @Test
    public void should_return_yes_when_input_abc() {
        String s = "abc";
        Assertions.assertThat(sherlockValidate(s)).isEqualTo(YES);
    }

    @Test
    public void should_return_yes_when_input_abcc() {
        String s = "abcc";
        Assertions.assertThat(sherlockValidate(s)).isEqualTo(YES);
    }

    @Test
    public void should_return_no_when_input_abbcc() {
        String s = "abbcc";
        Assertions.assertThat(sherlockValidate(s)).isEqualTo(NO);
    }

    @Test
    public void should_return_no_when_input_aabbcd() {
        String s = "aabbcd";
        Assertions.assertThat(sherlockValidate(s)).isEqualTo(NO);
    }

    @Test
    public void should_return_no_when_input_vvcc() {
        String s = "vvcc";
        Assertions.assertThat(sherlockValidate(s)).isEqualTo(YES);
    }

    @Test
    public void should_return_no_when_input_aaaac() {
        String s = "aaaac";
        Assertions.assertThat(sherlockValidate(s)).isEqualTo(YES);
    }

    @Test
    public void should_return_no_when_input_aaaabc() {
        String s = "aaaabc";
        Assertions.assertThat(sherlockValidate(s)).isEqualTo(NO);
    }

    private static String sherlockValidate(String s) {

        Integer[] freqs = s.chars().map(c -> c - 'a').collect(
                () -> {
                    Integer[] result = new Integer[26];
                    Arrays.fill(result, 0);
                    return result;
                },
                (x, y) -> {
                    x[y]++;
                },
                (a, b) -> {
                    for (int i = 0; i < a.length; i++) {
                        a[i] += b[i];
                    }
                }
        );

        Integer ref = 0;
        for (Integer f : freqs) {
            if (f > 0) {
                ref = f;
                break;
            }
        }

        boolean hasOneDeletion = false;

        for (Integer freq : freqs) {
            if (freq != 0) {
                int diff = Math.abs(freq - ref);
                if (diff == 0) {
                    continue;
                } else if (diff == 1) {
                    if (!hasOneDeletion) { //The diff is one character only and can be deleted
                        hasOneDeletion = true;
                    } else {
                       return NO; //The diff is one character only but one deletion has been done
                    }
                } else { // diff > 1
                    if (freq == 1 && !hasOneDeletion) {//It is a single character and can be deleted
                        hasOneDeletion = true;
                    } else {
                        return NO;
                    }
                }
            }

        }
        return YES;
    }
}
