package leetcode.jpmorgan;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class NotAppearedLetterSearch {


    @Test
    public void testSample2() {

        String s = "A quick brown fox jumps over the lazy dog";
        int[] occurences = findOccurences(s);
        printNotAppeared(occurences);
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {

            System.out.println();
        }
    }

    private static int[] findOccurences(String input) {

        int[] ans = new int[26];
        input.chars().filter(c -> c != ' ').forEach(c -> {
            int lowerCaseC = Character.toLowerCase(c);
            int index = lowerCaseC - 'a';
            ans[index]++;
        });

        return ans;
    }

    private static void printNotAppeared(int[] occurences) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (occurences[i] == 0) {
                char c = (char) (i + 'a');
                sb.append(c);
            }
        }

        String s = sb.toString();
        if (s.isEmpty()) {
            s = "NULL";
        }
        System.out.println(s);
    }

}
