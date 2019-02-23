package hacker.rank.interviewpreparation.hashmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckMagzine {

    @Test
    public void checkMagzine() {
        String[] magazine = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
        String[] note = {"ive", "got", "some", "vfcoconuts"};

        Map<String, List<String>> dictionary = new HashMap<>();
        Arrays.stream(magazine).forEach(w -> {
            String key = w.substring(0, 1);
            List<String> values = dictionary.get(key);
            if (values == null) {
                values = new ArrayList<>();
                dictionary.put(key, values);
            }
            values.add(w);
        });

        for (String w : note) {
            String key = w.substring(0, 1);
            if (dictionary.get(key) == null || !dictionary.get(key).remove(w)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    @Test
    public void test() {

        int n = 6;

        String result = getRemaining(n);

        int max = 0;
        int temp = 0;
        for (char c : result.toCharArray()) {
            if (c == '1') {
                if (++temp > max) {
                    max = temp;
                }
            } else {
                temp = 0;
            }
        }

        System.out.println(result);
    }

    private String getRemaining(int n) {
        String s = String.valueOf(n % 2);
        if (n > 1) {
            return getRemaining(n / 2) + s;
        }
        return s;
    }
}

