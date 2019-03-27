package leetcode.amazon.stringarray;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstUniqueCharacterInString {
    
    String s = "ddcb";
    
    @Test
    public void shouldReturn2() {
        assertThat(firstUniqCharOther(s)).isEqualTo(2);
    }
    public int firstUniqCharOther(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
    
}
