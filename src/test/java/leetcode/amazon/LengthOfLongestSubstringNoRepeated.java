package leetcode.amazon;

import org.junit.Test;

import java.util.HashMap;

public class LengthOfLongestSubstringNoRepeated {
    
    @Test
    public void test() {
        int re = lengthOfLongestSubstring("tmmzuxt");
        System.out.println(re);
    }
    
    public int lengthOfLongestSubstring(String s) {
        
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int begin = 0, end = 0; end < s.length(); end++) {
            char currentKey = s.charAt(end);
            if (map.containsKey(currentKey)) {
                begin = Math.max(map.get(currentKey) + 1, begin);
                
            }
            max = Math.max(max, end - begin + 1);
            map.put(currentKey, end);
        }
        return max;
        
    }
}
