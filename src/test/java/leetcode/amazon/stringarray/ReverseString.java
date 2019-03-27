package leetcode.amazon.stringarray;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseString {
    
    @Test
    public void test(){
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        assertThat(s).isEqualTo(new char[]{'o','l','l','e','h'});
    }
    
    public void reverseString(char[] s) {
       if(s.length>1) {
           char tmp;
           for (int i = 0; i < s.length / 2; i++) {
               tmp = s[i];
               s[i] = s[s.length - 1 - i];
               s[s.length - 1 - i] = tmp;
           }
       }
    }
}
