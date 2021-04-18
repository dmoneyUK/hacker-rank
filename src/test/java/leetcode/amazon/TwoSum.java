package leetcode.amazon;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    @Test
    public void testTwoSum() {
        twoSum(new int[]{2,7,5,1},9);
    
    }
    
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int complement;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            
            map.put(nums[i], i);
        }
        
        throw new RuntimeException("Did not find pair.");
    }
}
