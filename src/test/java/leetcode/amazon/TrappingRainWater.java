package leetcode.amazon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrappingRainWater {
    
    @Test
    public void testSample1() {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = trap(arr);
    }
    
    public int trap(int[] height) {
        
        int highest = Arrays.stream(height).max().getAsInt();
        List<Integer>[] array = new List[highest + 1];
        for (int i = 0; i < height.length; i++) {
            int value = height[i];
            if (array[value] == null) {
                array[value] = new ArrayList();
            }
            array[value].add(i);
        }
        
        int sum = 0;
        for (int i = 1; i <= highest; i++) {
            int first = array[i].get(0);
            int last = array.length;
            for (int k = array.length - 1; k > first; k--) {
                if(height[k]>i);
            }
            Integer block = 0;
            for (int j = i; j <= highest; j++) {
                block += array[j].stream().filter(index -> index > first && index < last).reduce(0, (a, b) -> a + 1);
            }
            sum += last - first - block;
        }
        
        return sum;
        
    }
}
