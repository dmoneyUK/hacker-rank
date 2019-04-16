package leetcode.jpmorgan;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class HappyNumber {
    
    @Test
    public void testSample1() {
        int input = 19;
        assertThat(isHappy(input)).isTrue();
    }
    
    public boolean isHappy(int n) {
        
        int[] occurences = new int[163];
        int remaining;
        while (occurences[n]==0) {
            occurences[n] = 1;
            int sqSum = 0;
            while (n > 0) {
                remaining = n % 10;
                sqSum += remaining * remaining;
                n /= 10;
            }
            if (sqSum == 1) {
                return true;
            }
            n = sqSum;
        }
        
        return false;
    }
}
