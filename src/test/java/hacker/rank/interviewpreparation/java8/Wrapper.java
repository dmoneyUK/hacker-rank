package hacker.rank.interviewpreparation.java8;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Wrapper {

    @Test
    public void testWrapper(){
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        Integer c = a;
        a++;
        assertThat(a).isEqualTo(b);
        assertThat(a).isEqualTo(c);
        assertThat(a).isSameAs(c);
        //assertThat(b).isEqualTo(c);
        //assertThat(a).isSameAs(c);
        Map<Object, Object> objectObjectMap = Collections.unmodifiableMap(new HashMap<>());
    }



    @Test
    public void testPrimitive(){
        Integer a = 1;
        Integer b = 2;
        Integer c = a;
        a++;
        assertThat(a).isEqualTo(b);
        assertThat(a).isEqualTo(c);
        //assertThat(b).isEqualTo(c);
        //assertThat(a).isSameAs(c);
    }
}
