package hacker.rank.corejava;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamTest {
    
 
    @Ignore
    @Test
    public void testStreamSortLimit() {
        int[] arr = {6, 3, 5, 1, 8, 2, 4, 9, 7, 22, 11, 10};
        
        Random rd = new Random();
        IntStream intStream = IntStream.generate(() -> {
            int r = rd.nextInt(100);
            System.out.println("generated: " + r);
            return r;
        });
        
        List<Integer> result
                = intStream
                .filter(i -> {
                    System.out.println("Filter: " + i);
                    return i % 2 == 0;
                })
                .sorted() // Infinite stream cannot be sorted before bounded. Move it down below limit.
                .limit(5)
                .mapToObj(i -> {
                    System.out.println("map: " + i);
                    return i;
                })
                .collect(() -> new ArrayList<Integer>(),
                         (list, i) -> {
                             list.add(i);
                             System.out.println("added: " + i);
                         },
                         (listA, listB) ->
                         {
                             listA.addAll(listB);
                             System.out.println("listA: {" + listA + "} added listB: {" + listB + "}");
                         });
        System.out.println(result);
        
    }
    
}

