package leetcode.amazon;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestPalindromicSubstring {
    @Test
    public void shouldRetureA() {
        
        String s = "a";
        
        assertThat(longestPalindromeDP(s)).isEqualTo("a");
    }
    
    @Test
    public void shouldRetureCC() {
        
        String s = "accd";
        
        assertThat(longestPalindromeDP(s)).isEqualTo("cc");
    }
    
    @Test
    public void shouldRetureADA() {
        
        String s = "cada";
        
        assertThat(longestPalindromeDP(s)).isEqualTo("ada");
    }
    
    @Test
    public void shouldRetureEmpty() {
        
        String s = "";
        
        assertThat(longestPalindromeDP(s)).isEqualTo("");
    }
    
    public String longestPalindromeDP(String s) {
        boolean[][] mem = new boolean[1000][1000];
        int n = s.length();
        int start = 0;
        int max = 1;
        
        mem[n - 1][n - 1] = true;
        for (int i = 0; i < n - 1; i++) {
            mem[i][i] = true;
            if (s.charAt(i) == s.charAt(i + 1)) {
                mem[i][i + 1] = true;
                start = i;
                max = 2;
            }
        }
        
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                if (mem[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    mem[i][j] = true;
                    if (k > max) {
                        max = k;
                        start = i;
                    }
                }
            }
        }
        
        return s.substring(start, start + max);
        
    }
    
    public String longestPalindromeExepend(String s) {
        int n = s.length();
        if(n==0){
            return s;
        }
        
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expendAround(s, i, i);
            int len2 = expendAround(s, i, i + 1);
            int len = Math.max(len1,len2);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        
        return s.substring(start,end);
    }
    
    private int expendAround(String s, int left, int right) {
        int l = left;
        int r = right;
        
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        
        return r - l - 1;
    }
    
}
