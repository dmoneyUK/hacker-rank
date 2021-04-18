package hacker.rank.interviewpreparation.hashmap;


import org.junit.jupiter.api.Test;

import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

public class TwoString {

    @Test
    public void testTwoString() {
        String s1 = "Hello";
        String s2 = "World";

        Set<Integer> set1 = s1.chars().boxed().collect(toSet());
        for (int c : s2.toCharArray()) {
            if (set1.contains(c)) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }

}
