package hacker.rank.interviewpreparation.StringManipulating;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlernatingCharacters {

    @Test
    public void should_return_1_when_need_to_delete_1() {
        String s = "AA";

        Assertions.assertThat(alternatingCharacters(s)).isEqualTo(1);
    }

    @Test
    public void should_return_3_when_input_is_AAAA() {
        String s = "AAAA";
        Assertions.assertThat(alternatingCharacters(s)).isEqualTo(3);
    }

    @Test
    public void should_return_4_when_input_is_BBBBB() {
        String s = "BBBBB";
        Assertions.assertThat(alternatingCharacters(s)).isEqualTo(4);
    }

    @Test
    public void should_return_0_when_input_is_ABABABAB() {
        String s = "ABABABAB";
        Assertions.assertThat(alternatingCharacters(s)).isEqualTo(0);
    }

    @Test
    public void should_return_0_when_input_is_BABABA() {
        String s = "BABABA";
        Assertions.assertThat(alternatingCharacters(s)).isEqualTo(0);
    }

    @Test
    public void should_return_0_when_input_is_AAABBB() {
        String s = "AAABBB";
        Assertions.assertThat(alternatingCharacters(s)).isEqualTo(4);
    }

    int alternatingCharacters(String s) {

        char last = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == last) {
                result++;
            } else {
                last = c;
            }
        }
        return result;

    }

}
