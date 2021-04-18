package leetcode.jpmorgan;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseInt {
    
    @Test
    public void testSample1() {
        assertThat(reverse(123)).isEqualTo(321);
    }
    
    @Test
    public void testSample2() {
        assertThat(reverse(-123)).isEqualTo(-321);
    }
    
    @Test
    public void testSample3() {
        assertThat(reverse(1534236469)).isEqualTo(0);
    }
    
    
    public int reverse(int x) {
    
        int remaining = x;
        int ans = 0;
        while (x != 0) {
            remaining = x % 10;
            int tmp = ans * 10 + remaining;
            if ((tmp - remaining) / 10 != ans)
            {return 0; }
            ans = tmp;
            x /= 10;
        }
        return ans;
    }
}
