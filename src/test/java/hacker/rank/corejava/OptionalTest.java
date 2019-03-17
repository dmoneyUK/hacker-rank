package hacker.rank.corejava;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class OptionalTest {

    String getDefault(){
        System.out.println("getDefault() print");
        return "defaultValue";
    }

    @Test
    public void testOrElse() {
        String nullName = "abc";
        String name = Optional.ofNullable(nullName).orElseGet(this::getDefault);
        System.out.println("orElseGet: "+ name);
        System.out.println("######");
        //assertEquals("defaultValue", name);

         name = Optional.ofNullable(nullName).orElse(getDefault());
        System.out.println("orElse: "+ name);


    }

    @Test
    public void increamentListInteger(){
        Integer[] arr = {0,1,2,3,4,5};

        List<Integer> l = Arrays.asList(arr);
        l.stream().forEach(i->{++i;
            System.out.println(i);});
        l.stream().forEach(System.out::print);

        Arrays.stream(arr).forEach(i -> arr[i]=++i);
        Arrays.stream(arr).forEach(System.out::print);
    }

    class MyTask extends Thread {

    }
}
