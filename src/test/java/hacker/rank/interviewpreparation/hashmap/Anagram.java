package hacker.rank.interviewpreparation.hashmap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    @Test
    public void anagram() {

        String s = "kkkk";
        int anagram = 0;
        //for (int i = 1; i < s.length(); i++) {
        //    for (int j = 0; j < s.length() - i; j++) {
        //        String s1 = s.substring(j, j + i);
        //        Map<Character, Integer> mapS1 =
        //                s1.chars()
        //                  .mapToObj(c -> (char) c)
        //                  .collect(HashMap::new,
        //                           (map, c) -> map.put(c, map.getOrDefault(c, 0) + 1),
        //                           (a, b) -> {
        //                           });
        //
        //        for (int k = j + 1; k <= s.length() - i; k++) {
        //            String s2 = s.substring(k, k + i);
        //            Map<Character, Integer> mapS2 =
        //                    s2.chars()
        //                      .mapToObj(c -> (char) c)
        //                      .collect(HashMap::new,
        //                               (map, c) -> map.put(c, map.getOrDefault(c, 0) + 1),
        //                               (a, b) -> {
        //                               });
        //
        //            if (mapS1.equals(mapS2)) {
        //                anagram++;
        //            }
        //        }
        //    }
        //}
        //System.out.println(anagram);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String s1 = s.substring(i, j);
                char[] chars = s1.toCharArray();
                Arrays.sort(chars);
                String sorted = String.valueOf(chars);

                int count = map.getOrDefault(sorted, 0);
                anagram+=count;
                map.put(sorted, ++count);

            }
        }
        System.out.println(anagram);
    }
}
