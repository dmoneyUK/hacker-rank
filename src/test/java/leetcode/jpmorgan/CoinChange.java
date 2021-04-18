package leetcode.jpmorgan;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinChange {
    
    @Test
    public void testAmountLessThanZero() {
        
        int[] coins = {1, 2, 5};
        int amount = -2;
        
        int ans = coinChange(coins, amount);
        
        assertThat(ans).isEqualTo(-1);
    }
    
    @Test
    public void testAmountEqualsToZero() {
        
        int[] coins = {1, 2, 5};
        int amount = 0;
        
        int ans = coinChange(coins, amount);
        
        assertThat(ans).isEqualTo(0);
    }
    
    @Test
    public void tesCannotBeMadeUp() {
        
        int[] coins = {2};
        int amount = 3;
        
        int ans = coinChange(coins, amount);
        
        assertThat(ans).isEqualTo(-1);
    }
    
    @Test
    public void testSample1() {
        
        int[] coins = {1, 2, 5};
        int amount = 11;
        
        int ans = coinChange(coins, amount);
        
        assertThat(ans).isEqualTo(3);
    }
    
    
    @Test
    public void testTimeout() {
        
        int[] coins = {186, 419, 83,408};
        int amount = 6249;
        
        int ans = coinChange(coins, amount);
        
        assertThat(ans).isEqualTo(20);
    }
    
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    
    public int i = 0;
    
    //private int coinChangeRec(int[] coins, int amount, int[] dp) {
    //
    //    if (amount < 0) {
    //        return -1;
    //    }
    //    if (amount == 0) {
    //        return 0;
    //    }
    //    if (dp[amount] != 0) {
    //        return dp[amount];
    //    }
    //
    //    for (int coin : coins) {
    //        int res = coinChangeRec(coins, amount - coin, dp);
    //        if (res >= 0 && res < min) {
    //            min = res + 1;
    //        }
    //    }
    //
    //    dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
    //    return dp[amount];
    //
    //}
}
