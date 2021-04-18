package hacker.rank.interviewpreparation.hashmap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreqQuery {

    //public static void main(String[] args) throws IOException {
    //    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    //
    //    int q = Integer.parseInt(bufferedReader.readLine().trim());
    //
    //    int[][] queries = new int[q][2];
    //    IntStream.range(0, q).forEach(i -> {
    //        try {
    //            String[] s = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    //            queries[i][0] = Integer.valueOf(s[0]);
    //            queries[i][1] = Integer.valueOf(s[1]);
    //        } catch (IOException ex) {
    //            throw new RuntimeException(ex);
    //        }
    //    });
    //    List<Integer> ans = freqQuery(queries);
    //    System.out.println(ans);
    //
    //    //bufferedWriter.write(
    //    //        ans.stream()
    //    //           .map(Object::toString)
    //    //           .collect(joining("\n"))
    //    //                + "\n"
    //    //);
    //
    //    bufferedReader.close();
    //    //bufferedWriter.close();
    //}

    @Test
    public void freqQuery() {
        int[][] queries = {{1, 5}, {1, 6}, {3, 2}, {1, 10}, {1, 10}, {1, 6}, {2, 5}, {3, 2}};
        Map<Integer, Integer> valueToFreq = new HashMap<>();
        Map<Integer, Integer> freqs = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        Arrays.stream(queries)
              .forEach(query ->
                       {

                           if (query[0] == 3) {
                               int o = freqs.getOrDefault(query[1],0);
                               result.add(o > 0 ? 1 : 0);
                           } else {
                               int f = valueToFreq.getOrDefault(query[1], 0);
                               if (query[0] == 1) {
                                   valueToFreq.put(query[1], f + 1);
                                   freqs.merge(f + 1, 1, (x, y) -> x + y);
                                   freqs.merge(f, 0, (x, y) -> x > 0 ? x - 1 : 0);
                               } else if (query[0] == 2) {
                                   if (f > 0) {
                                       valueToFreq.put(query[1], f - 1);
                                       freqs.merge(f - 1, 1, (x, y) -> x + y);
                                       freqs.merge(f, 0, (x, y) -> x > 0 ? x - 1 : 0);
                                   }
                               }
                           }

                       });

        System.out.println(result);
    }
}

