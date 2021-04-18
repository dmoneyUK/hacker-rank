package leetcode.amazon.stringarray;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class IntToRoman {
    
    @Test
    public void testSample1() {
        String s = intToRoman(3);
        assertThat(s).isEqualTo("III");
    }
    
    @Test
    public void testSample2() {
        String s = intToRoman(4);
        assertThat(s).isEqualTo("IV");
    }
    
    @Test
    public void testSample3() {
        String s = intToRoman(9);
        assertThat(s).isEqualTo("IX");
    }
    
    @Test
    public void testSample4() {
        String s = intToRoman(58);
        assertThat(s).isEqualTo("LVIII");
    }
    
    @Test
    public void testSample100() {
        String s = intToRoman(100);
        assertThat(s).isEqualTo("C");
    }
    
    @Test
    public void testSample1994() {
        String s = intToRoman(1994);
        assertThat(s).isEqualTo("MCMXCIV");
    }
    
    @Test
    public void testSample2000() {
        String s = intToRoman(2000);
        assertThat(s).isEqualTo("MM");
    }
    
    private String s = "";
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] handreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] last = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private Function<Integer, Integer> thousandsFunc = i -> {
        int remaining = i % 1000;
        s+=thousands[i / 1000];
        return remaining;
    };
    
    private Function<Integer, Integer> handredsFunc = i -> {
        int remaining = i % 100;
        s+=(handreds[i / 100]);
        return remaining;
    };
    
    private Function<Integer, Integer> tensFunc = i -> {
        int remaining = i % 10;
        s+=tens[i / 10];
        return remaining;
    };
    
    private Function<Integer, Integer> lastFunc = i -> {
        s+=last[i];
        return 0;
    };
    
    public String intToRoman(int num) {
        LinkedList<Integer> l  = new LinkedList<>();
        thousandsFunc.andThen(handredsFunc).andThen(tensFunc).andThen(lastFunc).apply(num);
        return s;
    }
    
}
