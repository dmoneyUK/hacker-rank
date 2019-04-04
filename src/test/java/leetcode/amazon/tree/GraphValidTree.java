package leetcode.amazon.tree;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class GraphValidTree {
    
    @Test
    public void testSample1() {
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    
        boolean b = validTree(5, edges);
        
        assertTrue(b);
    }
    
    
    @Test
    public void testSample2() {
        int[][] edges = new int[][]{{0, 3}, {0, 2}, {3, 6}, {3, 4}, {2,5},{2,1},{6,1}};
        
        boolean b = validTree(7, edges);
        
        assertTrue(b);
    }
    
    @Test
    public void testCircle() {
        int[][] edges = new int[][]{{0, 1}, {1, 0}};
        
        boolean b = validTree(2, edges);
        
        assertFalse(b);
    }
    
    public boolean validTree(int n, int[][] edges) {
        
        if (n == 0 || edges == null) {
            return false;
        }
        
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            if(x==y) return false;
            
            nums[x] = y;
        }
    
        return edges.length == n - 1;
        
    }
    
    private int find(int[] nums, int i) {
        return nums[i] == -1 ? i : find(nums, nums[i]);
    }
}
