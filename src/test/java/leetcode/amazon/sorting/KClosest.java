package leetcode.amazon.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class KClosest {
    
    @Test
    public void testSampe1() {
        int[][] arr = new int[][]{{1, 3}, {-2, 2}};
        int[][] ans = kClosest(arr, 1);
        
        assertThat(ans).isEqualTo(new int[][]{{-2, 2}});
    }
    @Test
    public void testSampe2() {
        int[][] arr = new int[][]{{3, 3}, {5, -1},{-2,4}};
        int[][] ans = kClosest(arr, 2);
        
        assertThat(ans).isEqualTo(new int[][]{{-2, 4},{3,3}});
    }
    
    public int[][] kClosest(int[][] points, int K) {
        
        quickSelectKCloest(points, 0, points.length - 1, K);
        
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private void quickSelectKCloest(int[][] points, int begin, int end, int k) {
        
        if (begin < end) {
            int pi = partition(points, begin, end);
            if (pi > k - 1) {
                quickSelectKCloest(points, begin, pi - 1, k);
            }else if (pi < k - 1) {
                quickSelectKCloest(points, pi + 1, end, k);
            }
        }
        
    }
    
    private int partition(int[][] points, int begin, int end) {
        
        int pivot = end;
        int i = begin;
        for (int j = begin; j < end; j++) {
            if (distanceOf(points[j]) < distanceOf(points[pivot])) {
                swap(points, i, j);
                i++;
            }
        }
        
        swap(points, i, end);
        
        return i;
        
    }
    
    private int distanceOf(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        if (i != j) {
            int[] tmp = points[i];
            points[i] = points[j];
            points[j] = tmp;
        }
    }
    
}
